class Book:
    def __init__(self, title, author):
        self._title = title
        self._author = author
        self._checked_out = False

    def get_title(self):
        return self._title

    def get_author(self):
        return self._author

    def get_checked_out(self):
        return self._checked_out

    def change_status(self):
        self._checked_out = not self._checked_out
