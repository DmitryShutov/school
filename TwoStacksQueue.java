import java.util.*;

public class TwoStacksQueue<T> {
    public Stack<T> dataStack;
    public Stack<T> tempStack;

    public TwoStacksQueue() {
        dataStack = new Stack<T>();
        tempStack = new Stack<T>();
    }

    public void enqueue(T item) {
        dataStack.push(item);
    }

    public T dequeue() {
        T result;
        if (dataStack.size() == 0) {
            return null;
        }
        while (dataStack.size() > 1) {
            T current = dataStack.pop();
            tempStack.push(current);
        }
        result = dataStack.pop();
        while (tempStack.size() > 0) {
            T current = tempStack.pop();
            dataStack.push(current);
        }
        return result;
    }

    public int size() {
        return dataStack.size();
    }
}
