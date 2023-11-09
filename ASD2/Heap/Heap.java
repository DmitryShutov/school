package Heap;

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        int heapSize = (int) Math.pow(2, depth + 1) - 1;
        HeapArray = new int[heapSize];
        for (int i = 0; i < heapSize; i++) HeapArray[i] = -1;
        for (int j : a) {
            Add(j);
        }
    }

    public int GetMax() {
        if (HeapArray[0] == -1) {
            return -1;
        }
        int max = HeapArray[0];
        for (int index = 0; index < HeapArray.length; index++) {
            if (HeapArray[index] == -1) {
                break;
            }
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            if (HeapArray[leftChildIndex] == -1 && HeapArray[rightChildIndex] == -1) {
                break;
            }
            if (HeapArray[leftChildIndex] > HeapArray[rightChildIndex]) {
                HeapArray[index] = HeapArray[leftChildIndex];
                HeapArray[leftChildIndex] = -1;
                index = leftChildIndex - 1;
            } else {
                HeapArray[index] = HeapArray[rightChildIndex];
                HeapArray[rightChildIndex] = -1;
                index = rightChildIndex - 1;
            }
        }
        return max;
    }

    public boolean Add(int key) {
        if (HeapArray[0] == -1) {
            HeapArray[0] = key;
            return true;
        }
        for (int index = 0; index < HeapArray.length; index++) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            if (leftChildIndex >= HeapArray.length || rightChildIndex >= HeapArray.length) {
                return false;
            }
            if (HeapArray[leftChildIndex] == -1) {
                HeapArray[leftChildIndex] = key;
                break;
            }
            if (HeapArray[rightChildIndex] == -1) {
                HeapArray[rightChildIndex] = key;
                break;
            }
            if (HeapArray[leftChildIndex] > HeapArray[rightChildIndex]) {
                index = leftChildIndex - 1;
            } else {
                index = rightChildIndex - 1;
            }
        }
        return true;
    }

    public int FindEmptyIndex() {
        for (int i = HeapArray.length - 1; i > 0; i--) {
            if (HeapArray[i] < 0) {
                return i;
            }
        }
        return 0;
    }
}
