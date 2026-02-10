public class Library {
    private Book[] books;
    private int curNumBooks;

    public Library(int capacity) {
        this.books = new Book[capacity];
        this.curNumBooks = 0;
    }
    public boolean addBook(Book book) {
        boolean didAdd = false;
        if(this.curNumBooks < this.books.length && book != null) {
            this.books[this.curNumBooks] = book;
            this.curNumBooks += 1;
            didAdd = true;
        }
        return didAdd;
    }

    public int findBook(Book book) {
        boolean didFind = false;
        int index = -1;

        if(book != null) {
            for(int i=0; i<curNumBooks && !didFind; i+=1) {
                Book curBook = books[i];
                boolean sameTitle = curBook.getTitle().equals(book.getTitle());
                boolean sameAuthor = curBook.getAuthor().equals(book.getAuthor());
                didFind = sameTitle && sameAuthor;
                index = i;
            }
        }
        return index;
    }

    public boolean checkedOut(Book book) {
        int index = findBook(book);
        boolean didCheckout=false;
        if (index >= 0 && !books[index].getCheckedOut()) {
            books[index].changeStatus();
            didCheckout=true;
        }
        return didCheckout;
    }

    public boolean returnBook(Book book){
        int index = findBook(book);
        boolean didReturn=false;
        if (index >= 0 && books[index].getCheckedOut()) {
            books[index].changeStatus();
            didReturn=true;
        }
        return didReturn;
    }
}
