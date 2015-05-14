package com.kavanj.marioai.nodes.control;

/**
 * Created by joe on 2015-05-12.
 */

import com.kavanj.marioai.nodes.Node;

import java.util.Collection;

/**
 * A SequenceNode {@link Node} will iterate over each of it's subnodes until one returns false.
 */
public class SequenceNode extends ControlFlowNode
{

    public SequenceNode(Collection<Node> nodes)
    {
        super(nodes);
    }

    public SequenceNode(Node... nodes)
    {
        super(nodes);
    }

    /**
     * Iterates over each of the {@link SequenceNode}'s subnodes until one returns false or it runs out of nodes.
     *
     * @return true if all of the {@link SequenceNode}'s subnodes return true or false if any subnode returns false.
     */
    @Override
    public boolean run()
    {
        for (Node node : subNodes)
        {
            if (!node.run())
            {
                return false;
            }
        }

        return true;
    }
}
