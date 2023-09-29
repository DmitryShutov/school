package aBST;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class aBSTTest {
    @Test
    public void testAddKeyValue() {
        aBST tree = new aBST(3);
        assertEquals(0, tree.AddKey(50));
        assertEquals(1, tree.AddKey(25));
        assertEquals(2, tree.AddKey(75));
        assertEquals(4, tree.AddKey(37));
        assertEquals(5, tree.AddKey(62));
        assertEquals(6, tree.AddKey(84));
        assertEquals(9, tree.AddKey(31));
        assertEquals(10, tree.AddKey(43));
        assertEquals(11, tree.AddKey(55));
    }

    @Test
    public void testFindKeyIndex() {
        aBST tree = new aBST(3);
        assertEquals(0, tree.AddKey(50));
        assertEquals(1, tree.AddKey(25));
        assertEquals(2, tree.AddKey(75));
        assertEquals(4, tree.AddKey(37));
        assertEquals(5, tree.AddKey(62));
        assertEquals(6, tree.AddKey(84));
        assertEquals(9, tree.AddKey(31));
        assertEquals(10, tree.AddKey(43));
        assertEquals(11, tree.AddKey(55));
        assertEquals(0, tree.FindKeyIndex(50));
        assertEquals(1, tree.FindKeyIndex(25));
        assertEquals(2, tree.FindKeyIndex(75));
        assertEquals(4, tree.FindKeyIndex(37));
        assertEquals(5, tree.FindKeyIndex(62));
        assertEquals(6, tree.FindKeyIndex(84));
        assertEquals(9, tree.FindKeyIndex(31));
        assertEquals(10, tree.FindKeyIndex(43));
        assertEquals(11, tree.FindKeyIndex(55));
    }

    @Test
    public void testEmptyTree() {
        aBST tree = new aBST(3);
        assertEquals(0, tree.FindKeyIndex(50));
    }
}
