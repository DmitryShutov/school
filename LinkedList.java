import java.util.*;

public class LinkedList
{
     public Node head;
     public Node tail;

     public LinkedList()
     {
       head = null;
       tail = null;
     }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node currentNode = this.head;
        while(currentNode != null) {
            if (currentNode.value == _value) {
                nodes.add(new Node(currentNode.value));
            }
            currentNode = currentNode.next;
        }
        return nodes;
     }

     public boolean remove(int _value)
     {  
        if (this.head == null) return false;

        if (this.head.value == _value) {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
            return true;
        }
        Node currentNode = this.head;
        while(currentNode.next != null && currentNode.next.value != _value) {
            currentNode = currentNode.next;
        }

        if (currentNode.next != null && currentNode.next.value == _value) {
            currentNode.next = currentNode.next.next;
            if (currentNode.next == null) {
                this.tail = currentNode;
            }
        }

       return true;
     }

     public void removeAll(int _value)
     {
       if (this.head == null) return;

        if (this.head.value == _value) {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
        }
        Node currentNode = this.head;
        while(currentNode.next != null && currentNode.next.value != _value) {
            currentNode = currentNode.next;
            if (currentNode.next.value == _value) {
                currentNode.next = currentNode.next.next;
            if (currentNode.next == null) {
                this.tail = currentNode;
            }
        }
        }
     }

     public void clear()
     {
      this.head = null;
      this.tail = null;
     }

     public int count()
     {
        Node currentNode = this.head;
        int count = 0;
        while(currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
       return count;
     }

     public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
     {
       if (_nodeAfter == null) {
        _nodeToInsert.next = this.head;
        this.head = _nodeToInsert;
        return;
       }
       Node currentNode = this.head;
       while (currentNode != _nodeAfter) {
        currentNode = currentNode.next;
       }    
       _nodeToInsert.next = currentNode.next;
       currentNode.next = _nodeToInsert;
     }

     public static LinkedList sumLinkedList(LinkedList firstlist, LinkedList secondList) {
        LinkedList result = new LinkedList();
        if (firstlist.count() == secondList.count()) {
            Node currentFirstNode = firstlist.head;
            Node currentSecondNode = secondList.head;
            while (currentFirstNode.next != null) {
                int sum = currentFirstNode.value + currentSecondNode.value;
                result.addInTail(new Node(sum));
                currentFirstNode = currentFirstNode.next;
                currentSecondNode = currentSecondNode.next;
            }
            result.addInTail(new Node(firstlist.tail.value + secondList.tail.value));
        }
        return result;
     }

}

class Node
{
     public int value;
     public Node next;
     public Node(int _value) 
     {  
       value = _value;
       next = null;
     }
}
