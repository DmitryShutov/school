package SimpleTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleTreeTest {
    @Test
    public void testTreeCreationWithoutNode() {
        SimpleTree<Integer> tree = new SimpleTree<Integer>(null);
        assertEquals(0, tree.Count());
    }

    @Test
    public void testNotEmptyTreeCreation() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(node);
        assertEquals(1, tree.Count());
        assertEquals(1, tree.GetAllNodes().get(0).NodeValue);
    }

    @Test
    public void getAllNodesEmpty() {
        SimpleTree<Integer> tree = new SimpleTree<Integer>(null);
        assertEquals(0, tree.GetAllNodes().size());
    }

    @Test
    public void getAllNodesThreeNodes() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(3, root);
        tree.AddChild(root, node1);
        tree.AddChild(node1, node2);
        assertEquals(3, tree.GetAllNodes().size());
        assertEquals(1, tree.GetAllNodes().get(0).NodeValue);
        assertEquals(2, tree.GetAllNodes().get(1).NodeValue);
        assertEquals(3, tree.GetAllNodes().get(2).NodeValue);
    }

    @Test
    public void addNodesToRoot() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, root);
        tree.AddChild(root, node2);
        tree.AddChild(root, node3);
        assertEquals(3, tree.GetAllNodes().size());
        assertEquals(1, tree.GetAllNodes().get(0).NodeValue);
        assertEquals(2, tree.GetAllNodes().get(1).NodeValue);
        assertEquals(3, tree.GetAllNodes().get(2).NodeValue);
    }

    @Test
    public void testDeleteNode() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> child1 = new SimpleTreeNode<Integer>(2, null);
        SimpleTreeNode<Integer> child2 = new SimpleTreeNode<Integer>(3, null);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<Integer>(4, null);
        tree.AddChild(root, child1);
        tree.AddChild(child1, child2);
        tree.AddChild(child2, child3);
        tree.DeleteNode(child1);
        assertEquals(0, root.Children.size());
    }

    @Test
    public void testDeleteNodeSecondNode() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> child1 = new SimpleTreeNode<Integer>(2, null);
        SimpleTreeNode<Integer> child2 = new SimpleTreeNode<Integer>(3, null);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<Integer>(4, null);
        tree.AddChild(root, child1);
        tree.AddChild(child1, child2);
        tree.AddChild(child2, child3);
        tree.DeleteNode(child2);
        assertEquals(1, root.Children.size());
        assertEquals(2, root.Children.get(0).NodeValue);
        assertEquals(2, tree.GetAllNodes().size());
        assertEquals(2, tree.Count());
    }

    @Test
    public void testDeleteRoot() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        tree.DeleteNode(root);
        assertEquals(0, tree.Count());
    }

    @Test
    public void testDeleteRootsChilden() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> child1 = new SimpleTreeNode<Integer>(2, null);
        SimpleTreeNode<Integer> child2 = new SimpleTreeNode<Integer>(3, null);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<Integer>(4, null);
        tree.AddChild(root, child1);
        tree.AddChild(root, child2);
        tree.AddChild(root, child3);
        tree.DeleteNode(child3);
        assertEquals(3, tree.Count());
        assertEquals(1, tree.GetAllNodes().get(0).NodeValue);
        assertEquals(2, tree.GetAllNodes().get(1).NodeValue);
        assertEquals(3, tree.GetAllNodes().get(2).NodeValue);
        tree.DeleteNode(child2);
        assertEquals(2, tree.Count());
        assertEquals(1, tree.GetAllNodes().get(0).NodeValue);
        assertEquals(2, tree.GetAllNodes().get(1).NodeValue);
        tree.DeleteNode(child1);
        assertEquals(1, tree.Count());
        assertEquals(1, tree.GetAllNodes().get(0).NodeValue);
        assertEquals(1, tree.GetAllNodes().size());
        tree.DeleteNode(root);
        assertEquals(0, tree.Count());
    }

    @Test
    public void testFindByValueEmptyList() {
        SimpleTree<Integer> tree = new SimpleTree<Integer>(null);
        assertEquals(null, tree.FindNodesByValue(1));
    }

    @Test
    public void testFindByValueFewElements() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> child1 = new SimpleTreeNode<Integer>(2, null);
        SimpleTreeNode<Integer> child2 = new SimpleTreeNode<Integer>(3, null);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<Integer>(4, null);
        tree.AddChild(root, child1);
        tree.AddChild(root, child2);
        tree.AddChild(root, child3);
        assertEquals(1, tree.FindNodesByValue(1).size());
        assertEquals(1, tree.FindNodesByValue(1).get(0).NodeValue);
        assertEquals(1, tree.FindNodesByValue(2).size());
        assertEquals(2, tree.FindNodesByValue(2).get(0).NodeValue);
        assertEquals(1, tree.FindNodesByValue(3).size());
        assertEquals(3, tree.FindNodesByValue(3).get(0).NodeValue);
        assertEquals(1, tree.FindNodesByValue(4).size());
        assertEquals(4, tree.FindNodesByValue(4).get(0).NodeValue);
        assertEquals(null, tree.FindNodesByValue(5));
    }

    @Test
    public void testFindByValueAllValues() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> child1 = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> child2 = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<Integer>(1, null);
        tree.AddChild(root, child1);
        tree.AddChild(root, child2);
        tree.AddChild(root, child3);
        assertEquals(4, tree.FindNodesByValue(1).size());
        assertEquals(1, tree.FindNodesByValue(1).get(0).NodeValue);
        assertEquals(1, tree.FindNodesByValue(1).get(1).NodeValue);
        assertEquals(1, tree.FindNodesByValue(1).get(2).NodeValue);
        assertEquals(1, tree.FindNodesByValue(1).get(3).NodeValue);
    }

    @Test
    public void testLeafCountOnlyRoot() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        assertEquals(1, tree.LeafCount());
    }

    @Test
    public void testLeafCountAllRootsChildren() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> child1 = new SimpleTreeNode<Integer>(2, null);
        SimpleTreeNode<Integer> child2 = new SimpleTreeNode<Integer>(3, null);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<Integer>(4, null);
        tree.AddChild(root, child1);
        tree.AddChild(root, child2);
        tree.AddChild(root, child3);
        assertEquals(3, tree.LeafCount());
    }

    @Test
    public void testLeafCountOneBranchTree() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> child1 = new SimpleTreeNode<Integer>(2, null);
        SimpleTreeNode<Integer> child2 = new SimpleTreeNode<Integer>(3, null);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<Integer>(4, null);
        tree.AddChild(root, child1);
        tree.AddChild(child1, child2);
        tree.AddChild(child2, child3);
        assertEquals(1, tree.LeafCount());
    }

    @Test
    public void testMoveNode() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> child1 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> child2 = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<Integer>(4, child1);
        tree.AddChild(root, child1);
        tree.AddChild(root, child2);
        tree.AddChild(child1, child3);
        tree.MoveNode(child1, child2);
        assertEquals(4, tree.Count());
        assertEquals(child2, child1.Parent);
        assertEquals(1, child2.Children.size());
        assertEquals(child1, child2.Children.get(0));
    }

    @Test
    public void testRemoveAndCountLeafes() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> child1 = new SimpleTreeNode<Integer>(2, root);
        SimpleTreeNode<Integer> child2 = new SimpleTreeNode<Integer>(3, root);
        SimpleTreeNode<Integer> child3 = new SimpleTreeNode<Integer>(4, child1);
        tree.AddChild(root, child1);
        tree.AddChild(root, child2);
        tree.AddChild(child1, child3);
        assertEquals(2, tree.LeafCount());
        tree.DeleteNode(child2);
        assertEquals(1, tree.LeafCount());
        tree.DeleteNode(child3);
        assertEquals(1, tree.LeafCount());
        tree.DeleteNode(child1);
        assertEquals(1, tree.LeafCount());
    }

    @Test
    public void testCountLeafesAfterRemoving() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<Integer>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<Integer>(root);
        SimpleTreeNode<Integer> child1 = new SimpleTreeNode<Integer>(2, root);
        tree.AddChild(root, child1);
        tree.DeleteNode(child1);
        assertEquals(1, tree.LeafCount());
    }

    @Test
    public void testEvenTrees() {
        SimpleTreeNode<Integer> node1 = new SimpleTreeNode<Integer>(1, null);
        SimpleTreeNode<Integer> node2 = new SimpleTreeNode<Integer>(2, node1);
        SimpleTreeNode<Integer> node3 = new SimpleTreeNode<Integer>(3, node1);
        SimpleTreeNode<Integer> node4 = new SimpleTreeNode<Integer>(4, node2);
        SimpleTreeNode<Integer> node5 = new SimpleTreeNode<Integer>(5, node2);
        SimpleTreeNode<Integer> node6 = new SimpleTreeNode<Integer>(6, node3);

        SimpleTree<Integer> tree = new SimpleTree<Integer>(node1);
        tree.AddChild(node1, node2);
        tree.AddChild(node1, node3);
        tree.AddChild(node2, node4);
        tree.AddChild(node2, node5);
        tree.AddChild(node3, node6);

        ArrayList<Integer> edgesToRemove = tree.EvenTrees();

        assertTrue(edgesToRemove.contains(node1.NodeValue));
        assertTrue(edgesToRemove.contains(node3.NodeValue));
    }
}
