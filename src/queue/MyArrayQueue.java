package queue;

public class MyArrayQueue<T> {
    private Object[] arr;
    private int front;
    private int back;
    private int size;
    private int capacity;

    public MyArrayQueue() {
        capacity = 10;
        arr = new Object[capacity];
        front = 0;
        back = 0;
        size = 0;
    }

    public void enqueue(T value) {
        if (size == capacity) {
            resize();
        }
        arr[back] = value;
        back = (back + 1) % capacity;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T value = (T) arr[front];
        arr[front] = null;
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return (T) arr[front];

    }

    public void resize(){
        int newCapacity = capacity * 2;
        Object[] newArr  = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
           newArr[i] = arr[(front+i) % capacity];

        }
        arr = newArr;
        front = 0;
        back = size;
        capacity = newCapacity;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }



















}
