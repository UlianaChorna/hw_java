package list;

import java.io.Serializable;
import java.util.Objects;

public class LinkedList<T> implements List<T> , Serializable {

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
        for (T e: elements) {
            linkedList.add(e);
        }
        return  linkedList;

    }

    @Override
    public void add(T  element) {
        Node<T> newNode = new Node<>(element);
        if (this.first == null) {
            this.first = this.last = newNode;
        } else {
            Node<T> prev = getNodeByIndex(this.size - 1);
            prev.next = newNode;
            this.last = newNode;
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
        return  current;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }
    public int size() {
        return this.size;
    }

}
