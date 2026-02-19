package arraylist;

public class MyArraylist {
    Object[] arr;
    int size = 0;
    int capacity;
    private static final int default_Size = 10;

    public MyArraylist(Object[] arr, int size, int capacity) {
        this.capacity = default_Size;
        this.arr = new Object[capacity];
        this.size = 0;
    }

    public void add(Object obj) {
        if (size == capacity) {
            expandArray();
        }
        arr[size] = obj;
        size++;
    }

    private void expandArray() {
        capacity = capacity * 2;
        Object[] newArr = new Object[capacity];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index; " + index);
        }
    }

    public void setIndex(int index, Object obj) {
        checkIndex(index);
        arr[index] = obj;
    }

    public Object remove(int index) {
        checkIndex(index);
        Object removed = arr[index];

        for (int i = index; i < size - 1; i++) {
            arr[index] = arr[index + 1];
        }
        arr[size - 1] = null;
        return removed;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
