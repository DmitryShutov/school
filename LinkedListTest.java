import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class LinkedListTest {

    private LinkedList createAndFill(int... values) {
        LinkedList list = new LinkedList();
        for(int value: values) {
            list.addInTail(new Node(value));
        }
        return list;
    }

    @Test
    public void testAddInTail() {
        LinkedList list = createAndFill(1, 2);
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
        LinkedList list = new LinkedList();
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
        LinkedList list = createAndFill(1,2,3);
        list.remove(2);
        assertEquals(3, list.head.next.value);
    }

    @Test
    public void testRemoveHead() {
        LinkedList list = createAndFill(1,2,3);
        list.remove(1);
        assertEquals(2, list.head.value);
    }

    @Test
    public void testRemoveTail() {
        LinkedList list = createAndFill(1,2,3);
        list.remove(3);
        assertEquals(1, list.head.value);
        assertEquals(2, list.tail.value);
    }

    @Test
    public void testRemoveOnlyElement() {
        LinkedList list = createAndFill(1);
        list.remove(1);
        assertNull(list.head, "List not empty");
        assertNull(list.tail, "List not empty");
    }

    @Test
    public void testRemoveAll() 
    {
        LinkedList list = createAndFill(1,2,3,1,4,1);
        list.removeAll(1);
        assertEquals(2, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.tail.value);
        assertEquals(3, list.count());
    }

    @Test
    public void testRemoveAllInMiddle() 
    {
        LinkedList list = createAndFill(1,2,3,1,3);
        list.removeAll(3);
        assertEquals(1, list.head.value);
        assertEquals(2, list.head.next.value);
        assertEquals(1, list.tail.value);
        assertEquals(3, list.count());
    }

    @Test
    public void testRemoveAllOneElementList() 
    {
        LinkedList list = createAndFill(1);
        list.removeAll(1);
        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(0, list.count());
    }

    @Test
    public void testRemoveAllSameElementsList() 
    {
        LinkedList list = createAndFill(1,1,1,1);
        list.removeAll(1);
        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(0, list.count());
    }

    @Test
    public void testRemoveAllHead()
    {
        LinkedList list = createAndFill(1,2,3,4);
        list.removeAll(1);
        assertEquals(2, list.head.value);
        assertEquals(3, list.head.next.value);
        assertEquals(4, list.tail.value);
        assertEquals(3, list.count());
    }

    @Test
    public void testRemoveAllTail()
    {
        LinkedList list = createAndFill(1,3,4);
        list.removeAll(4);
        assertEquals(1, list.head.value);
        assertEquals(3, list.tail.value);
        assertEquals(2, list.count());
    }

      @Test
    public void testRemoveAllHeadAndTail()
    {
        LinkedList list = createAndFill(4,1,3,4);
        list.removeAll(4);
        assertEquals(1, list.head.value);
        assertEquals(3, list.tail.value);
        assertEquals(2, list.count());
    }

    @Test
    public void testFindAll() 
    {
        LinkedList list = createAndFill(1, 2, 3, 1);
        ArrayList<Node> all = list.findAll(1);
        assertEquals(all.size(), 2);
        assertEquals(all.get(0).value, 1);
        assertEquals(all.get(1).value, 1);
    }

    @Test
    public void testCountEmpty() {
        LinkedList list = new LinkedList();
        assertEquals(list.count(), 0);
    }

    @Test
    public void testCount() {
        LinkedList list = createAndFill(1, 2, 3, 4, 5);
        assertEquals(list.count(), 5);
    }

    @Test
    public void testInsertHead() {
        LinkedList list = createAndFill(2,3);
        Node inserted = new Node(1);
        list.insertAfter(null, inserted);
        assertEquals(list.head, inserted);
        assertEquals(list.tail.value, 3);
    }

    @Test
    public void testInsertTail() {
        LinkedList list = createAndFill(1);
        Node inserted = new Node(2);
        list.addInTail(inserted);
        Node insertedTail = new Node(3);
        list.insertAfter(inserted, insertedTail);
        assertSame(list.tail, insertedTail);
        assertEquals(list.count(), 3);
    }

    @Test
    public void testInsert() {
        LinkedList list = new LinkedList();
        Node head = new Node(1);
        list.addInTail(head);
        list.addInTail(new Node(3));
        Node inserted = new Node(2);
        list.insertAfter(head, inserted);

        assertSame(list.head, head);
        assertSame(list.head.next, inserted);
        assertEquals(list.tail.value, 3);
        assertNull(list.tail.next);
    }

    @Test
    public void testInsertInEmpty() {
        LinkedList list = new LinkedList();
        Node inserted = new Node(1);
        list.insertAfter(null, inserted);
        assertSame(list.head, inserted);
        assertSame(inserted, list.tail);
    }

    @Test
    public void testSumLinkedList() {
        LinkedList first = createAndFill(1,2,3);
        LinkedList second = createAndFill(4,5,6);
        LinkedList res = LinkedList.sumLinkedList(first, second);
        assertEquals(5, res.head.value);
        assertEquals(7, res.head.next.value);
        assertEquals(9, res.head.next.next.value);
    }
}
