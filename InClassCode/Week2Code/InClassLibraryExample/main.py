from book import Book
from library import Library

def main():
    # Create a library with capacity for 10 books
    my_library = Library(10)

    print("--- Adding Books ---")
    # Create books
    b1 = Book("The Way of Kings", "Brandon Sanderson")
    b2 = Book("Mistborn: The Final Empire", "Brandon Sanderson")
    b3 = Book("Sufficiently Advanced Magic", "Andrew Rowe")
    b4 = Book("On the Shoulders of Titans", "Andrew Rowe")
    b5 = Book("Unsouled", "Will Wight")
    b6 = Book("Soulsmith", "Will Wight")
    b7 = Book("Mother of Learning", "Domagoj Kurmaic")
    b8 = Book("Iron Prince", "Bryce O'Connor")

    # Add books to library
    my_library.add_book(b1)
    my_library.add_book(b2)
    my_library.add_book(b3)
    my_library.add_book(b4)
    my_library.add_book(b5)
    my_library.add_book(b6)
    my_library.add_book(b7)
    my_library.add_book(b8)

    print("Books added to library.")

    print("\n--- Checking Out Books ---")

    # Checkout existing books
    print(f"Checking out 'The Way of Kings': {my_library.checked_out(b1)}") # Should be True
    print(f"Checking out 'Unsouled': {my_library.checked_out(b5)}") # Should be True

    # Try to checkout already checked out book
    print(f"Checking out 'Unsouled' again: {my_library.checked_out(b5)}") # Should be False

    # Checkout non-existing book
    not_in_library = Book("Harry Potter", "J.K. Rowling")
    print(f"Checking out 'Harry Potter' (not in library): {my_library.checked_out(not_in_library)}")
    # Note: Due to the bug in Library.findBook, this might incorrectly modify another book or return unexpected results
    # depending on implementation, as we are faithfully reproducing the Java logic.

    print("\n--- Returning Books ---")

    # Return existing book
    print(f"Returning 'The Way of Kings': {my_library.return_book(b1)}") # Should be True

    # Return book that wasn't checked out
    print(f"Returning 'Mistborn' (not checked out): {my_library.return_book(b2)}") # Should be False

    # Return non-existing book
    print(f"Returning 'Harry Potter': {my_library.return_book(not_in_library)}")

if __name__ == "__main__":
    main()
