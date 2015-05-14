package com.kavanj.marioai.nodes.pathfinding;

import ch.idsia.benchmark.mario.engine.sprites.Mario;
import com.kavanj.marioai.MarioAi;
import com.kavanj.marioai.nodes.Node;

/**
 * Created by joe on 2015-05-13.
 */
public class RunNode implements Node
{
    private final MarioAi agent;
    private final boolean[] action;

    public RunNode(MarioAi agent, boolean[] action)
    {
        this.agent = agent;
        this.action = action;
    }

    @Override
    public boolean run()
    {
        action[Mario.KEY_SPEED] = true;
        return true;
    }
}
