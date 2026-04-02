public class Playlist {

    private OrderedCollection songs;

    public Playlist() {
        songs = new UnorderedArrayList(); // YOU will need to change this
    }

    public void addSong(Song s) {
        songs.insert(s);
    }

    public void removeSong(String title) {
        songs.delete(title);
    }

    public Song search(String title) {
        return songs.search(title);
    }

    public void printAll() {
        songs.printAll();
    }

    public int getTotalDuration() {
        return songs.getTotalDuration();
    }
}