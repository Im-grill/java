public class DoubleLinkedList<T> {
    private class Node {
        T data;
        Node prev;
        Node next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
    }

    public void addLast(T data) {
        if (head == null) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public T removeFirst() {
        if (head == null) throw new NoSuchElementException();
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        return data;
    }

    public T removeLast() {
        if (tail == null) throw new NoSuchElementException();
        T data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        return data;
    }
    // Other methods like isEmpty, size, etc. can be added as needed.
}
