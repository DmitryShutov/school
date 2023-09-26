package BST;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class BSTTest {

    @Test
    public void testTreeCreationWithoutNode() {
        BST<Integer> tree = new BST<Integer>(null);  
        assertEquals(0, tree.Count());
    }

    @Test
    public void testTreeCreationWithRoot() {
        BSTNode<Integer> node = new BSTNode<Integer>(1, null, null);
        BST<Integer> tree = new BST<Integer>(node);
        assertEquals(1, tree.Count());
        assertEquals(1, tree.Root.NodeKey);
        assertEquals(node, tree.FindNodeByKey(1).Node);
    }

    @Test
    public void testFindNodeByKeyNotFound() {
        BSTNode<Integer> root = new BSTNode<Integer>(1, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        assertEquals(1, tree.Count());
        assertEquals(1, tree.Root.NodeKey);
        assertEquals(false, tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(3, null);
        assertTrue(tree.FindNodeByKey(2).ToLeft);
        assertEquals(2, tree.Count());
        assertTrue(tree.FindNodeByKey(3).NodeHasKey);
    }

    @Test
    public void testAddKeyValue() {
        BSTNode<Integer> root = new BSTNode<Integer>(1, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        assertEquals(1, tree.Count());
        assertEquals(1, tree.Root.NodeKey);
        assertEquals(false, tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(2, null);
        assertEquals(2, tree.Count());
        assertTrue(tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(3, null);
        assertEquals(3, tree.Count());
        assertTrue(tree.FindNodeByKey(3).NodeHasKey);
    }

    @Test
    public void testFindMaxFromRoot() {
        BSTNode<Integer> root = new BSTNode<Integer>(1, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        assertEquals(1, tree.Count());
        assertEquals(1, tree.Root.NodeKey);
        assertEquals(false, tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(2, null);
        assertEquals(2, tree.Count());
        assertTrue(tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(3, null);
        assertEquals(3, tree.Count());
        assertTrue(tree.FindNodeByKey(3).NodeHasKey);
        assertEquals(3, tree.FinMinMax(tree.Root, true).NodeKey);
    }

    @Test
    public void testFindMaxRoot() {
        BSTNode<Integer> root = new BSTNode<Integer>(10, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        assertEquals(1, tree.Count());
        assertEquals(10, tree.Root.NodeKey);
        assertEquals(false, tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(2, null);
        assertEquals(2, tree.Count());
        assertTrue(tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(3, null);
        assertEquals(3, tree.Count());
        assertTrue(tree.FindNodeByKey(3).NodeHasKey);
        assertEquals(10, tree.FinMinMax(tree.Root, true).NodeKey);
    }

    @Test
    public void testFindMaxFromChild() {
        BSTNode<Integer> root = new BSTNode<Integer>(10, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        assertEquals(1, tree.Count());
        assertEquals(10, tree.Root.NodeKey);
        assertEquals(false, tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(2, null);
        assertEquals(2, tree.Count());
        assertTrue(tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(3, null);
        assertEquals(3, tree.Count());
        assertTrue(tree.FindNodeByKey(3).NodeHasKey);
        tree.AddKeyValue(1, null);
        assertEquals(4, tree.Count());
        assertTrue(tree.FindNodeByKey(1).NodeHasKey);
        assertEquals(3, tree.FinMinMax(tree.Root.LeftChild, true).NodeKey);
    }

    @Test
    public void testFindMinRoot() {
        BSTNode<Integer> root = new BSTNode<Integer>(10, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        assertEquals(1, tree.Count());
        assertEquals(10, tree.Root.NodeKey);
        assertEquals(false, tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(2, null);
        assertEquals(2, tree.Count());
        assertTrue(tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(3, null);
        assertEquals(3, tree.Count());
        assertTrue(tree.FindNodeByKey(3).NodeHasKey);
        tree.AddKeyValue(1, null);
        assertEquals(4, tree.Count());
        assertTrue(tree.FindNodeByKey(1).NodeHasKey);
        assertEquals(1, tree.FinMinMax(tree.Root, false).NodeKey);
    }

    @Test
    public void testFindMinFromChild() {
        BSTNode<Integer> root = new BSTNode<Integer>(10, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        assertEquals(1, tree.Count());
        assertEquals(10, tree.Root.NodeKey);
        assertEquals(false, tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(2, null);
        tree.AddKeyValue(3, null);
        tree.AddKeyValue(1, null);
        assertEquals(4, tree.Count());
        assertTrue(tree.FindNodeByKey(1).NodeHasKey);
        assertEquals(1, tree.FinMinMax(tree.Root.LeftChild, false).NodeKey);
    }

    @Test
    public void testDeleteNodeWithNoChild() {
        BSTNode<Integer> root = new BSTNode<Integer>(10, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        assertEquals(1, tree.Count());
        assertEquals(10, tree.Root.NodeKey);
        assertEquals(false, tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(2, null);
        tree.AddKeyValue(3, null);
        tree.AddKeyValue(1, null);
        assertEquals(4, tree.Count());
        assertTrue(tree.FindNodeByKey(1).NodeHasKey);
        assertEquals(1, tree.FinMinMax(tree.Root.LeftChild, false).NodeKey);
        tree.DeleteNodeByKey(1);
        assertEquals(3, tree.Count());
        assertEquals(false, tree.FindNodeByKey(1).NodeHasKey);
        assertEquals(2, tree.FinMinMax(tree.Root.LeftChild, false).NodeKey);
    }

    @Test
    public void testDeleteNodeInTheMiddle() {
        BSTNode<Integer> root = new BSTNode<Integer>(10, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        assertEquals(1, tree.Count());
        assertEquals(10, tree.Root.NodeKey);
        assertEquals(false, tree.FindNodeByKey(2).NodeHasKey);
        tree.AddKeyValue(2, null);
        tree.AddKeyValue(3, null);
        tree.AddKeyValue(1, null);
        assertEquals(4, tree.Count());
        assertTrue(tree.FindNodeByKey(1).NodeHasKey);
        assertEquals(1, tree.FinMinMax(tree.Root.LeftChild, false).NodeKey);
        tree.DeleteNodeByKey(2);
        assertEquals(3, tree.Count());
        assertEquals(false, tree.FindNodeByKey(2).NodeHasKey);
        assertEquals(3, tree.FinMinMax(tree.Root.LeftChild, true).NodeKey);
    }

    @Test
    public void testWideAllNodes() {
        BSTNode<Integer> root = new BSTNode<Integer>(10, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        tree.AddKeyValue(2, null);
        tree.AddKeyValue(3, null);
        tree.AddKeyValue(1, null);
        assertEquals(4, tree.Count());
        assertTrue(tree.FindNodeByKey(1).NodeHasKey);
        assertEquals(1, tree.FinMinMax(tree.Root.LeftChild, false).NodeKey);
        assertEquals(3, tree.FinMinMax(tree.Root.LeftChild, true).NodeKey);
        assertEquals(10, tree.FinMinMax(tree.Root, true).NodeKey);
        assertEquals(4, tree.WideAllNodes().size());
    }

    @Test
    public void testDeepAllNodesInOrder() {
        BSTNode<Integer> root = new BSTNode<Integer>(3, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        tree.AddKeyValue(2, null);
        tree.AddKeyValue(4, null);
        tree.AddKeyValue(5, null);
        assertEquals(4, tree.Count());
        ArrayList<BSTNode> nodes = tree.DeepAllNodes(ORDERS.IN_ORDER);
        assertEquals(2, nodes.get(0).NodeKey);
        assertEquals(3, nodes.get(1).NodeKey);
        assertEquals(4, nodes.get(2).NodeKey);
        assertEquals(5, nodes.get(3).NodeKey);
    }

    @Test
    public void testDeepAllNodesPostOrder() {
        BSTNode<Integer> root = new BSTNode<Integer>(3, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        tree.AddKeyValue(2, null);
        tree.AddKeyValue(4, null);
        tree.AddKeyValue(5, null);
        assertEquals(4, tree.Count());
        ArrayList<BSTNode> nodes = tree.DeepAllNodes(ORDERS.POST_ORDER);
        assertEquals(2, nodes.get(0).NodeKey);
        assertEquals(5, nodes.get(1).NodeKey);
        assertEquals(4, nodes.get(2).NodeKey);
        assertEquals(3, nodes.get(3).NodeKey);
    }

    @Test
    public void testDeepAllNodesPreOrder() {
        BSTNode<Integer> root = new BSTNode<Integer>(3, null, null);
        BST<Integer> tree = new BST<Integer>(root);
        tree.AddKeyValue(2, null);
        tree.AddKeyValue(4, null);
        tree.AddKeyValue(5, null);
        assertEquals(4, tree.Count());
        ArrayList<BSTNode> nodes = tree.DeepAllNodes(ORDERS.PRE_ORDER);
        assertEquals(3, nodes.get(0).NodeKey);
        assertEquals(2, nodes.get(1).NodeKey);
        assertEquals(4, nodes.get(2).NodeKey);
        assertEquals(5, nodes.get(3).NodeKey);
    }
}
