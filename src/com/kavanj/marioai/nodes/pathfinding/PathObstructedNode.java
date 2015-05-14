package com.kavanj.marioai.nodes.pathfinding;

import com.kavanj.marioai.MarioAi;
import com.kavanj.marioai.nodes.Node;

/**
 * Created by joe on 2015-05-13.
 */
public class PathObstructedNode implements Node
{
    private final MarioAi agent;
    private final Direction direction;

    public PathObstructedNode(MarioAi agent, Direction direction)
    {
        this.agent = agent;
        this.direction = direction;
    }

    @Override
    public boolean run()
    {
        return agent.isPathObstructed(direction);
    }
}
