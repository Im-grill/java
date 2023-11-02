import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class DataStructures {

    public static class Stack<T> {
        private static class StackNode<T> {
            private T data;
            private StackNode<T> next;

            public StackNode(T data) {
                this.data = data;
            }
        }

        private StackNode<T> top;

        public boolean isEmpty() {
            return top == null;
        }

        public T peek() {
            if (isEmpty()) throw new EmptyStackException();
            return top.data;
        }

        public void push(T item) {
            StackNode<T> newNode = new StackNode<>(item);
            newNode.next = top;
            top = newNode;
        }

        public T pop() {
            if (isEmpty()) throw new EmptyStackException();
            T item = top.data;
            top = top.next;
            return item;
        }
    }

    public static class DoubleLinkedList<T> {
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

    // Main method for demonstration
    public static void main(String[] args) {
        // Demonstrate working with Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Stack pop: " + stack.pop()); // Outputs: Stack pop: 2

        // Demonstrate working with DoubleLinkedList
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addFirst(10);
        list.addLast(20);
        System.out.println("Removed from DoubleLinkedList: " + list.removeLast()); // Outputs: Removed from DoubleLinkedList: 20
    }
}

