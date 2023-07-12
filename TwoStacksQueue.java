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
        if (tempStack.size() == 0) {
            while (dataStack.size() > 0) {
                T current = dataStack.pop();
                tempStack.push(current);
            }
        }
        return tempStack.pop();
    }

    public int size() {
        return dataStack.size() + tempStack.size();
    }
}
