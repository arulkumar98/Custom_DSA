package stack;

public class MyStack <T>{
    private Object[] arr;
    private int size;
    private int capacity;

    public MyStack() {
      capacity = 20;
      arr = new Object[capacity];
      size = 0;
    }

    public void push(T value){
        if (size == capacity){
            resize();
        }
        arr[size] = value;
        size++;
    }

    public T pop(){
        if (isEmpty()){
            throw new RuntimeException("Stack is empty");
        }

        T value = (T) arr[size-1];
        arr[size-1] = null;
        size--;
        return value;

    }

    public T peek() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return (T) arr[size - 1];
    }

    private boolean isEmpty(){
        return size == 0;
    }




    private void resize() {
        capacity = capacity * 2;
        Object[] newArr = new Object[capacity];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

}
