package BalancedBST;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedBSTTest {
    @Test
    public void testLevelsForNodes() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        BalancedBST tree = new BalancedBST();
        tree.GenerateTree(a);
        assertEquals(0, tree.Root.Level);
        assertEquals(1, tree.Root.LeftChild.Level);
        assertEquals(1, tree.Root.RightChild.Level);
        assertEquals(2, tree.Root.LeftChild.LeftChild.Level);
        assertEquals(2, tree.Root.LeftChild.RightChild.Level);
        assertEquals(2, tree.Root.RightChild.LeftChild.Level);
        assertEquals(2, tree.Root.RightChild.RightChild.Level);
    }

    @Test
    public void testIsBalanced() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        BalancedBST tree = new BalancedBST();
        tree.GenerateTree(a);
        assertTrue(tree.IsBalanced(tree.Root));
    }

    @Test
    public void testIsBalancedCase() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 20, 10, 11};
        BalancedBST tree = new BalancedBST();
        tree.GenerateTree(a);
        assertTrue(tree.IsBalanced(tree.Root));
    }

    @Test
    public void testEmpty() {
        int[] a = {};
        BalancedBST tree = new BalancedBST();
        tree.GenerateTree(a);
        assertFalse(tree.IsBalanced(tree.Root));
    }
}
