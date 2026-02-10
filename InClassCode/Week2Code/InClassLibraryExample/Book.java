public class Book {
    private String title;
    private String author;
    private boolean checkedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public boolean getCheckedOut() {
        return this.checkedOut;
    }

    public void changeStatus() {
        this.checkedOut = !this.checkedOut;
    }
}
