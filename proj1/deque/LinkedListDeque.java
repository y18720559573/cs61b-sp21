package deque;

public class LinkedListDeque <T> implements Deque<T> {
    public class Node {
        T item;
        Node prev;
        Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node((T) "6", null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque (T i) {
        sentinel = new Node((T) "6", null, null);
        sentinel.next = new Node(i, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size = size + 1;
    }

    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size = size + 1;
    }


    public void printDeque () {
        Node current = sentinel.next;
        while (current.next != sentinel) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.print(current.item + "\n");
    }

    public T removeFirst () {
        if (size == 0) { return null;}
        else {
            T i = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size = size - 1;
            return i;
        }
    }

    public T removeLast () {
        if (size == 0) { return null;}
        else {
            T i = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size = size - 1;
            return i;
        }
    }

    public T get (int index) {
        if (index >= 0 && index <=size) {
            Node current = sentinel;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.item;
        }
        else {
            return null;
        }
    }

    public boolean equals (Object o) {
        boolean equals = true;
        if (o instanceof LinkedListDeque) {
            if (size == ((LinkedListDeque) o).size) {
                Node current1 = sentinel;
                Node current2 = ((LinkedListDeque) o).sentinel;
                for (int i = 0; i < size; i++) {
                    if (current1.next.item != current2.next.item) {
                        equals = false;
                    }
                    current1 = current1.next;
                    current2 = current2.next;
                }
            }
            else equals = false;
        }
        else equals = false;
        return equals;
    }

    public int size () {
        return size;
    }

    public T helpRecursive (int pos, int index, Node current) {
        if (pos == index) {
            return current.item;
        }
        else return helpRecursive (pos + 1, index , current.next);
    }

    public T getRecursive (int index) {
        return helpRecursive(0, index, sentinel);
    }

    public static void main(String[] args) {
        LinkedListDeque c = new LinkedListDeque();
        c.addLast(1);
        c.addFirst(2);
        c.addFirst(3);
        c.addLast(4);
        c.printDeque();
        System.out.println(c.get(4));
        LinkedListDeque o = new LinkedListDeque(3);
        o.addLast(2);
        o.addLast(1);
        o.addLast(4);
        o.addLast(3);
        System.out.println(c.equals(o));
        System.out.println(c.getRecursive(4));
    }
}
