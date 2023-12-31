import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PowerSetTest {

    @Test
    public void testPut() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        assertTrue(powerSet.get("first"));
        assertFalse(powerSet.get("second"));
    }

    @Test
    public void testReWriteKey() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        powerSet.put("first");
        assertTrue(powerSet.get("first"));
    }

    @Test
    public void testRemove() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        powerSet.remove("first");
        assertEquals(0, powerSet.size());
        assertFalse(powerSet.get("first"));
    }

    @Test
    public void testRemoveEmpty() {
        PowerSet powerSet = new PowerSet();
        powerSet.remove("first");
        assertEquals(0, powerSet.size());
        assertFalse(powerSet.get("first"));
    }

    @Test
    public void testIntersection() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        powerSet.put("second");
        powerSet.put("third");
        PowerSet powerSet2 = new PowerSet();
        powerSet2.put("first");
        powerSet2.put("second");
        powerSet2.put("fourth");
        PowerSet intersection = powerSet.intersection(powerSet2);
        assertEquals(2, intersection.size());
        assertTrue(intersection.get("first"));
        assertTrue(intersection.get("second"));
        assertFalse(intersection.get("third"));
        assertFalse(intersection.get("fourth"));
    }

    @Test
    public void testIntersectionEmpty() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        powerSet.put("second");
        powerSet.put("third");
        PowerSet powerSet2 = new PowerSet();
        powerSet2.put("fourth");
        PowerSet intersection = powerSet.intersection(powerSet2);
        assertEquals(0, intersection.size());
        assertFalse(intersection.get("first"));
        assertFalse(intersection.get("second"));
        assertFalse(intersection.get("third"));
    }

    @Test
    public void testUnion() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        powerSet.put("second");
        powerSet.put("third");
        PowerSet powerSet2 = new PowerSet();
        powerSet2.put("first");
        powerSet2.put("second");
        powerSet2.put("fourth");
        PowerSet union = powerSet.union(powerSet2);
        assertEquals(4, union.size());
        assertTrue(union.get("first"));
        assertTrue(union.get("second"));
        assertTrue(union.get("third"));
        assertTrue(union.get("fourth"));
    }

    @Test
    public void testUnoinOneEmpty() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        powerSet.put("second");
        powerSet.put("third");
        PowerSet powerSet2 = new PowerSet();
        PowerSet union = powerSet.union(powerSet2);
        assertEquals(3, union.size());
        assertTrue(union.get("first"));
        assertTrue(union.get("second"));
        assertTrue(union.get("third"));
        assertEquals(3, union.size());
    }

    @Test
    public void testDifference() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        powerSet.put("second");
        powerSet.put("third");
        PowerSet powerSet2 = new PowerSet();
        powerSet2.put("first");
        powerSet2.put("second");
        powerSet2.put("fourth");
        PowerSet difference = powerSet.difference(powerSet2);
        assertEquals(1, difference.size());
        assertFalse(difference.get("first"));
        assertFalse(difference.get("second"));
        assertTrue(difference.get("third"));
        assertFalse(difference.get("fourth"));
    }

    @Test
    public void testDifferenceEmptyResult() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        powerSet.put("second");
        powerSet.put("third");
        PowerSet powerSet2 = new PowerSet();
        powerSet2.put("first");
        powerSet2.put("second");
        powerSet2.put("third");
        PowerSet difference = powerSet.difference(powerSet2);
        assertEquals(0, difference.size());
        assertFalse(difference.get("first"));
        assertFalse(difference.get("second"));
        assertFalse(difference.get("third"));
    }

    @Test
    public void testIsSubset() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        powerSet.put("second");
        powerSet.put("third");
        PowerSet powerSet2 = new PowerSet();
        powerSet2.put("first");
        powerSet2.put("second");
        assertTrue(powerSet.isSubset(powerSet2));
    }

    @Test
    public void testIsSubsetAll() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        powerSet.put("second");
        PowerSet powerSet2 = new PowerSet();
        powerSet2.put("first");
        powerSet2.put("second");
        assertTrue(powerSet.isSubset(powerSet2));
    }

    @Test
    public void testIsSubsetFalse() {
        PowerSet powerSet = new PowerSet();
        powerSet.put("first");
        powerSet.put("second");
        PowerSet powerSet2 = new PowerSet();
        powerSet2.put("first");
        powerSet2.put("second");
        powerSet2.put("third");
        assertFalse(powerSet.isSubset(powerSet2));
    }

    @Test
    public void testAddTenThousandElements() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            powerSet.put(String.valueOf(i));
        }
        assertEquals(10000, powerSet.size());
    }

    @Test
    public void testAddTwentyThousandElements() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        assertEquals(20000, powerSet.size());
    }

    @Test
    public void testAddAndRemoveTwentyThousands() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        for (int i = 0; i < 20000; i++) {
            powerSet.remove(String.valueOf(i));
        }
        assertEquals(0, powerSet.size());
    }

    @Test
    public void testAddAndGet() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        for (int i = 0; i < 20000; i++) {
            assertTrue(powerSet.get(String.valueOf(i)));
        }
    }

    @Test
    public void testAddRemoveAndGet() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        for (int i = 0; i < 20000; i++) {
            powerSet.remove(String.valueOf(i));
        }
        for (int i = 0; i < 20000; i++) {
            assertFalse(powerSet.get(String.valueOf(i)));
        }
    }

    @Test
    public void testgetFromEmpty() {
        PowerSet powerSet = new PowerSet();
        assertFalse(powerSet.get("first"));
    }

    @Test
    public void testIntersectionTwentyThousand() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet2 = new PowerSet();
        for (int i = 10000; i < 30000; i++) {
            powerSet2.put(String.valueOf(i));
        }
        PowerSet intersection = powerSet.intersection(powerSet2);
        assertEquals(10000, intersection.size());
        for (int i = 10000; i < 20000; i++) {
            assertTrue(intersection.get(String.valueOf(i)));
        }
    }

    @Test
    public void testDifferenceTwentyThousand() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet2 = new PowerSet();
        for (int i = 10000; i < 30000; i++) {
            powerSet2.put(String.valueOf(i));
        }
        PowerSet difference = powerSet.difference(powerSet2);
        assertEquals(10000, difference.size());
        for (int i = 0; i < 10000; i++) {
            assertTrue(difference.get(String.valueOf(i)));
        }
    }

    @Test
    public void testIntersectionEmptyTwentyThousand() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet2 = new PowerSet();
        PowerSet intersection = powerSet.intersection(powerSet2);
        assertEquals(0, intersection.size());
    }

    @Test
    public void testIntersectionTwoByTwentyThousand() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet powerSet2 = new PowerSet();
        for (int i = 20000; i < 40000; i++) {
            powerSet.put(String.valueOf(i));
        }
        PowerSet intersection = powerSet.intersection(powerSet2);
        assertEquals(0, intersection.size());
    }

    @Test
    public void testAddRemoveAndAdd() {
        PowerSet powerSet = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        for (int i = 0; i < 20000; i++) {
            powerSet.remove(String.valueOf(i));
        }
        for (int i = 0; i < 20000; i++) {
            powerSet.put(String.valueOf(i));
        }
        assertEquals(20000, powerSet.size());
    }
}   
