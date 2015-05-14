package com.kavanj.marioai.nodes.control;

import com.kavanj.marioai.nodes.Node;

/**
 * Created by joe on 2015-05-12.
 */
public class InverterNode extends DecoratorNode
{

    /**
     * Creates a new instance of {@link InverterNode} using {@code child} as it's child
     *
     * @param child
     *         The {@link Node} that will be used as this {@link InverterNode}'s child
     */
    public InverterNode(Node child)
    {
        super(child);
    }

    /**
     * Inverts the result of this {@link InverterNode}'s child.
     *
     * @return {@code true} if {@code child.run()} returns {@code false}, {@code false} if {@code child.run()} returns
     * {@code true}
     */
    @Override
    public boolean run()
    {
        return !child.run();
    }
}
