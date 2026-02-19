package arraylist;

public class GenricArray<T> {

    private T[] arr;
    private int size;
    private int capacity;
    private static final int Default_CAPACITY = 10;

    public void add(T element) {
        if (size == capacity) {
            expandArray();
        }
        arr[size] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void expandArray() {
        capacity = capacity * 2;
        T[] newArr = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    public void set(int index, T element) {
        checkIndex(index);
        arr[index] = element;
    }

    public T remove(int index) {
        checkIndex(index);

        T removed = arr[index];

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[size - 1] = null;
        size--;

        return removed;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

















}
