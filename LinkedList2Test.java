import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class LinkedList2Test {

    private LinkedList2 createAndFill(int... values) {
        LinkedList2 list = new LinkedList2();
        for (int value : values) {
            list.addInTail(new Node(value));
        }
        return list;
    }

    @Test
    public void testAddInTail() {
        LinkedList2 list = createAndFill(1, 2);
        list.addInTail(new Node(3));

        assertEquals(1, list.head.value);
        assertEquals(2, list.head.next.value);
        assertEquals(3, list.head.next.next.value);
        assertEquals(list.head.next.next, list.tail);
        assertNull(list.head.next.next.next);
        assertNull(list.tail.next);
    }

    @Test
    public void testFind() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        int findingValue = 2;
        Node finding = new Node(findingValue);
        list.addInTail(finding);
        list.addInTail(new Node(3));

        Node found = list.find(findingValue);

        assertSame(finding, found);
    }

    @Test
    public void testRemove() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        LinkedList2 list = new LinkedList2();
        list.addInTail(first);
        list.addInTail(second);
        list.addInTail(third);
        list.remove(2);
        assertEquals(3, list.head.next.value);
        assertSame(list.head.next, third);
        assertNull(list.head.prev);
        assertSame(list.tail.prev, first);
    }

    @Test
    public void testRemoveHead() {
        LinkedList2 list = createAndFill(1, 2, 3);
        list.remove(1);
        assertEquals(2, list.head.value);
    }

    @Test
    public void testRemoveTail() {
        LinkedList2 list = new LinkedList2();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        list.addInTail(first);
        list.addInTail(second);
        list.addInTail(third);
        list.remove(3);
        assertEquals(1, list.head.value);
        assertEquals(2, list.tail.value);
        assertSame(list.head.next, second);
        assertSame(list.tail.prev, first);
    }

    @Test
    public void testRemoveOnlyElement() {
        LinkedList2 list = createAndFill(1);
        list.remove(1);
        assertNull(list.head, "List not empty");
        assertNull(list.tail, "List not empty");
    }

    @Test
    public void testRemoveAll() {
        LinkedList2 list = createAndFill(1, 1, 2, 3, 1, 1, 4, 1);
        list.removeAll(1);
        assertEquals(2, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.tail.value);
        assertEquals(3, list.count());
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    public void testRemoveAllHead() {
        LinkedList2 list = createAndFill(1, 2, 3, 4);
        list.removeAll(1);
        assertEquals(2, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.tail.value);
        assertEquals(3, list.count());
    }

    @Test
    public void testRemoveAllTail() {
        LinkedList2 list = new LinkedList2();
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        list.addInTail(first);
        list.addInTail(second);
        list.addInTail(third);
        list.removeAll(3);
        assertEquals(2, list.count());
        assertEquals(1, list.head.value);
        assertEquals(2, list.tail.value);
        assertSame(list.head.next, second);
        assertSame(list.tail.prev, first);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    public void testRemoveAllHeadAndTail() {
        LinkedList2 list = createAndFill(4, 1, 3, 4);
        list.removeAll(4);
        assertEquals(1, list.head.value);
        assertEquals(3, list.tail.value);
        assertEquals(2, list.count());
    }

    @Test
    public void testFindAll() {
        LinkedList2 list = createAndFill(1, 2, 3, 1);
        ArrayList<Node> all = list.findAll(1);
        assertEquals(all.size(), 2);
        assertEquals(all.get(0).value, 1);
        assertEquals(all.get(1).value, 1);
    }

    @Test
    public void testCountEmpty() {
        LinkedList2 list = new LinkedList2();
        assertEquals(list.count(), 0);
    }

    @Test
    public void testCount() {
        LinkedList2 list = createAndFill(1, 2, 3, 4, 5);
        assertEquals(list.count(), 5);
    }

    @Test
    public void testInsertToEmptyList() {
        LinkedList2 list = new LinkedList2();
        Node inserted = new Node(1);
        list.insertAfter(null, inserted);
        assertEquals(list.head, inserted);
        assertEquals(list.tail, inserted);
    }

    @Test
    public void testInsertHead() {
        Node second = new Node(2);
        Node third = new Node(3);
        LinkedList2 list = new LinkedList2();
        list.addInTail(second);
        list.addInTail(third);
        Node inserted = new Node(1);
        list.insertAfter(null, inserted);
        assertEquals(list.head, inserted);
        assertSame(list.head.next, second);
        assertSame(list.head.next.next, third);
        assertSame(list.tail, third);
        assertSame(list.tail.prev, second);
        assertEquals(list.tail.value, 3);
    }

    @Test
    public void testInsertTail() {
        LinkedList2 list = createAndFill(1, 2);
        Node third = new Node(3);
        list.addInTail(third);
        Node inserted = new Node(4);
        list.insertAfter(third, inserted);
        assertSame(list.tail, inserted);
    }

    @Test
    public void testInsert() {
        LinkedList2 list = new LinkedList2();
        Node head = new Node(1);
        list.addInTail(head);
        list.addInTail(new Node(3));
        Node inserted = new Node(2);
        list.insertAfter(head, inserted);

        assertSame(list.head, head);
        assertSame(list.head.next, inserted);
        assertEquals(list.tail.value, 3);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    public void clear() {
        LinkedList2 list = createAndFill(1, 2, 3);
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }
}
