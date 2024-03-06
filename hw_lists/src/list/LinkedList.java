package list;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<T> implements List<T>, Serializable {
    private Node<T> last;
    private Node<T> first;
    private int size;
    static class Node<T> {
        T element;
        Node<T> next;
        public Node(T element) {
            this.element = element;
        }
    }

    @SafeVarargs
    public static <T> List<T> of(T... elements) {
        LinkedList<T> linkedList = new LinkedList<>();
        for (T e : elements) {
            linkedList.add(e);
        }
        return linkedList;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (this.first == null) {
            this.first = this.last = newNode;
        } else {
            Node<T> prev = getNodeByIndex(this.size - 1);
            prev.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public void addAtStart(T element) {
        Node<T> newNode = new Node<>(element);
        if (this.first == null) {
            this.first = this.last = newNode;
        } else {
            newNode.next = first;
            this.first = newNode;
        }
        size++;
    }

    @Override
    public void addAt(int index, T element) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addAtStart(element);
            return;
        }

        if (index == this.size) {
            add(element);
            return;
        }

        Node<T> newNode = new Node<>(element);
        if (this.first == null) {
            this.first = this.last = newNode;
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size - 1);
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = first.element;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prev = getNodeByIndex(index - 1);
            removedElement = prev.next.element;
            prev.next = prev.next.next;
            if (index == size - 1) {
                last = prev;
            }
        }


        size--;
        return removedElement;
    }

    @Override
    public boolean contains(T element) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }


    public int size() {
        return this.size;
    }

    @Override
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        Node<T> node = getNodeByIndex(index);
        node.element = element;
    }

    @Override
    public String toString() {
         if (size == 0) {
             return "[]";
         }

        if (size == 1) {
            return "[" + first.element.toString() + "]";
        }

        StringBuilder string = new StringBuilder("[" + first.element.toString());
        Node<T> item = first.next;
        while (Objects.nonNull(item) && Objects.nonNull(item.element)) {
            string.append(", ").append(item.element);
            item = item.next;
        }

        return string.append("]").toString();
    }
}
