import java.lang.reflect.Array;
import java.util.Arrays;

class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;
    public static int step = 3;
    
    public NativeCache(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        hits = new int[size];
    }

    public int hashFun(String key) {
        int hash = 0;
        hash += key.chars().sum();
        return hash % size;
    }

    public int seekSlot(T value, String key) {
        int index = hashFun(key);
        int current = index;
        do {
            if (slots[current] == null || slots[current] == key) {
                return current;
            }
            current += step;
            if (current >= size) {
                current -= size;
            }
        } while (current != index);
        return clearMinimal();
    }

    public int clearMinimal() {
        int minIndex = hits[0];
        for (int i = 0; i < hits.length; i++) {
            if (hits[i] < hits[minIndex]) {
                minIndex = i;
            }
        }
        slots[minIndex] = null;
        values[minIndex] = null;
        hits[minIndex] = 0;
        return minIndex;
    }

    public void set(String key, T value) {
        int slot = seekSlot(value, key);
        slots[slot] = key;
        values[slot] = value;
        hits[slot] = 0;
    }

    public boolean isKey(String key) {
        return Arrays.asList(slots).contains(key);
    }

    public int findIndex(String key) {
        return Arrays.asList(slots).indexOf(key);
    }

    public T get(String key) {
        if (isKey(key)) {
            int index = findIndex(key);
            hits[index]++;
            return values[index];
        }
        return null;
    }

}