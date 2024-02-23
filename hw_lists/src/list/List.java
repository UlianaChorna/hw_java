package list;

public interface List<T> {
    void add(T element);

    void addAtStart(T element);

    void addAt(int index, T element);

    int size();
}
