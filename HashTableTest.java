import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    @Test
    public void testHashTableCreation() {
        HashTable hashTable = new HashTable(19, 3);
        assertEquals(19, hashTable.size);
        assertEquals(3, hashTable.step);
        assertEquals(19, hashTable.slots.length);
        for (int i = 0; i < hashTable.slots.length; i++) {
            assertNull(hashTable.slots[i]);
        }
    }
    
    @Test
    public void testHashTablePut() {
        HashTable hashTable = new HashTable(19, 3);
        String first = "first";
        assertEquals(hashTable.hashFun(first), hashTable.put(first));
    }

    @Test
    public void testhashFun() {
        int size = 19;
        HashTable hashTable = new HashTable(size, 3);
        String a = "a";
        assertEquals(a.charAt(0) % size, hashTable.hashFun(a));
    }

    @Test 
    public void testHashFunCollision() {
        int size = 19;
        HashTable hashTable = new HashTable(size, 3);
        String a = "ab";
        String b = "ba";
        assertEquals(hashTable.hashFun(a), hashTable.hashFun(b));
    }

    @Test
    public void testSeekSlot() {
        int size = 19;
        HashTable hashTable = new HashTable(size, 3);
        String a = "a";
        String b = "b";
        String c = "c";
        hashTable.put(a);
        hashTable.put(b);
        assertEquals(c.charAt(0) % size, hashTable.seekSlot(c));
    }

    @Test
    public void testSeekSlotCollision() {
        int size = 19;
        int step = 3;
        HashTable hashTable = new HashTable(size, step);
        String a = "ab";
        String b = "ba";
        int slot = hashTable.put(a);
        assertEquals(slot + step, hashTable.seekSlot(b));
    }

    @Test
    public void testFind() {
        int size = 19;
        int step = 3;
        HashTable hashTable = new HashTable(size, step);
        String a = "ab";
        String b = "ba";
        hashTable.put(a);
        hashTable.put(b);
        assertEquals(hashTable.hashFun(a), hashTable.find(a));
        assertEquals(hashTable.hashFun(b) + step, hashTable.find(b));
    }

    @Test
    public void testFindNotFound() {
        int size = 19;
        int step = 3;
        HashTable hashTable = new HashTable(size, step);
        String a = "ab";
        String b = "ba";
        hashTable.put(a);
        hashTable.put(b);
        assertEquals(-1, hashTable.find("c"));
    }

    @Test
    public void testFindEmpty() {
        int size = 19;
        int step = 3;
        HashTable hashTable = new HashTable(size, step);
        assertEquals(-1, hashTable.find("c"));
    }

    @Test
    public void testFindCollision() {
        int size = 19;
        int step = 3;
        HashTable hashTable = new HashTable(size, step);
        String a = "ab";
        String b = "ba";
        hashTable.put(a);
        hashTable.put(b);
        assertEquals(hashTable.hashFun(a) + step, hashTable.find(b));
    }

    @Test
    public void testFindCollisionNotFound() {
        int size = 19;
        int step = 3;
        HashTable hashTable = new HashTable(size, step);
        String a = "ab";
        String b = "ba";
        hashTable.put(a);
        hashTable.put(b);
        assertEquals(-1, hashTable.find("c"));
    }

    @Test 
    public void testPut() {
        int size = 19;
        int step = 3;
        HashTable hashTable = new HashTable(size, step);
        String a = "a";
        assertEquals(hashTable.hashFun(a), hashTable.put(a));
    }

    @Test
    public void testPutCollision() {
        int size = 19;
        int step = 3;
        HashTable hashTable = new HashTable(size, step);
        String a = "ab";
        String b = "ba";
        int slot = hashTable.put(a);
        assertEquals(slot + step, hashTable.put(b));
    }
}
