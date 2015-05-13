package com.kavanj.marioai.nodes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by joe on 2015-05-12.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SequenceNodeTests
{

    @Test
    public void constructor_empty()
    {
        SequenceNode sn = new SequenceNode();

        assertThat("A SequenceNode instantiated with an empty constructor should have no subnodes",
                sn.subNodes, empty());
        assertTrue("A SequenceNode with no subnodes should always return true", sn.run());
    }

    @Test
    public void constructor_null() throws Exception
    {
        Collection<Node> nodes = new ArrayList<>();
        new SequenceNode(nodes);
//        SequenceNode sn = new SequenceNode();
    }
}
