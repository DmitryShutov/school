package AlgorithmsDataStructures2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgorithmsDataStructures2Test {
    @Test
    public void testGenerateBBSTArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(a);
        assertEquals(4, result[0]);
        assertEquals(2, result[1]);
        assertEquals(6, result[2]);
        assertEquals(1, result[3]);
        assertEquals(3, result[4]);
        assertEquals(5, result[5]);
        assertEquals(7, result[6]);
    }

    @Test
    public void testGenerateBBSTArrayWithOneElement() {
        int[] a = {1};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(a);
        assertEquals(1, result[0]);
    }

    @Test
    public void testNotFullTree() {
        int[] a = {1, 3, 5};
        int[] result = AlgorithmsDataStructures2.GenerateBBSTArray(a);
        assertEquals(3, result[0]);
        assertEquals(1, result[1]);
        assertEquals(5, result[2]);
    }

    @Test
    public void testCalcCountOfTreeElement() {
        assertEquals(1, AlgorithmsDataStructures2.calcCountOfTreeElement(1));
        assertEquals(3, AlgorithmsDataStructures2.calcCountOfTreeElement(2));
        assertEquals(7, AlgorithmsDataStructures2.calcCountOfTreeElement(7));
        assertEquals(15, AlgorithmsDataStructures2.calcCountOfTreeElement(9));
    }
}
