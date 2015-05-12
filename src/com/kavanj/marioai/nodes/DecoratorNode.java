package com.kavanj.marioai.nodes;

/**
 * Created by joe on 2015-05-12.
 */

/**
 * A Decorator {@link Node} is similar to a {@link ControlFlowNode} in that it has a subnode.
 * However, it may only have one subnode, and it is expected to transform the subnode's output in some way.
 */
public abstract class DecoratorNode implements Node
{

    /**
     * The {@link DecoratorNode}'s child.
     */
    protected final Node child;

    /**
     * Creates a new {@link DecoratorNode} with {@code child} as it's child.
     *
     * @param child The {@link Node} that the {@link DecoratorNode} will use as it's child.
     */
    public DecoratorNode(Node child)
    {
        this.child = child;
    }
    
}
