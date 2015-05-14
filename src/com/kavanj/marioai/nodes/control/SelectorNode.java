package com.kavanj.marioai.nodes.control;

/**
 * Created by joe on 2015-05-12.
 */

import com.kavanj.marioai.nodes.Node;

import java.util.Collection;

/**
 * The SelectorNode {@link Node} will iterate over each of it's subnodes until one returns true. If it runs every
 * subnode without one returning true, it will return false
 */
public class SelectorNode extends ControlFlowNode
{

    public SelectorNode(Collection<Node> nodes)
    {
        super(nodes);
    }

    public SelectorNode(Node... nodes)
    {
        super(nodes);
    }

    /**
     * Iterates over all of this {@link SelectorNode}'s subnodes until one returns true or it runs out of subnodes.
     *
     * @return true if any subnode returns true, false if none return true
     */
    @Override
    public boolean run()
    {
        for (Node node : subNodes)
        {
            if (node.run())
            {
                return true;
            }
        }

        return false;
    }
}
