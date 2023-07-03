import java.util.*;

public class LinkedList2Dummy {
    public Node head;
    public Node tail;
    private Node dummy;

    public LinkedList2Dummy() {
        dummy = new Node(0);
        dummy.next = dummy;
        dummy.prev = dummy;
        dummy.isDummy = true;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }  
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node current = this.dummy.next;
        while (current != null && !current.isDummy) {
            if (current.value == _value) {
                nodes.add(new Node(current.value));
            }
            current = current.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        if (this.head == null) {
            return false;
        }

        Node currentNode = this.dummy.next;
        while (currentNode != null && !currentNode.isDummy) {
            if (currentNode.value == _value && currentNode.next != null) {
                currentNode.next.prev = currentNode.prev;
            }
            if (currentNode.value == _value) {
                currentNode.prev.next = currentNode.next;
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public void removeAll(int value) {
        Node currentNode = dummy.next;
        while (!currentNode.isDummy) {
            if (currentNode.value == value) {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
            }
            currentNode = currentNode.next;
        }
    }

    public void clear() {
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public int count() {
        Node currentNode = this.head;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public void insertAfter(Node nodeAfter, Node nodeToInsert) {
        nodeToInsert.next = nodeAfter.next;
        nodeToInsert.prev = nodeAfter;
        nodeAfter.next.prev = nodeToInsert;
        nodeAfter.next = nodeToInsert;
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;
    public boolean isDummy;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
        this.isDummy = false;
    }
}
