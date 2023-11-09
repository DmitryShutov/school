package Heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
        assertArrayEquals(new int[]{2, 1, -1}, heap.HeapArray);
    }
/*
    public void MakeHeap() {
        Heap heap = new Heap();
        heap.MakeHeap(new int[]{1, 2, 3, 4, 5, 6, 7}, 2);
        assertArrayEquals(new int[]{7, 4, 6, 1, 3, 2, 5}, heap.HeapArray);
    }


 */
}
