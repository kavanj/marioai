package com.kavanj.marioai.nodes.pathfinding;

import com.kavanj.marioai.MarioAi;
import com.kavanj.marioai.nodes.Node;

/**
 * Created by joe on 2015-05-13.
 */
public class OnGroundNode implements Node
{
    private final MarioAi agent;

    public OnGroundNode(MarioAi agent)
    {
        this.agent = agent;
    }

    @Override
    public boolean run()
    {
        return agent.isMarioOnGround();
    }
}
