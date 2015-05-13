package com.kavanj.marioai.nodes;

/**
 * Created by joe on 2015-05-12.
 */
public class StaticNode implements Node
{
    private final boolean returnValue;

    public StaticNode(boolean returnValue)
    {
        this.returnValue = returnValue;
    }

    @Override
    public boolean run()
    {
        return returnValue;
    }
}
