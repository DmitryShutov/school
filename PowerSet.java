import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class PowerSet {

    public static final int MAX_SIZE = 20000;
    public int size;
    public ArrayList<String> slots;

    public PowerSet() {
        slots = new ArrayList<String>(Collections.nCopies(MAX_SIZE, null));
        size = 0;
    }

    public PowerSet(Object[] values) {
        slots = new ArrayList<>(Collections.nCopies(MAX_SIZE, null));
        size = 0;
        Arrays.stream(values)
                .filter(v -> v != null)
                .forEach(v -> put((String) v));
    }

    public int size() {
        return size;
    }

    private int hashFun(String value) {
        if (value == null)
            return 0;
        return Math.abs(value.hashCode()) % MAX_SIZE;
    }

    public OptionalInt seekSlot(String value) {
        int index = hashFun(value);
        int startIndex = index;
        // do...while оказался наиболее быстрым вариантом
        do {
            if (slots.get(index) == null || slots.get(index).equals(value)) {
                return OptionalInt.of(index);
            }
            index = (index + 1) % MAX_SIZE;
        } while (index != startIndex);
        return OptionalInt.empty();
    }

    public void put(String value) {
        OptionalInt index = seekSlot(value);
        if (index.isPresent() && slots.get(index.getAsInt()) == null) {
            slots.set(index.getAsInt(), value);
            size++;
        }
    }

    public boolean get(String value) {
        return slots.contains(value);
    }

    public boolean remove(String value) {
        boolean result = slots.remove(value);
        if (result) {
            size--;
        }
        return result;
    }

    public PowerSet intersection(PowerSet set2) {
        return new PowerSet(slots.stream()
                .filter(v -> v != null && set2.get(v))
                .toArray());
    }

    public PowerSet union(PowerSet set2) {
        return new PowerSet(Stream.concat(slots.stream(), set2.slots.stream()).toArray());
    }

    public PowerSet difference(PowerSet set2) {
        return new PowerSet(slots.stream()
                .filter(v -> v != null && !set2.get(v))
                .toArray());
    }

    public boolean isSubset(PowerSet set2) {
        return set2.slots.stream()
                .filter(v -> v != null)
                .allMatch(this::get);
    }
}