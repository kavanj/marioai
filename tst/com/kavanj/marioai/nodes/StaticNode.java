package com.kavanj.marioai.nodes;

/**
 * Created by joe on 2015-05-12.
 */
public class StaticNode implements Node
{
    public static final StaticNode TRUE_NODE = new StaticNode(true);
    public static final StaticNode FALSE_NODE = new StaticNode(false);

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
