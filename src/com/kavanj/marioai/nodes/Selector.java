package com.kavanj.marioai.nodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by joe on 2015-05-12.
 */

/**
 * The Selector {@link Node} will iterate over each of it's subnodes until one returns true.
 * If it runs every subnode without one returning true, it will return false
 */
public class Selector extends ControlFlowNode
{

    /**
     * Iterates over all of this {@link Selector}'s subnodes until one returns true or it runs out of subnodes.
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
