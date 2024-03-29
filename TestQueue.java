import java.util.NoSuchElementException;

/**
 * FIFO
 */
class Queue<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> t = new Node<T>(item);

        if (last != null) {
            last.next = t;
        }

        last = t;

        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T data = first.data;
        first = first.next;
        
        if (first == null) {
            last = null;
        }

        return data;
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}

/**
 * TestQueue
 */
public class TestQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println("remove: " + q.remove());
        System.out.println("remove: " + q.remove());
        System.out.println("peek: " + q.peek());
        System.out.println(q.isEmpty());
        System.out.println("remove: " + q.remove());
        System.out.println(q.isEmpty());
        System.out.println("remove: " + q.remove());
        System.out.println(q.isEmpty());
    }
}