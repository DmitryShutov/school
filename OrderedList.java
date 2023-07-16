import java.util.*;


 class Node<T>
  {
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
      value = _value;
      next = null;
      prev = null;
    }
  }

 public class OrderedList<T>
  {
    public Node<T> head, tail;
    public int count;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
      head = null;
      tail = null;
      _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if (v1 instanceof Number && v2 instanceof Number) {
            double diff = ((Number)v1).doubleValue() - ((Number)v2).doubleValue();
            return (int)Math.signum(diff);
        }
        if (v1 instanceof String && v2 instanceof String) {
            return ((String)v1).trim().compareTo(((String)v2).trim());
        }
        return 0;
    }

    private boolean haveToAdd(Node<T> current, Node<T> newNode) {
        if (_ascending) {
            return compare(current.value, newNode.value) > 0;
        }
        return compare(current.value,newNode.value) < 0;
    }

    public void add(T value)
    {
        if (head == null) {
            head = new Node<T>(value);
            tail = head;
            count++;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode != null) {
            Node<T> newNode = new Node<T>(value);
            if (currentNode == head && haveToAdd(currentNode, newNode)) {
                newNode.next = currentNode;
                currentNode.prev = newNode;
                head = newNode;
                break;
            } 
            if (haveToAdd(currentNode, newNode)) {
                newNode.prev = currentNode.prev;
                newNode.next = currentNode;
                currentNode.prev.next = newNode;
                currentNode.prev = newNode;
                break;
            }
            if (currentNode == tail) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                break;
            }

            currentNode = currentNode.next;
        }
        count++;
    }

    public Node<T> find(T val)
    {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (compare(currentNode.value, val) == 0) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void delete(T val)
    {   
        if (count == 0) {
            return;
        }
        Node<T> removed = find(val);
        if (removed == null) {
           return;
        }
        if (removed == head && count == 1) {
            clear(_ascending);
            return;
        }
        if (removed == tail) {
            tail = removed.prev;
            tail.next = null;
            count--;
            return;
        }
        if (removed != null) {
            removed.prev.next = removed.next;
            removed.next.prev = removed.prev;
            count--;
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        head = null;
        tail = null;
        count = 0;
    }

    public int count()
    {   
       return count;
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного 
                           // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
  }
