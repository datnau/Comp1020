public class Book implements Comparable<Book> {
    private String title;
    private int pages;

    public Book(String title, int pages){
        this.title = title;
        this.pages = pages;
    }

    public int compareTo(Book other){
        if(this.pages == other.pages){
            return this.title.compareTo(other.title);
        }
        return this.pages - other.pages;
    }
}
