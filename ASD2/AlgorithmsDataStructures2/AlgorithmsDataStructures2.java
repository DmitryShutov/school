package AlgorithmsDataStructures2;

import java.util.Arrays;

public class AlgorithmsDataStructures2 {
    public static int[] GenerateBBSTArray(int[] a) {
        Arrays.sort(a);
        int treeSize = (int) Math.pow(2, Math.floor(Math.log(a.length + 1) / Math.log(2)) + 1) - 1;
        int[] tree = new int[treeSize];
        GenerateBBSTArrayRecursive(a, tree, 0, a.length - 1, 0);
        return tree;
    }

    private static void GenerateBBSTArrayRecursive(int[] sortedArr, int[] tree, int left, int right, int currentIndex) {
        if (left > right || currentIndex >= tree.length) {
            return;
        }
        int pivot = (right + left) >>> 1;
        tree[currentIndex] = sortedArr[pivot];
        GenerateBBSTArrayRecursive(sortedArr, tree, left, pivot - 1, 2 * currentIndex + 1);
        GenerateBBSTArrayRecursive(sortedArr, tree, pivot + 1, right, 2 * currentIndex + 2);
    }
}
