public class Stack<T> {
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