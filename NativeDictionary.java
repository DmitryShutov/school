import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;
    private int step = 3;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
        }
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
        return -1;
    }

    public boolean isKey(String key) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == key) {
                return true;
            }
        }
        return false;
    }

    public void put(String key, T value) {
        int slot = seekSlot(value, key);
        slots[slot] = key;
        values[slot] = value;
    }

    public T get(String key) {
        if (!isKey(key)) {
            return null;
        }
        int index = hashFun(key);
        int current = index;
        do {
            if (slots[current].equals(key)) {
                return values[current];
            }
            current += step;
            if (current >= size) {
                current -= size;
            }
        } while (current != index);
        return null;
    }
}