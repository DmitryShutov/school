import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PowerSet {

    public static final int MAX_SIZE = 20000;
    public int size;
    public String[] slots;
    public int step = 3;

    public PowerSet() {
        slots = new String[MAX_SIZE];
        size = 0;
    }

    public PowerSet(Object[] values) {
        slots = new String[MAX_SIZE];
        size = 0;
        for (Object val : Arrays.stream(values).filter(v -> !Objects.isNull(v)).toArray())
            put((String)val);
    }

    public int size() {
        return size;
    }

    public int hashFun(String value)
    {    
        int hash = 0;
        hash += value.chars().sum();
        return hash % MAX_SIZE;
    }

    public int seekSlot(String value)
    {
        int index = hashFun(value);
        int emptySlotIndex = IntStream.iterate(index, i -> (i + step) % size)
            .filter(i -> slots[i] == null || slots[i].equals(value))
            .findFirst()
            .orElse(-1);
        return emptySlotIndex;
    }

    public boolean isKey(String key) {
        return Arrays.asList(slots).contains(key);
    }

    public void put(String value) {
        if (isKey(value)) {
            return;
        }
        int slot = seekSlot(value);
        slots[slot] = value;
        size++;
    }

    public boolean get(String value) {
        return isKey(value);
    }

    public boolean remove(String value) {
        if (isKey(value)) {
            List<String> list = new ArrayList<>(Arrays.asList(slots));
            list.removeAll(Collections.singleton(value));
            slots = list.toArray(new String[0]);
            size--;
            return true;
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2) {
        return new PowerSet(Arrays.stream(slots).filter(set2::get).toArray());
    }

    public PowerSet union(PowerSet set2) {
        return new PowerSet(Stream.concat(Arrays.stream(slots), Arrays.stream(set2.slots)).toArray());
    }

    public PowerSet difference(PowerSet set2) {
        return new PowerSet(Arrays.stream(slots).filter(v -> !set2.get(v)).toArray());
    }

    public boolean isSubset(PowerSet set2) {
        return Arrays.stream(set2.slots).filter(v -> !get(v)).toArray().length == 0;
    }
}