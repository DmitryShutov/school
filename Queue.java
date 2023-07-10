import java.util.*;

public class Queue<T> {
    public LinkedList<T> list;

    public Queue() {
        list = new LinkedList<T>();
    }

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    public int size() {
        return list.size();
    }

    public void rotate(int n) {
        int i = 0;
        while (i < n) {
            T current = dequeue();
            enqueue(current);
            i++;
        }
    }
}
