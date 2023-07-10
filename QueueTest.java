import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    public void testEnqueue() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(queue.list.size(), 2);
        assertEquals(queue.list.getFirst(), 1);
        assertEquals(queue.list.getLast(), 2);
    }

    @Test
    public void testDequeue() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(queue.dequeue(), 1);
        assertEquals(queue.list.size(), 1);
        assertEquals(queue.dequeue(), 2);
        assertEquals(queue.list.size(), 0);
    }

    @Test
    public void testSize() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(queue.size(), 2);
    }

    @Test
    public void testRotate() {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.rotate(1);
        assertEquals(queue.list.getFirst(), 2);
        assertEquals(queue.list.getLast(), 1);
        queue.rotate(2);
        assertEquals(queue.list.getFirst(), 1);
        assertEquals(queue.list.getLast(), 3);
    }
}
