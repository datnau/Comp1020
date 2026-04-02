import java.util.ArrayList;

public class UnorderedArrayList implements OrderedCollection {

    private ArrayList<Song> list;

    public UnorderedArrayList() {
        this.list = new ArrayList<>();
    }

    public void insert(Song s) {
        this.list.add(s); // NOT an ordered insert! (just a placeholder)
    }

    public void delete(String title) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getTitle().equals(title)) {
                this.list.remove(i);
                return;
            }
        }
    }

    public Song search(String title) {
        for (Song s : this.list) {
            if (s.getTitle().equals(title)) {
                return s;
            }
        }
        return null;
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int getTotalDuration() {
        int total = 0;
        for (Song s : this.list) {
            total += s.getDuration();
        }
        return total;
    }

    public void printAll() {
        for (Song s : this.list) {
            System.out.println(s);
        }
    }
}