package com.kavanj.marioai.nodes;

/**
 * Created by joe on 2015-05-12.
 */

/**
 * A SequenceNode {@link Node} will iterate over each of it's subnodes until one returns false.
 */
public class SequenceNode extends ControlFlowNode
{

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
