package deque;

public class ArrayDeque <T> implements Deque<T> {
    private int size;
    private int front;
    private int back;
    private T[] array;

    private void resizing () {
        T[] newArray = (T[]) new Object[size*2];
        System.arraycopy(array, 0, newArray, 0, back);
        System.arraycopy(array, front+1, newArray, size+back,size-back);
        front = front + size;
        array = newArray;
    }

    /** Creates an empty list. */
    public ArrayDeque () {
        size = 0;
        array = (T[]) new Object[8];
        front = 4;
        back = 5;
    }

    public void addFirst(T x) {
        if (size == array.length) resizing();
        if (front == 0) {
            array[front] = x;
            front = array.length - 1;
            size = size + 1;
        }
        else {
            array[front] = x;
            front = front - 1;
            size = size + 1;
        }
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == array.length) resizing();
        if (back == array.length - 1) {
            array[back] = x;
            back = 0;
            size = size + 1;
        }
        else {
            array[back] = x;
            back = back + 1;
            size = size + 1;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get (int index) {
        if (index >= 0 && index <= size) {
            if (front + index < array.length) {
                return array[front + index];
            }
            else {
                return array[front + index - array.length];
            }
        }
        else return null;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast () {
        if (size == 0) return null;
        else {
            if (back == 0) {
                T last = array[array.length - 1];
                array[array.length - 1] = null;
                back = array.length - 1;
                size = size - 1;
                return last;
            }
            else {
                T last = array[back - 1];
                array[back - 1] = null;
                back = back - 1;
                size = size - 1;
                return last;
            }
        }
    }

    public void printDeque () {
        if (front + size < array.length) {
            for (int i = 1; i <= size; i++) {
                System.out.print(array[front + i] + " ");
            }
        }
        else {
            for (int i = front + 1; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            for (int i = 0; i < front + size - array.length + 1; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }

    public T removeFirst () {
        if (size == 0) return null;
        else {
            if (front == array.length-1) {
                T first = array[0];
                array[0] = null;
                front = 0;
                size = size - 1;
                return first;
            }
            else {
                T first = array[front+1];
                array[front+1] = null;
                front = front + 1;
                size = size - 1;
                return first;
            }
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque();
//        a.addLast(1);
//        a.addLast(2);
//        a.addLast(3);
//        a.addLast(100);
//        a.removeLast();
//        a.addLast(30);
//        a.addLast(40);
//        a.printDeque();
//        a.removeLast();
//        a.addLast(50);
//        a.addLast(60);
//        a.addLast(70);
//        int b = a.get(7);
//        a.printDeque();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);
        a.addFirst(4);
        a.printDeque();
        a.addFirst(5);
        a.removeFirst();
        a.addFirst(6);
        a.removeFirst();
        a.addFirst(7);
        a.addFirst(8);
        a.addFirst(9);
        a.printDeque();
    }
}