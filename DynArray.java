import java.lang.reflect.Array;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    private int min_capacity = 16;
    private int multiplyer = 2;
    private double shrinkCoeff = 1.5;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);
        count = 0;
        makeArray(min_capacity);
    }

    public void makeArray(int new_capacity) {
        T[] newArray = (T[]) Array.newInstance(clazz, new_capacity);
        if (array != null) {
            System.arraycopy(array, 0, newArray, 0, count);
        }
        array = newArray;
        capacity = new_capacity;
    }

    public T getItem(int index) {
        if (index >= count) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void append(T itm) {
        if (count >= capacity) {
            makeArray(capacity * multiplyer);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (index > count) {
            throw new IndexOutOfBoundsException();
        }
        if (count == capacity) {
            makeArray(capacity * multiplyer);
        }
        System.arraycopy(array, index, array, index + 1, count - index);
        array[index] = itm;
        count++;
    }

    public void remove(int index) {
        if (index >= count) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, count - index - 1);

        count--;

        if (capacity > min_capacity && count < capacity / 2) {
            int calc_capacity = (int) (capacity / shrinkCoeff);
            int newCapacity = calc_capacity < min_capacity ? min_capacity : calc_capacity;
            makeArray(newCapacity);
        }
    }

}
