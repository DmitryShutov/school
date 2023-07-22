import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NativeDictionaryTest {

    @Test
    public void testIsKey() {
        NativeDictionary<String> nativeDictionary = new NativeDictionary<>(19, String.class);
        nativeDictionary.put("first", "first");
        assertTrue(nativeDictionary.isKey("first"));
        assertFalse(nativeDictionary.isKey("second"));
    }

    @Test
    public void testPut() {
        NativeDictionary<String> nativeDictionary = new NativeDictionary<>(19, String.class);
        nativeDictionary.put("first", "first");
        assertTrue(nativeDictionary.isKey("first"));
        assertEquals("first", nativeDictionary.get("first"));
    }

    @Test
    public void testReWriteKey() {
        NativeDictionary<String> nativeDictionary = new NativeDictionary<>(19, String.class);
        nativeDictionary.put("first", "first");
        nativeDictionary.put("first", "second");
        assertTrue(nativeDictionary.isKey("first"));
        assertEquals("second", nativeDictionary.get("first"));
    }

    @Test
    public void testGet() {
        NativeDictionary<String> nativeDictionary = new NativeDictionary<>(19, String.class);
        nativeDictionary.put("first", "first");
        nativeDictionary.put("second", "second");
        assertEquals("first", nativeDictionary.get("first"));
        assertEquals("second", nativeDictionary.get("second"));
        assertFalse(nativeDictionary.isKey("third"));
    }
}
