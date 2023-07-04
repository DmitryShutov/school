import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DynArrayTest {

    @Test
    public void testCreateArray() {
        DynArray arr = new DynArray<Integer>(Integer.class);
        assertEquals(arr.capacity, 16);
        assertEquals(arr.count, 0);
    }
}
