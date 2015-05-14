package com.kavanj.marioai.nodes.pathfinding;

import com.kavanj.marioai.MarioAi;
import com.kavanj.marioai.nodes.Node;

/**
 * Created by joe on 2015-05-13.
 */
public class CanShootNode implements Node
{
    private final MarioAi agent;

    public CanShootNode(MarioAi agent)
    {
        this.agent = agent;
    }

    @Override
    public boolean run()
    {
        if (!agent.isAbleToShoot())
        {
            System.out.println("Can't shoot");
        }

        return agent.isAbleToShoot();
    }
}
