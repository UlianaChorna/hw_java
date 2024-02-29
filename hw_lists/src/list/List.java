package list;

public interface List<T> {
    void add(T element);

    void addAtStart(T element);

    void addAt(int index, T element);

    int size();

    T get(int index);

    T getFirst();
    T getLast();

    T remove(int index);

    boolean contains(T element);

    void clear();

    boolean isEmpty();

    void set(int index, T element);
}
