import java.util.*;

public class Deque<T>
{   
    public LinkedList<T> list;
    public Deque()
    {
     list = new LinkedList<T>();
    }

    public void addFront(T item)
    {
     list.add(item);
    }

    public void addTail(T item)
    {
     list.addFirst(item);
    }

    public T removeFront()
    {
     if (size() == 0) {
        return null;
     }
     return list.removeLast();
    }

    public T removeTail()
    {
        if (size() == 0) {
            return null;
        }
        return list.removeFirst();
    }
        
    public int size()
    {
     return list.size();
    }

    public static boolean isPalindrome(String str) {
        Deque<Character> deque = new Deque<Character>();
        for (int i = 0; i < str.length(); i++) {
            deque.addFront(str.charAt(i));
        }
        boolean result = true;
        for (int i = 0; i < deque.size()/2; i++) {
            if (deque.removeTail() != deque.removeFront()) {
                result = false;
                break;
            }
        }
        return result;
    }
}