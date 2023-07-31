import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NativeCacheTest {
    @Test
    public void testAdd() {
        NativeCache<Integer> cache = new NativeCache<>(5, Integer.class);
        cache.set("1", 1);
        cache.set("2", 2);
        cache.set("3", 3);
        cache.set("4", 4);
        cache.set("5", 5);
        assertTrue(cache.isKey("1"));
        assertTrue(cache.isKey("2"));
        assertTrue(cache.isKey("3"));
        assertTrue(cache.isKey("4"));
        assertTrue(cache.isKey("5"));
    }

    @Test
    public void testHits() {
        NativeCache<Integer> cache = new NativeCache<>(5, Integer.class);
        cache.set("1", 1);
        cache.set("2", 2);
        cache.set("3", 3);
        cache.set("4", 4);
        cache.set("5", 5);
        cache.get("1");
        cache.get("2");
        cache.get("3");
        cache.get("4");
        cache.get("5");
        cache.get("5");
        assertEquals(1, cache.hits[cache.findIndex("1")]);
        assertEquals(1, cache.hits[cache.findIndex("2")]);
        assertEquals(1, cache.hits[cache.findIndex("3")]);
        assertEquals(1, cache.hits[cache.findIndex("4")]);
        assertEquals(2, cache.hits[cache.findIndex("5")]);
    }

    @Test
    public void testOverflow() {
        NativeCache<Integer> cache = new NativeCache<>(5, Integer.class);
        cache.set("1", 1);
        cache.set("2", 2);
        cache.set("3", 3);
        cache.set("4", 4);
        cache.set("5", 5);
        cache.get("1");
        cache.get("1");
        cache.get("2");
        cache.get("2");
        cache.get("3");
        cache.get("4");
        cache.set("6", 6);
        assertFalse(cache.isKey("5"));
        assertTrue(cache.isKey("6"));
        assertEquals(0, cache.hits[cache.findIndex("6")]);
        assertEquals(2, cache.hits[cache.findIndex("1")]);
        assertEquals(2, cache.hits[cache.findIndex("2")]);
        assertEquals(1, cache.hits[cache.findIndex("3")]);
        assertEquals(1, cache.hits[cache.findIndex("4")]);
    }

    @Test
    public void testTwentyThousands() {
        NativeCache<Integer> cache = new NativeCache<>(20000, Integer.class);
        for (int i = 0; i < 20000; i++) {
            cache.set(String.valueOf(i), i);
        }
        for (int i = 0; i < 20000; i++) {
            assertEquals(i, cache.get(String.valueOf(i)));
        }
    }

    @Test
    public void testTwentyThousandsWithOverflow() {
        NativeCache<Integer> cache = new NativeCache<>(20000, Integer.class);
        for (int i = 0; i < 20000; i++) {
            cache.set(String.valueOf(i), i);
        }
        for (int i = 0; i < 19998; i++) {
            assertEquals(i, cache.get(String.valueOf(i)));
        }
        cache.set("20001", 20001);
        cache.get("20001");
        cache.set("20002", 20002);
        assertFalse(cache.isKey("19998"));
        assertTrue(cache.isKey("20001"));
        assertFalse(cache.isKey("19999"));
        assertTrue(cache.isKey("20001"));
    }
}
