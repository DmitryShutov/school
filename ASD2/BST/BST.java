package BST;

import java.io.*;
import java.util.*;

class BSTNode<T>
{
    public int NodeKey; 
    public T NodeValue; 
    public BSTNode<T> Parent;
    public BSTNode<T> LeftChild; 
    public BSTNode<T> RightChild; 

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
      NodeKey = key;
      NodeValue = val;
      Parent = parent;
      LeftChild = null;
      RightChild = null;
    }
}


class BSTFind<T>
{
   
    public BSTNode<T> Node;

    public boolean NodeHasKey;
	
    public boolean ToLeft;
	
    public BSTFind() { Node = null; }
}

class BST<T>
{
    BSTNode<T> Root;
    private int count = 0;
	
    public BST(BSTNode<T> node)
    {
      Root = node;
      if (node != null) {
        this.count++;
      }
    }
	
    public BSTFind<T> FindNodeByKey(int key)
    {   
        if(Root != null) {
            return FindNodeByKeyRecursive(key, Root);
        }
      return new BSTFind<T>();
    }

    private BSTFind<T> FindNodeByKeyRecursive(int key, BSTNode<T> currentNode) {
        if (currentNode.NodeKey == key) {
            BSTFind<T> result = new BSTFind<T>();
            result.Node = currentNode;
            result.NodeHasKey = true;
            return result;
        }

        if (key < currentNode.NodeKey && currentNode.LeftChild == null) {
            BSTFind<T> result = new BSTFind<T>();
            result.NodeHasKey = false;
            result.Node = currentNode;
            result.ToLeft = true;
            return result;
        }

        if (key >= currentNode.NodeKey && currentNode.RightChild == null) {
            BSTFind<T> result = new BSTFind<T>();
            result.NodeHasKey = false;
            result.Node = currentNode;
            result.ToLeft = false;
            return result;
        }

        if (key < currentNode.NodeKey) {
            return FindNodeByKeyRecursive(key, currentNode.LeftChild);
        } 
        return FindNodeByKeyRecursive(key, currentNode.RightChild);
    }
	
    public boolean AddKeyValue(int key, T val)
    {
        if (Root == null) {
            Root = new BSTNode<T>(key, val, null);
            this.count++;
            return true;
        }

        BSTFind<T> findResult = FindNodeByKey(key);
        if (findResult.NodeHasKey) {
            return false;
        }

        if (findResult.ToLeft) {
            findResult.Node.LeftChild = new BSTNode<T>(key, val, findResult.Node);
            this.count++;
        } else {
            findResult.Node.RightChild = new BSTNode<T>(key, val, findResult.Node);
            this.count++;
        }
        return true;
    }
	
    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)
    {
        if (FindMax) {
            if (FromNode.RightChild == null) {
                return FromNode;
            }
            return FinMinMax(FromNode.RightChild, FindMax);
        } else {
            if (FromNode.LeftChild == null) {
                return FromNode;
            }
            return FinMinMax(FromNode.LeftChild, FindMax);
        }
    }

    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> findResult = FindNodeByKey(key);
        if (!findResult.NodeHasKey) {
            return false;
        }
        boolean noChild = findResult.Node.LeftChild == null && findResult.Node.RightChild == null;
        if (noChild && findResult.Node == Root) {
            Root = null;
            this.count = 0;
            return true;
        }
        if (noChild && findResult.Node.Parent.LeftChild == findResult.Node) {
            findResult.Node.Parent.LeftChild = null;
            this.count--;
            return true;
        }
        if (noChild) {
            findResult.Node.Parent.RightChild = null;
            this.count--;
            return true;
        }
        if (findResult.Node.RightChild != null) {
            BSTNode<T> minNode = FinMinMax(findResult.Node.RightChild, false);
            findResult.Node.NodeKey = minNode.NodeKey;
            findResult.Node.NodeValue = minNode.NodeValue;
            if (minNode.Parent.LeftChild == minNode) {
                minNode.Parent.LeftChild = null;
                this.count--;
                return true;
            }
            minNode.Parent.RightChild = null;
            this.count--;
            return true;
        } 

        return false;
    }
 
    public int Count()
    {
      return this.count; 
    }

    public ArrayList<BSTNode> WideAllNodes() {
        ArrayList<BSTNode> result = new ArrayList<BSTNode>();
        Queue<BSTNode> queue = new LinkedList<BSTNode>();
        queue.add(Root);
        while (!queue.isEmpty()) {
            BSTNode node = queue.poll();
            result.add(node);
            if (node.LeftChild != null) {
                queue.add(node.LeftChild);
            }
            if (node.RightChild != null) {
                queue.add(node.RightChild);
            }
        }
        return result;
    }

    public ArrayList<BSTNode> DeepAllNodes(int order) {
        if (order == 0) {
            return this.DeepAllNodesInOrder(Root);
        }
        if (order == 1) {
            return this.DeepAllNodesPostOrder(Root);
        }
        if (order == 2) {
            return this.DeepAllNodesPreOrder(Root);
        }  
        return new ArrayList<>();
    }

    private ArrayList<BSTNode> DeepAllNodesInOrder(BSTNode node) {
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        if(node.LeftChild != null) {
            list.addAll(DeepAllNodesInOrder(node.LeftChild));
        }
        list.add(node);
        if(node.RightChild != null) {
            list.addAll(DeepAllNodesInOrder(node.RightChild));
        }
        return list;
    }
     
    private ArrayList<BSTNode> DeepAllNodesPostOrder(BSTNode node) {
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        if(node.LeftChild != null) {
            list.addAll(DeepAllNodesPostOrder(node.LeftChild));
        }
        if(node.RightChild != null) {
            list.addAll(DeepAllNodesPostOrder(node.RightChild));
        }
        list.add(node);
        return list;
    }

    private ArrayList<BSTNode> DeepAllNodesPreOrder(BSTNode node) {
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        list.add(node);
        if(node.LeftChild != null) {
            list.addAll(DeepAllNodesPreOrder(node.LeftChild));
        }
        if(node.RightChild != null) {
            list.addAll(DeepAllNodesPreOrder(node.RightChild));
        }
        return list;
    }
}
