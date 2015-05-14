package com.kavanj.marioai.nodes.pathfinding;

import ch.idsia.benchmark.mario.engine.sprites.Mario;
import com.kavanj.marioai.nodes.Node;

/**
 * Created by joe on 2015-05-13.
 */
public class MoveNode implements Node
{
    private final boolean[] action;
    private final Direction direction;

    public MoveNode(boolean[] action, Direction direction)
    {
        this.action = action;
        this.direction = direction;
    }

    @Override
    public boolean run()
    {
        switch (direction)
        {
            case Forward:
                action[Mario.KEY_RIGHT] = true;
                action[Mario.KEY_LEFT] = false;
                break;
            case Reverse:
                action[Mario.KEY_LEFT] = true;
                action[Mario.KEY_RIGHT] = false;
                break;
        }

        return true;
    }

}
