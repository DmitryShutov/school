import java.util.*;

public class LinkedList2Dummy {
    private Node dummy;

    private boolean isDummy(Node node) {
        return node instanceof Dummy;
    }

    public Node getHead() {
        if (isDummy(dummy.next)) {
            return null;
        }
        return dummy.next;
    }

    public Node getTail() {
        if (isDummy(dummy.prev)) {
            return null;
        }
        return dummy.prev;
    }

    public LinkedList2Dummy() {
        dummy = new Dummy();
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public void addInTail(Node _item) {
        _item.prev = dummy.prev;
        _item.next = dummy;
        dummy.prev.next = _item;
        dummy.prev = _item;
    }

    public Node find(int _value) {
        Node current = dummy.next;
        while (!isDummy(current)) {
            if (current.value == _value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node current = dummy.next;
        while (!isDummy(current)) {
            if (current.value == _value) {
                nodes.add(new Node(current.value));
            }
            current = current.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node currentNode = this.dummy.next;
        while (!isDummy(currentNode)) {
            if (currentNode.value == _value) {
                currentNode.next.prev = currentNode.prev;
                currentNode.prev.next = currentNode.next;
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public void removeAll(int _value) {
        Node currentNode = dummy.next;
        while (!isDummy(currentNode)) {
            if (currentNode.value == _value) {
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
            }
            currentNode = currentNode.next;
        }
        dummy.next.prev = dummy;
    }

    public void clear() {
        dummy.next = dummy;
        dummy.prev = dummy;
    }

    public int count() {
        Node currentNode = dummy.next;
        int count = 0;
        while (!isDummy(currentNode)) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter != null) {
            _nodeToInsert.next = _nodeAfter.next;
            _nodeToInsert.prev = _nodeAfter;
            _nodeAfter.next.prev = _nodeToInsert;
            _nodeAfter.next = _nodeToInsert;
            return;
        }
        _nodeToInsert.next = dummy.next;
        _nodeToInsert.prev = dummy;
        dummy.next = _nodeToInsert;
    }
}
/*
 * 
 * class Node {
 * public int value;
 * public Node next;
 * public Node prev;
 * 
 * public Node(int _value) {
 * value = _value;
 * next = null;
 * prev = null;
 * }
 * }
 */

class Dummy extends Node {
    public Dummy() {
        super(0);
    }
}
