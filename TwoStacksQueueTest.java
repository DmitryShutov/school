import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwoStacksQueueTest {

    @Test
    public void testQueue() {
        TwoStacksQueue<Integer> queue = new TwoStacksQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());
        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testDequeueEmpty() {
        TwoStacksQueue<Integer> queue = new TwoStacksQueue<Integer>();
        assertNull(queue.dequeue());
    }

    @Test
    public void testOneElementStack() {
        TwoStacksQueue<Double> queue = new TwoStacksQueue<Double>();
        queue.enqueue(1.0);
        assertEquals(queue.size(), 1);
        assertEquals(queue.dequeue(), 1.0);
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testChangeStacks() {
        TwoStacksQueue<Integer> queue = new TwoStacksQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.size(), 1);
        queue.enqueue(3);
        assertEquals(queue.size(), 2);
        assertEquals(queue.dequeue(), 2);
        assertEquals(queue.size(), 1);
        assertEquals(queue.dequeue(), 3);
        assertEquals(queue.size(), 0);
    }

}
