import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.stream;

public class DynArrayTest {

    @Test
    public void testCreateIntegerArray() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        assertEquals(arr.capacity, 16);
        assertEquals(arr.count, 0);
    }

    @Test
    public void testCreateFloatArray() {
        DynArray<Float> arr = new DynArray<Float>(Float.class);
        assertEquals(arr.capacity, 16);
        assertEquals(arr.count, 0);
    }

    @Test
    public void testAppendGetItem() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        arr.append(0);
        arr.append(1);
        arr.append(2);
        assertEquals(arr.getItem(0), 0);
        assertEquals(arr.getItem(1), 1);
        assertEquals(arr.getItem(2), 2);
        assertThrows(IndexOutOfBoundsException.class, () -> arr.getItem(3));
    }

    @Test
    public void testInsertFirst() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        arr.append(0);
        arr.append(1);
        arr.append(2);
        arr.insert(3, 0);
        assertEquals(arr.array[0], 3);
        assertEquals(arr.count, 4);
        assertEquals(arr.capacity, 16);
    }

    @Test
    public void testInsertInMiddle() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        arr.append(0);
        arr.append(1);
        arr.append(2);
        arr.insert(3, 1);
        assertEquals(arr.array[1], 3);
        assertEquals(arr.array[2], 1);
        assertEquals(arr.array[3], 2);
        assertEquals(arr.count, 4);
        assertEquals(arr.capacity, 16);
    }

    @Test
    public void testInsertLast() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        arr.append(0);
        arr.append(1);
        arr.append(2);
        arr.insert(3, 3);
        assertEquals(arr.array[3], 3);
    }

    @Test
    public void testInsertEnhanceCapacity() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            arr.append(i);
        }
        assertEquals(arr.capacity, 16);
        arr.insert(16, 16);
        assertEquals(arr.capacity, 32);
    }

    @Test
    public void testInsertOutOfBounds() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            arr.append(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> arr.insert(17, 17));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.insert(18, 18));
    }

    @Test
    public void testRemoveKeepCapacity() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            arr.append(i);
        }
        assertEquals(arr.capacity, 16);
        arr.remove(15);
        arr.remove(0);
        assertEquals(arr.capacity, 16);
        assertEquals(arr.count, 14);
    }

    @Test
    public void testRemoveMinimalArray() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        arr.append(1);
        arr.remove(0);
        assertEquals(arr.capacity, 16);
        assertEquals(arr.count, 0);
        assertThrows(IndexOutOfBoundsException.class, () -> arr.getItem(0));
    }

    @Test
    public void testRemoveFromFilledArrayOfMinCapacity() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            arr.append(i);
        }
        assertEquals(arr.array[15], 15);
        assertEquals(arr.capacity, 16);
        assertEquals(arr.count, 16);
        arr.remove(15);
        assertEquals(arr.capacity, 16);
        assertEquals(arr.count, 15);
    }

    @Test
    public void testRemoveAllElements() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            arr.append(i);
        }
        for (int i = 15; i >= 0; i--) {
            arr.remove(i);
        }
        assertEquals(arr.capacity, 16);
        assertEquals(arr.count, 0);
    }

    @Test
    public void testRemoveAllElementsDoubleCapacity() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 32; i++) {
            arr.append(i);
        }
        for (int i = 32; i > 0; i--) {
            arr.remove(i - 1);
        }
        assertEquals(arr.capacity, 16);
        assertEquals(arr.count, 0);
    }

    @Test
    public void testShrinkCapacity() {
        DynArray<Integer> arr = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 32; i++) {
            arr.append(i);
        }
        assertEquals(arr.capacity, 32);
        assertEquals(arr.count, 32);
        for (int i = 0; i < 17; i++) {
            arr.remove(0);
        }
        assertEquals(arr.count, 15);
        assertEquals(arr.capacity, 21);
    }

    @Test
    public void testRemoveOutOfBounds() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        for (int i = 0; i < 16; i++) {
            arr.append(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> arr.remove(16));
    }
}
