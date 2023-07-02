import java.util.*;

public class LinkedList2 {
  public Node head;
  public Node tail;

  public LinkedList2() {
    head = null;
    tail = null;
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
      if (node.value == _value)
        return node;
      node = node.next;
    }
    return null;
  }

  public ArrayList<Node> findAll(int _value) {
    ArrayList<Node> nodes = new ArrayList<Node>();
    Node current = this.head;
    while (current != null) {
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

    if (this.head.value == _value) {
      this.head = this.head.next;
      if (this.head == null) {
        this.tail = null;
      } else {
        this.head.prev = null;
      }
      return true;
    }
    Node currentNode = this.head;
    while (currentNode.next != null && currentNode.next.value != _value) {
      currentNode = currentNode.next;
    }

    if (currentNode.next != null && currentNode.next.value == _value) {
      if (currentNode.next.next != null) {
        currentNode.next.next.prev = currentNode;
      }
      currentNode.next = currentNode.next.next;
    }

    if (currentNode.next == null) {
      this.tail = currentNode;
    }

    return true;
  }

  public void removeAll(int _value) {
    Node currentNode = this.head;
    while (currentNode != null) {
      if (currentNode.value == _value) {
        if (currentNode == this.head) {
          head = currentNode.next;
          if (this.head != null) {
            this.head.prev = null;
          }
        } else if (currentNode == tail) {
          tail = currentNode.prev;
          if (this.tail.next != null) {
            this.tail.next = null;
          }
        } else {
          currentNode.prev.next = currentNode.next;
          currentNode.next.prev = currentNode.prev;
        }
      }
      currentNode = currentNode.next;
    }
  }

  public void clear() {
    this.head = null;
    this.tail = null;
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

  public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
    if (this.head == null) {
      this.head = _nodeToInsert;
      this.tail = _nodeToInsert;
      return;
    }

    if (_nodeAfter == null) {
      this.head.prev = _nodeToInsert;
      _nodeToInsert.next = this.head;
      this.head = _nodeToInsert;
      return;
    }

    if (_nodeAfter.equals(this.tail)) {
      _nodeToInsert.prev = this.tail;
      this.tail = _nodeToInsert;
      this.tail.prev.next = this.tail;
      return;
    }

    Node current = this.head;
    while (current != _nodeAfter && current.next != null) {
      current = current.next;
    }

    if (current.equals(_nodeAfter)) {
      if (current.next.next != null) {
        _nodeToInsert.next = current.next.next;
        current.next.next.prev = _nodeToInsert;
      }
      current.next = _nodeToInsert;
      _nodeToInsert.prev = current;
    }
  }
}

class Node {
  public int value;
  public Node next;
  public Node prev;

  public Node(int _value) {
    value = _value;
    next = null;
    prev = null;
  }
}
