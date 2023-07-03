import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class LinkedList2DummyTest {
    @Test
    public void testRemoveTail() {
        LinkedList2Dummy list = new LinkedList2Dummy();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        list.addInTail(first);
        list.addInTail(second);
        list.addInTail(third);
        list.remove(3);
        assertEquals(1, list.getHead().value);
        assertEquals(2, list.getTail().value);
        assertSame(list.getHead().next, second);
        assertSame(list.getTail().prev, first);
    }

    @Test
    public void testRemoveOnlyElement() {
        LinkedList2Dummy list = createAndFill(1);
        list.remove(1);
        assertNull(list.getHead(), "List not empty");
        assertNull(list.getTail(), "List not empty");
    }

    @Test
    public void testRemoveAll() {
        LinkedList2Dummy list = createAndFill(1, 1, 2, 3, 1, 1, 4, 1);
        list.removeAll(1);
        assertEquals(2, list.getHead().value);
        assertEquals(3, list.getHead().next.value);
        assertEquals(4, list.getTail().value);
        assertEquals(3, list.count());
    }

    @Test
    public void testRemoveAllEmpty() {
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.removeAll(1);
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void testRemoveAllOnlyElement() {
        LinkedList2Dummy list = createAndFill(1);
        list.removeAll(1);
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void testRemoveAllOnlyElementNotMatch() {
        LinkedList2Dummy list = createAndFill(1);
        list.removeAll(2);
        assertEquals(1, list.getHead().value);
        assertEquals(1, list.getTail().value);
        assertEquals(1, list.count());
    }

    @Test
    public void testRemoveAllSameElements() {
        LinkedList2Dummy list = createAndFill(1, 1, 1, 1);
        list.removeAll(1);
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void testRemoveAllHead() {
        LinkedList2Dummy list = createAndFill(1, 2, 3, 4);
        list.removeAll(1);
        assertEquals(2, list.getHead().value);
        assertEquals(3, list.getHead().next.value);
        assertEquals(4, list.getTail().value);
        assertEquals(3, list.count());
    }

    @Test
    public void testRemoveAllTail() {
        LinkedList2Dummy list = new LinkedList2Dummy();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        list.addInTail(first);
        list.addInTail(second);
        list.addInTail(third);
        list.removeAll(3);
        assertEquals(2, list.count());
        assertEquals(1, list.getHead().value);
        assertEquals(2, list.getTail().value);
        assertSame(list.getHead().next, second);
        assertSame(list.getTail().prev, first);
    }

    @Test
    public void testRemoveAllHeadAndTail() {
        LinkedList2Dummy list = createAndFill(4, 1, 3, 4);
        list.removeAll(4);
        assertEquals(1, list.getHead().value);
        assertEquals(3, list.getTail().value);
        assertEquals(2, list.count());
    }

    @Test
    public void testFindAll() {
        LinkedList2Dummy list = createAndFill(1, 2, 3, 1);
        ArrayList<Node> all = list.findAll(1);
        assertEquals(all.size(), 2);
        assertEquals(all.get(0).value, 1);
        assertEquals(all.get(1).value, 1);
    }

    @Test
    public void testCountEmpty() {
        LinkedList2Dummy list = new LinkedList2Dummy();
        assertEquals(list.count(), 0);
    }

    @Test
    public void testCount() {
        LinkedList2Dummy list = createAndFill(1, 2, 3, 4, 5);
        assertEquals(list.count(), 5);
    }

    @Test
    public void testInsertToEmptyList() {
        LinkedList2Dummy list = new LinkedList2Dummy();
        Node inserted = new Node(1);
        list.insertAfter(null, inserted);
        assertEquals(list.getHead(), inserted);
        assertEquals(list.getTail(), inserted);
    }

    @Test
    public void testInsertHead() {
        Node second = new Node(2);
        Node third = new Node(3);
        LinkedList2Dummy list = new LinkedList2Dummy();
        list.addInTail(second);
        list.addInTail(third);
        Node inserted = new Node(1);
        list.insertAfter(null, inserted);
        assertEquals(list.getHead(), inserted);
        assertSame(list.getHead().next, second);
        assertSame(list.getHead().next.next, third);
        assertSame(list.getTail(), third);
        assertSame(list.getTail().prev, second);
        assertEquals(list.getTail().value, 3);
    }

    @Test
    public void testInsertTail() {
        LinkedList2Dummy list = createAndFill(1, 2);
        Node third = new Node(3);
        list.addInTail(third);
        Node inserted = new Node(4);
        list.insertAfter(third, inserted);
        assertSame(list.getTail(), inserted);
    }

    @Test
    public void testInsert() {
        LinkedList2Dummy list = new LinkedList2Dummy();
        Node head = new Node(1);
        list.addInTail(head);
        list.addInTail(new Node(3));
        Node inserted = new Node(2);
        list.insertAfter(head, inserted);

        assertSame(list.getHead(), head);
        assertSame(list.getHead().next, inserted);
        assertEquals(list.getTail().value, 3);
    }

    @Test
    public void clear() {
        LinkedList2Dummy list = createAndFill(1, 2, 3);
        list.clear();
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    private LinkedList2Dummy createAndFill(int... values) {
        LinkedList2Dummy list = new LinkedList2Dummy();
        for (int value : values) {
            list.addInTail(new Node(value));
        }
        return list;
    }
}
