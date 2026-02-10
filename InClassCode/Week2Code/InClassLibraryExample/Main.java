public class Main {
    public static void main(String[] args) {
        // Create a library with capacity for 10 books
        Library myLibrary = new Library(10);

        System.out.println("--- Adding Books ---");
        // Create books
        Book b1 = new Book("The Way of Kings", "Brandon Sanderson");
        Book b2 = new Book("Mistborn: The Final Empire", "Brandon Sanderson");
        Book b3 = new Book("Sufficiently Advanced Magic", "Andrew Rowe");
        Book b4 = new Book("On the Shoulders of Titans", "Andrew Rowe");
        Book b5 = new Book("Unsouled", "Will Wight");
        Book b6 = new Book("Soulsmith", "Will Wight");
        Book b7 = new Book("Mother of Learning", "Domagoj Kurmaic");
        Book b8 = new Book("Iron Prince", "Bryce O'Connor");

        // Add books to library
        myLibrary.addBook(b1);
        myLibrary.addBook(b2);
        myLibrary.addBook(b3);
        myLibrary.addBook(b4);
        myLibrary.addBook(b5);
        myLibrary.addBook(b6);
        myLibrary.addBook(b7);
        myLibrary.addBook(b8);

        System.out.println("Books added to library.");

        System.out.println("\n--- Checking Out Books ---");

        // Checkout existing books
        System.out.println("Checking out 'The Way of Kings': " + myLibrary.checkedOut(b1)); // Should be true
        System.out.println("Checking out 'Unsouled': " + myLibrary.checkedOut(b5)); // Should be true

        // Try to checkout already checked out book
        System.out.println("Checking out 'Unsouled' again: " + myLibrary.checkedOut(b5)); // Should be false

        // Checkout non-existing book
        Book notInLibrary = new Book("Harry Potter", "J.K. Rowling");
        System.out.println("Checking out 'Harry Potter' (not in library): " + myLibrary.checkedOut(notInLibrary));
        // Note: Due to the bug in Library.findBook, this might incorrectly modify another book or return unexpected results
        // depending on implementation, but we are just running the client code here.

        System.out.println("\n--- Returning Books ---");

        // Return existing book
        System.out.println("Returning 'The Way of Kings': " + myLibrary.returnBook(b1)); // Should be true

        // Return book that wasn't checked out
        System.out.println("Returning 'Mistborn' (not checked out): " + myLibrary.returnBook(b2)); // Should be false

        // Return non-existing book
        System.out.println("Returning 'Harry Potter': " + myLibrary.returnBook(notInLibrary));
    }
}
