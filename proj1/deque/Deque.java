package deque;

public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    default boolean isEmpty() {
        return size() == 0;
    };
    int size();
    public void printDeque();
    public T removeFirst();
    public T removeLast();
    public T get(int index);
}
