import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DequeTest {
    @Test
    public void testAddFront() {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFront(1);
        deque.addFront(2);
        assertEquals(deque.size(), 2);
        assertEquals(deque.list.get(0), 1);
        assertEquals(deque.list.get(1), 2);
    }

    @Test
    public void testAddTail() {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addTail(1);
        deque.addTail(2);
        assertEquals(deque.list.get(0), 2);
        assertEquals(deque.list.get(1), 1);
    }

    @Test
    public void testRemoveFront() {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        assertEquals(deque.removeFront(), 3);
        assertEquals(deque.size(), 2);
        assertEquals(deque.list.get(0),1);
        assertEquals(deque.list.get(1),2);
    }

    @Test
    public void testRemoveTail() {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFront(1);
        deque.addFront(2);
        deque.addFront(3);
        assertEquals(deque.removeTail(), 1);
        assertEquals(deque.size(), 2);
        assertEquals(deque.list.get(0),2);
        assertEquals(deque.list.get(1),3);
    }

    @Test
    public void testRemoveTailEmpty() {
        Deque<Integer> deque = new Deque<Integer>();
        assertNull(deque.removeTail());
    }

    @Test
    public void testRemoveFrontEmpty() {
        Deque<Integer> deque = new Deque<Integer>();
        assertNull(deque.removeFront());
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(Deque.isPalindrome("racecar"));
        assertTrue(Deque.isPalindrome("a"));
        assertTrue(Deque.isPalindrome(""));
        assertFalse(Deque.isPalindrome("hello"));
        assertFalse(Deque.isPalindrome("racecar1"));
    }
}
