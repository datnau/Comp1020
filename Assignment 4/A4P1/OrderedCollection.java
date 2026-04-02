public interface OrderedCollection {

    void insert(Song s);

    void delete(String title);

    Song search(String title);

    int size();

    boolean isEmpty();

    int getTotalDuration();

    void printAll();
}