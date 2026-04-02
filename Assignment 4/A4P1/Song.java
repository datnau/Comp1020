public class Song implements Comparable<Song> {

    private String title;
    private int rating;
    private int duration;

    public Song(String title, int rating, int duration) {
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

    public String getTitle() {
        return this.title;
    }

    public int getRating() {
        return this.rating;
    }

    public int getDuration() {
        return this.duration;
    }

    public int compareTo(Song other) {

        if (this.rating != other.rating) {
            return other.rating - this.rating;
        }

        if (this.duration != other.duration) {
            return this.duration - other.duration;
        }

        return this.title.compareTo(other.title);
    }

    public String toString() {
        return title + " is rated: " + rating + ", and is " + duration + " seconds long.";
    }
}