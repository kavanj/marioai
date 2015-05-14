package com.kavanj.marioai.nodes.control;

import com.kavanj.marioai.nodes.Node;
import com.kavanj.marioai.nodes.StaticNode;
import com.kavanj.marioai.nodes.control.SelectorNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by joe on 2015-05-12.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SelectorNodeTests
{
    private static final Collection<Node> EMPTY_COLLECTION = Collections.emptyList();

    @Test
    public void constructor_empty()
    {
        SelectorNode sn = new SelectorNode(EMPTY_COLLECTION);

        boolean result = sn.run();

        assertThat("A SelectorNode instantiated with an empty constructor should have no subnodes",
                   sn.subNodes, empty());

        assertFalse("A SelectorNode with no subnodes should always return true", result);
    }

    @Test
    public void one_true()
    {
        Node sn = new SelectorNode(StaticNode.TRUE_NODE);

        boolean result = sn.run();

        assertTrue("A SelectorNode with a single child that returns true should return true", result);
    }

    @Test
    public void one_false() throws Exception
    {
        Node sn = new SelectorNode(StaticNode.FALSE_NODE);

        boolean result = sn.run();

        assertFalse("A SelectorNode with a single child that returns false should return false", result);
    }

}
