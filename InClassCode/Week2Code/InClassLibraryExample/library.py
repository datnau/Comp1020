from book import Book

class Library:
    def __init__(self, capacity):
        self._books = [None] * capacity
        self._cur_num_books = 0

    def add_book(self, book):
        did_add = False
        if self._cur_num_books < len(self._books) and book is not None:
            self._books[self._cur_num_books] = book
            self._cur_num_books += 1
            did_add = True
        return did_add

    def find_book(self, book):
        did_find = False
        index = -1

        if book is not None:
            i = 0
            while i < self._cur_num_books and not did_find:
                cur_book = self._books[i]
                if cur_book is not None:
                    same_title = cur_book.get_title() == book.get_title()
                    same_author = cur_book.get_author() == book.get_author()
                    did_find = same_title and same_author

                index = i
                i += 1

        return index

    def checked_out(self, book):
        index = self.find_book(book)
        did_checkout = False
        if index >= 0 and self._books[index] is not None and not self._books[index].get_checked_out():
            self._books[index].change_status()
            did_checkout = True
        return did_checkout

    def return_book(self, book):
        index = self.find_book(book)
        did_return = False
        if index >= 0 and self._books[index] is not None and self._books[index].get_checked_out():
            self._books[index].change_status()
            did_return = True
        return did_return
