package com.kavanj.marioai.nodes.control;

import com.kavanj.marioai.nodes.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by joe on 2015-05-12.
 */

/**
 * A {@link Node} that is used run other nodes.
 */
public abstract class ControlFlowNode implements Node
{
    /**
     * The {@link Collection} of subnodes
     */
    protected final Collection<Node> subNodes;

    /**
     * Creates a new {@link ControlFlowNode} using a collection of Nodes.
     *
     * @param nodes
     *         A collection of nodes that will be this node's subnodes
     */
    public ControlFlowNode(Collection<Node> nodes)
    {
        this.subNodes = new ArrayList<>(nodes);
    }

    /**
     * Creates a new {@link ControlFlowNode} using an array of Nodes.
     *
     * @param nodes
     *         An array of nodes that will be this node's subnodes
     */
    public ControlFlowNode(Node... nodes)
    {
        this(Arrays.asList(nodes));
    }
}
