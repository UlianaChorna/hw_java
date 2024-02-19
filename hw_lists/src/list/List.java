package list;

public interface List<T> {
    void add(T element);

    void addAtStart(T element);

    void addAt(int index, T element);

    int size();
//    void set(int index, T element);
//
    T get(int index);
//
//    T getFirst();
//
//    T getLast();
//
//    T remove(int index);
}
