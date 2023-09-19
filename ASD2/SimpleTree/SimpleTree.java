package SimpleTree;

import java.util.*;

class SimpleTreeNode<T>
{
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null
	
    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
      NodeValue = val;
      Parent = parent;
      Children = null;
    }
}

public class SimpleTree<T> {
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root)
    {
      Root = root;
    }
	
    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        if (ParentNode.Children == null) {
            ParentNode.Children = new ArrayList<SimpleTreeNode<T>>();
        }
        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
      if (NodeToDelete == Root) {
        Root = null;
        return;
      }
      Queue<SimpleTreeNode<T>> queue = new LinkedList<>();
      queue.add(Root);
      
      while (!queue.isEmpty()) {
          SimpleTreeNode<T> currentNode = queue.poll();

          if (currentNode.Children != null) {
              if (currentNode.Children.contains(NodeToDelete)) {
                  currentNode.Children.remove(NodeToDelete);
                  return;
              }
              queue.addAll(currentNode.Children);
          }
      }
    }

   public List<SimpleTreeNode<T>> GetAllNodes()
    {   
        ArrayList<SimpleTreeNode<T>> list = new ArrayList<SimpleTreeNode<T>>();
        return this.RecursiveGetAllNodes(list, Root);
    }

    private List<SimpleTreeNode<T>> RecursiveGetAllNodes(List<SimpleTreeNode<T>> list, SimpleTreeNode<T> currentNode) {
      if (currentNode != null) {
        list.add(currentNode);
      }
      if (currentNode == null || currentNode.Children == null) {
          return list;
      }
      for (SimpleTreeNode<T> child : currentNode.Children) {
          RecursiveGetAllNodes(list, child);
      }
      return list;
  }
	
   public List<SimpleTreeNode<T>> FindNodesByValue(T val)
   {
      List<SimpleTreeNode<T>> result = new ArrayList<SimpleTreeNode<T>>();
      this.GetAllNodes().forEach((SimpleTreeNode<T> node) -> {
        if (node.NodeValue == val) {
          result.add(node);
        }
      });
      return result.size() > 0 ? result : null;
   }

   public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
      if (OriginalNode == Root) {
        return;
      }
      DeleteNode(OriginalNode);
      AddChild(NewParent, OriginalNode);
    }
   
    public int Count()
    {
	    return calcRecursiveCount(Root);
    }

    public int calcRecursiveCount(SimpleTreeNode<T> currentNode) {
      if (currentNode == null) {
        return 0;
      }
      int count = 1;
      if (currentNode.Children != null) {
        for (SimpleTreeNode<T> child : currentNode.Children) {
          count += calcRecursiveCount(child);
        }
      }
      return count;
    }

    public int LeafCount()
    {
      List<SimpleTreeNode<T>> allNodes = this.GetAllNodes();
      int count = 0;
      for (SimpleTreeNode<T> node : allNodes) {
        if (node.Children == null) {
          count++;
        }
      }
	    return count;
    }
}
