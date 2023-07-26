import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PowerSet {

    public static final int MAX_SIZE = 20000;
    public int size;
    public String[] slots;

    public PowerSet() {
        slots = new String[MAX_SIZE];
        size = 0;
    }

    public PowerSet(Object[] values) {
        slots = new String[MAX_SIZE];
        size = 0;
        Arrays.stream(values)
              .filter(v -> !Objects.isNull(v))
              .forEach(v -> put((String) v));
    }

    public int size() {
        return size;
    }

    private int hashFun(String value) {
        if (value == null)
            return 0;
        return Math.abs(value.hashCode()) % slots.length;
    }

    public OptionalInt seekSlot(String value)
    {   
        return Arrays.stream(getIndexes(value))
                .filter(i -> value == null || slots[i] == null || slots[i].equals(value))
                .limit(1L)
                .findFirst();

    }

    public boolean isKey(String key) {
        return Arrays.asList(slots).contains(key);
    }

    public void put(String value) {
        OptionalInt index = seekSlot(value);
        if (index.isPresent() && slots[index.getAsInt()] == null) {
            slots[index.getAsInt()] = value;
            size++;
        }
    }

    public boolean get(String value) {
        return Arrays.stream(getIndexes(value)).anyMatch(i -> value.equals(slots[i]));
    }

    private int[] getIndexes(String value) {
        return IntStream.concat(IntStream.range(hashFun(value), slots.length), IntStream.range(0, hashFun(value))).toArray();
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
        return new PowerSet(Arrays.stream(slots)
                    .filter(v -> v != null && set2.get(v))
                    .toArray());
    }

    public PowerSet union(PowerSet set2) {
        return new PowerSet(Stream.concat(Arrays.stream(slots), Arrays.stream(set2.slots)).toArray());
    }

    public PowerSet difference(PowerSet set2) {
        return new PowerSet(Arrays.stream(slots)
                .filter(v -> v != null && !set2.get(v))
                .toArray());
    }

    public boolean isSubset(PowerSet set2) {
        return Arrays.stream(set2.slots)
                .filter(v -> v != null)
                .allMatch(this::get);
    }
}