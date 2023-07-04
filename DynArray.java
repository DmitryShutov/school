import java.lang.reflect.Array;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    private int min_capacity = 16;
    private int multiplyer = 2;
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
        // ваш код
        return null;
    }

    public void append(T itm) {
        if (count > capacity) {
            makeArray(capacity * multiplyer);
        }
        array[count] = itm;
        count++;
        // ваш код
    }

    public void insert(T itm, int index) {
        // ваш код
    }

    public void remove(int index) {
        // ваш код
    }

}
