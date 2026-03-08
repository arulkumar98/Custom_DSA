package hashmap;

public class MyHahMap<K, V> {
    private static class Node<K, V>{
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K,V>[] buckets;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float  LOAD_FACTOR = 0.75f;

    @SuppressWarnings("unchecked")
    public MyHahMap(){
        capacity = DEFAULT_CAPACITY;
        buckets = (Node<K, V>[]) new Node[capacity];
        size = 0;
    }

    private int getIndex(K key){
        int hash = key.hashCode() & 0x7fffffff;
        return hash % capacity;
    }

    public void put (K key, V value){
        if ((float) (size+1) / capacity > LOAD_FACTOR){
            resize();
        }

        int index = getIndex(key);
        Node<K,V> head = buckets[index];

        //replace if already key exist
        while (head != null){
            if (head.key.equals(key)){
               head.value = value;
               return;
            }
            head = head.next;
        }

        // else add to the new node;
        Node<K,V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    private void resize() {
    }

    public V get(K key){
        int index = getIndex(key);
        Node<K,V> head = buckets[index];

        while (head != null){
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public  V remove(K key){
        int index = getIndex(key);
        Node<K,V> head = buckets[index];
        Node<K,V> prev = null;

        while (head!=null){
            if (head.key.equals(key)){

                if (prev == null){
                    buckets[index] = head.next;
                }else {
                    prev.next = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize1() {

        Node<K,V>[] oldBuckets = buckets;

        capacity = capacity * 2;

        buckets = (Node<K,V>[]) new Node[capacity];

        size = 0;

        for (Node<K,V> head : oldBuckets) {

            while (head != null) {

                put(head.key, head.value);

                head = head.next;
            }
        }
    }



























}
