package com.kavanj.marioai;

import ch.idsia.agents.Agent;
import ch.idsia.benchmark.mario.engine.GeneralizerLevelScene;
import ch.idsia.benchmark.mario.engine.sprites.Mario;
import ch.idsia.benchmark.mario.engine.sprites.Sprite;
import ch.idsia.benchmark.mario.environments.Environment;
import com.kavanj.marioai.nodes.Node;
import com.kavanj.marioai.nodes.control.InverterNode;
import com.kavanj.marioai.nodes.control.SelectorNode;
import com.kavanj.marioai.nodes.control.SequenceNode;
import com.kavanj.marioai.nodes.pathfinding.*;


/**
 * Created by joe on 2015-05-11.
 */
public class MarioAi implements Agent
{
    int zLevelScene = 1;
    int zLevelEnemies = 0;
    private String name;
    private Environment environment;
    private boolean[] action;
    private byte[][] levelScene;
    private byte[][] enemies;

    static final byte COIN = 2;

    private int receptiveFieldWidth;
    private int receptiveFieldHeight;
    private int marioEgoRow;
    private int marioEgoCol;

    private final Node coinNear = new CoinNearNode(this);
    private final Node onGround = new OnGroundNode(this);
    private final Node canJump = new CanJumpNode(this);
    private final Node canShoot = new CanShootNode(this);

    public MarioAi()
    {
        setName(MarioAi.class.getName());
    }

    @Override
    public boolean[] getAction()
    {
        reset();

        Node forward = new MoveNode(action, Direction.Forward);
        Node jump = new JumpNode(this, action);
        Node run = new RunNode(this, action);


        Node smartJump = new SequenceNode(
                new SelectorNode(
                        new InverterNode(onGround),
                        canJump
                ),
                jump
        );

        Node smartRun = new SequenceNode(
                new SelectorNode(
                        canShoot,
                        coinNear,
                        run
                ),
                forward
        );

        Node walkForward = new SequenceNode(
                new InverterNode(new PathObstructedNode(this, Direction.Forward)),
                forward,
                smartRun
        );

        Node topNode = new SelectorNode(
                walkForward,
                new SequenceNode(
                        smartJump,
                        forward)
        );


        topNode.run();

        return action;
    }

    @Override
    public void integrateObservation(Environment environment)
    {
        this.environment = environment;
        levelScene = environment.getLevelSceneObservationZ(zLevelScene);
        enemies = environment.getEnemiesObservationZ(zLevelEnemies);
    }

    @Override
    public void giveIntermediateReward(float intermediateReward)
    {

    }

    @Override
    public void reset()
    {
        action = new boolean[Environment.numberOfKeys];
    }

    @Override
    public void setObservationDetails(int rfWidth, int rfHeight, int egoRow, int egoCol)
    {
        receptiveFieldWidth = rfWidth;
        receptiveFieldHeight = rfHeight;

        marioEgoRow = egoRow;
        marioEgoCol = egoCol;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isPathObstructed(Direction direction)
    {
        int directionMultiplier = direction == Direction.Forward ? 1 : -1;

        return obsticleAt(marioEgoRow, marioEgoCol)
                || obsticleAt(marioEgoRow, marioEgoCol + 1 * directionMultiplier)
                || obsticleAt(marioEgoRow, marioEgoCol + 2 * directionMultiplier)
                || enemyAt(marioEgoRow, marioEgoCol + 1)
                || enemyAt(marioEgoRow, marioEgoCol + 1);
    }

    public boolean isAbleToJump()
    {
        return environment.isMarioAbleToJump();
    }


    public byte getLevelFieldCellValue(int x, int y)
    {
        if (x < 0 || x >= levelScene.length || y < 0 || y >= levelScene[0].length)
        {
            return 0;
        }

        return levelScene[x][y];
    }

    public byte getEnemyFieldCellValue(int x, int y)
    {
        if (x < 0 || x >= enemies.length || y < 0 || y >= enemies[0].length)
        {
            return 0;
        }

        return enemies[x][y];
    }

    public boolean obsticleAt(int x, int y)
    {
        return isObsticle(getLevelFieldCellValue(x, y));
    }

    public boolean isObsticle(byte code)
    {
        return code == GeneralizerLevelScene.BRICK
                || code == GeneralizerLevelScene.BORDER_CANNOT_PASS_THROUGH
                || code == GeneralizerLevelScene.BORDER_HILL
                || code == GeneralizerLevelScene.FLOWER_POT_OR_CANNON;
    }

    public boolean enemyAt(int x, int y)
    {
        return isEnemy(getEnemyFieldCellValue(x, y));
    }

    public boolean isEnemy(byte code)
    {
        return code != 0 &&
                (
                        code == Sprite.KIND_GOOMBA
                                || code == Sprite.KIND_GOOMBA_WINGED
                                || code == Sprite.KIND_RED_KOOPA
                                || code == Sprite.KIND_RED_KOOPA_WINGED
                                || code == Sprite.KIND_GREEN_KOOPA
                                || code == Sprite.KIND_GREEN_KOOPA_WINGED
                                || code == Sprite.KIND_BULLET_BILL
                                || code == Sprite.KIND_SPIKY
                                || code == Sprite.KIND_SPIKY_WINGED
                                || code == Sprite.KIND_ENEMY_FLOWER
                                || code == Sprite.KIND_WAVE_GOOMBA
                                || code == Sprite.KIND_SHELL
                );
    }

    public boolean thingExists(byte code)
    {
        for (int i = 0; i < levelScene.length; ++i)
        {
            for (int j = 0; j < levelScene[i].length; ++j)
            {
                if (getLevelFieldCellValue(i, j) == code)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean coinNear()
    {
        return thingExists(COIN);
    }

    public boolean isMarioOnGround()
    {
        return environment.isMarioOnGround();
    }

    public boolean isAbleToShoot()
    {
        return environment.isMarioAbleToShoot() && Mario.fire;
    }

}
