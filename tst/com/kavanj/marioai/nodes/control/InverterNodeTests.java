package com.kavanj.marioai.nodes.control;

import com.kavanj.marioai.nodes.StaticNode;
import com.kavanj.marioai.nodes.control.InverterNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.*;


/**
 * Created by joe on 2015-05-13.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class InverterNodeTests
{

    @Test( expected = IllegalArgumentException.class)
    public void constructor_null()
    {
        new InverterNode(null);
    }

    @Test
    public void true_child()
    {
        InverterNode in = new InverterNode(StaticNode.TRUE_NODE);

        boolean result = in.run();

        assertFalse("An InverterNode with a child that returns true should return false", result);
    }

    @Test
    public void false_child()
    {
        InverterNode in = new InverterNode(StaticNode.FALSE_NODE);

        boolean result = in.run();

        assertTrue("An InverterNode with a child that returns true should return false", result);
    }
}
