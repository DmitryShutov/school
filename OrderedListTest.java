import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class OrderedListTest {

    @Test
    public void testCompare() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        assertEquals(list.compare(1, 2), -1);
        assertEquals(list.compare(2, 1), 1);
        assertEquals(list.compare(2, 2), 0);
    }

    @Test
    public void testAddEmpty() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        assertEquals(list.count(), 1);
        assertEquals(list.head.value, 1);
        assertEquals(list.tail.value, 1);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testAddEmptyDescending() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);
        list.add(1);
        assertEquals(list.count(), 1);
        assertEquals(list.head.value, 1);
        assertEquals(list.tail.value, 1);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testAddTwo() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(2);
        assertEquals(list.count(), 2);
        assertEquals(list.head.value, 1);
        assertEquals(list.tail.value, 2);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testAddTwoHead() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(0);
        assertEquals(list.count(), 2);
        assertEquals(list.head.value, 0);
        assertEquals(list.tail.value, 1);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testAddTwoDescending() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);
        list.add(1);
        list.add(2);
        assertEquals(list.count(), 2);
        assertEquals(list.head.value, 2);
        assertEquals(list.tail.value, 1);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testAddThree() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.count(), 3);
        assertEquals(list.head.value, 1);
        assertEquals(list.tail.prev.value, 2);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
        assertEquals(list.tail.value, 3);
    }

    @Test
    public void testAddThreeDescending() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.count(), 3);
        assertEquals(list.head.value, 3);
        assertEquals(list.head.next.value, 2);
        assertEquals(list.tail.value, 1);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testAddToHead() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        assertEquals(list.count(), 4);
        assertEquals(list.head.value, 0);
        assertEquals(list.tail.value, 3);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testAddToHeadDescending() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        assertEquals(list.count(), 4);
        assertEquals(list.head.value, 3);
        assertEquals(list.tail.value, 0);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testAddSameValue() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        assertEquals(list.count(), 4);
        assertEquals(list.head.value, 1);
        assertEquals(list.tail.value, 1);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testAddStrings() {
        OrderedList<String> list = new OrderedList<String>(true);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        assertEquals(list.count(), 4);
        assertEquals(list.head.value, "a");
        assertEquals(list.tail.value, "d");
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testAddStringsDescending() {
        OrderedList<String> list = new OrderedList<String>(false);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        assertEquals(list.count(), 4);
        assertEquals(list.head.value, "d");
        assertEquals(list.tail.value, "a");
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testAddToTailDescending() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        assertEquals(list.count(), 4);
        assertEquals(list.head.value, 3);
        assertEquals(list.tail.prev.value, 1);
        assertEquals(list.tail.value, 0);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testFind() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.find(2).value, 2);
    }

    @Test
    public void testFindEmpty() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        assertNull(list.find(2));
    }

    @Test
    public void testFindDescending() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.find(2).value, 2);
    }

    @Test
    public void testFindDescendingEmpty() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);
        assertNull(list.find(2));
    }

    @Test
    public void testDelete() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.delete(2);
        assertEquals(list.count(), 2);
        assertEquals(list.head.value, 1);
        assertEquals(list.tail.value, 3);
    }

    @Test
    public void testDeleteEmpty() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.delete(2);
        assertEquals(list.count(), 0);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    public void testDeleteDescending() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);
        list.add(1);
        list.add(2);
        list.add(3);
        list.delete(2);
        assertEquals(list.count(), 2);
        assertEquals(list.head.value, 3);
        assertEquals(list.tail.value, 1);
    }

    @Test
    public void testDeleteDescendingEmpty() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);
        list.delete(2);
        assertEquals(list.count(), 0);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    public void testClear() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear(true);
        assertEquals(list.count(), 0);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    public void testClearDescending() {
        OrderedList<Integer> list = new OrderedList<Integer>(false);
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear(false);
        assertEquals(list.count(), 0);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    public void testGetAll() {
        OrderedList<Integer> list = new OrderedList<Integer>(true);
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(9);

        ArrayList<Node<Integer>> all = list.getAll();
        assertEquals(5, all.size());
        assertEquals(1, all.get(0).value);
        assertEquals(3, all.get(1).value);
        assertEquals(5, all.get(2).value);
        assertEquals(7, all.get(3).value);
        assertEquals(9, all.get(4).value);
    }
}