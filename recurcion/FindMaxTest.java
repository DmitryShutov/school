package recurcion;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FindMaxTest {
    @Test
    public void testSecondMaxOfList() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        assertEquals(Integer.valueOf(4), FindMax.secondMaxOfList(list1));
    }

    @Test
    public void testSecondMaxOfListSameMaxArgs() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(5);
        assertEquals(Integer.valueOf(5), FindMax.secondMaxOfList(list1));
    }

    @Test
    public void testSecondMaxOfListTwoArgs() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        assertEquals(Integer.valueOf(1), FindMax.secondMaxOfList(list1));
    }

    @Test
    public void testSecondMaxOfListNegative() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(-1);
        list1.add(-2);
        list1.add(-3);
        assertEquals(Integer.valueOf(-2), FindMax.secondMaxOfList(list1));
    }

    @Test
    public void testSecondMaxSameValues() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(1);
        list1.add(1);
        assertEquals(Integer.valueOf(1), FindMax.secondMaxOfList(list1));
    }

    @Test
    public void testSecondMaxShortList() {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        assertNull(FindMax.secondMaxOfList(list1));
    }
}
