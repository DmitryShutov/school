package aBST;

class aBST {
    public Integer Tree[]; // массив ключей

    public aBST(int depth) {
        int tree_size = (int) Math.pow(2, depth + 1) - 1;
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key) {
        return FindKeyIndexRecursive(key, 0);
    }

    public int AddKey(int key) {
        Integer index = FindKeyIndex(key);
        if (index <= 0) {
            int positiveIndex = Math.abs(index);
            Tree[positiveIndex] = key;
            return positiveIndex;
        }
        return -1;
    }

    private Integer FindKeyIndexRecursive(int key, int currentIndex) {
        if (Tree[currentIndex] == null) {
            return -currentIndex;
        }
        Integer currentValue = Tree[currentIndex];
        if (key == currentValue) {
            return currentIndex;
        }
        if (currentIndex == Tree.length - 1) {
            return null;
        }
        if (currentValue < key) {
            return FindKeyIndexRecursive(key, rightChildIndex(currentIndex));
        }
        return FindKeyIndexRecursive(key, leftChildIndex(currentIndex));

    }

    private Integer leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private Integer rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }


}
