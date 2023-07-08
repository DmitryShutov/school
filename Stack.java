import java.util.*;

public class Stack<T> {
    public LinkedList<T> list;

    public Stack() {
        list = new LinkedList<T>();
    }

    public int size() {
        return list.size();
    }

    public T pop() {
        if (size() == 0) {
            return null;
        }
        return list.pop();
    }

    public void push(T val) {
        list.addFirst(val);
    }

    public T peek() {
        if (size() > 0) {
            return list.getFirst();
        }
        return null;
    }
}
