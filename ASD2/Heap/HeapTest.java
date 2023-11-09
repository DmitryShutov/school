package Heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapTest {
    @Test
    public void makeHeapOneEl() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1}, 0);
        assertArrayEquals(new int[]{1}, heap.HeapArray);
    }

    @Test
    public void makeHeapTwoEl() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 2}, 1);
        assertArrayEquals(new int[]{2, 1, 0}, heap.HeapArray);
    }

    @Test
    public void MakeLongHeap() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        assertArrayEquals(new int[]{7, 4, 6, 1, 3, 2, 5}, heap.HeapArray);
    }

    @Test
    public void GetOne() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1}, 0);
        assertEquals(1, heap.GetMax());
        assertEquals(0, heap.HeapArray[0]);
    }

    @Test
    public void GetTwoElementsHeap() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 2}, 1);
        assertEquals(2, heap.GetMax());
        assertEquals(1, heap.HeapArray[0]);
        assertEquals(0, heap.HeapArray[1]);
    }

    @Test
    public void twiceGetLongHeap() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        assertEquals(7, heap.GetMax());
        assertEquals(6, heap.GetMax());
    }
}
