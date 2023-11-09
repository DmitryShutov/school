package Heap;

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи
    public int size; // размер фактический

    public Heap() {
        HeapArray = null;
        size = 0;
    }

    public void MakeHeap(int[] a, int depth) {
        int heapSize = (int) Math.pow(2, depth + 1) - 1;
        HeapArray = new int[heapSize];
        for (int j : a) {
            Add(j);
        }
    }

    public int GetMax() {
        if (size == 0) return -1;
        int result = HeapArray[0];
        HeapArray[0] = HeapArray[size - 1];
        HeapArray[size - 1] = 0;
        size--;
        siftDown(0);
        return result;
    }

    public boolean Add(int key) {
        if (size == HeapArray.length) return false;
        HeapArray[size] = key;
        siftUp(size);
        size++;
        return true;
    }

    private void siftDown(int index) {
        int maxIndex = index;
        while (index < size / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            if (leftChild < size && HeapArray[leftChild] > HeapArray[maxIndex]) {
                maxIndex = leftChild;
            }
            if (rightChild < size && HeapArray[rightChild] > HeapArray[maxIndex]) {
                maxIndex = rightChild;
            }
            if (maxIndex == index) {
                break;
            }
            int temp = HeapArray[index];
            HeapArray[index] = HeapArray[maxIndex];
            HeapArray[maxIndex] = temp;
            index = maxIndex;
        }
    }

    private void siftUp(int index) {
        while (index > 0 && HeapArray[(index - 1) / 2] < HeapArray[index]) {
            int temp = HeapArray[(index - 1) / 2];
            HeapArray[(index - 1) / 2] = HeapArray[index];
            HeapArray[index] = temp;
            index = (index - 1) / 2;
        }
    }
}
