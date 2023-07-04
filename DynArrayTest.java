import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testInsertOutOfBounds() {
        DynArray<Integer> arr = new DynArray<>(Integer.class);
        arr.append(0);
        arr.append(1);
        arr.append(2);
        assertThrows(IndexOutOfBoundsException.class, () -> arr.insert(3, 4));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.insert(4, 5));
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

}
