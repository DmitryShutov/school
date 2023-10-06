package BalancedBST;

import java.util.Arrays;

class BSTNode {
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int Level; // глубина узла

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST {
    public BSTNode Root;

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {
        Arrays.sort(a);
        RecursiveGenerateTree(null, 0, a.length - 1, a, 0);
    }

    public BSTNode RecursiveGenerateTree(BSTNode parent, int start, int end, int[] a, int level) {
        if (start > end) {
            return null;
        }
        int pivot = (end + start) >>> 1;
        BSTNode currentNode = new BSTNode(a[pivot], parent);
        currentNode.Level = level;
        if (parent == null) {
            Root = currentNode;
        }
        currentNode.LeftChild = RecursiveGenerateTree(currentNode, start, pivot - 1, a, level + 1);
        currentNode.RightChild = RecursiveGenerateTree(currentNode, pivot + 1, end, a, level + 1);
        return currentNode;
    }

    public boolean IsBalanced(BSTNode root_node) {
        if (root_node == null) {
            return false;
        }
        if (root_node.LeftChild == null && root_node.RightChild == null) {
            return true;
        }
        if (root_node.LeftChild == null) {
            return root_node.RightChild.LeftChild == null && root_node.RightChild.RightChild == null;
        }
        if (root_node.RightChild == null) {
            return root_node.LeftChild.LeftChild == null && root_node.LeftChild.RightChild == null;
        }
        return IsBalanced(root_node.LeftChild) && IsBalanced(root_node.RightChild);
    }
}
