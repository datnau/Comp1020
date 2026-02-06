"""
FileReadingDemo.py

This module demonstrates different ways to read files in Python,
mirroring the Java examples for educational comparison.

Differences between Java and Python are noted in comments.
"""
import sys

def main(args):
    filename = "file.txt"

    print("--- Method 1: open() read(1) (Char by Char) ---")
    read_with_file_reader(filename)
    print("\n")

    print("--- Method 2: open() readline() (Line by Line) ---")
    read_with_buffered_reader(filename)
    print("\n")

    print("--- Method 3: open() iterator (Token/Line) ---")
    read_with_scanner(filename)
    print("\n")

def read_with_file_reader(filename):
    """
    Method 1: "FileReader" equivalent
    READS: One character at a time.

    DIFFERENCES:
    - Java: Use FileReader class.
    - Python: Use built-in open() function.
    - Java: read() returns an int (-1 at EOF).
    - Python: read(1) returns a string of length 1 (empty string '' at EOF).
    - Error Handling: Java uses Checked Exceptions. Python uses Unchecked Exceptions.
    """
    # Python uses try-except blocks, not try-catch
    try:
        # open() is the built-in function to access files.
        # 'r' mode means read-only (default).
        fr = open(filename, 'r')

        # Read one character (passing 1 to read())
        char = fr.read(1)

        # Check for empty string which indicates EOF in Python
        while char != '':
            # print() adds a newline by default; use end='' to suppress it
            # to match the behavior of Java's System.out.print
            print(char, end='')
            char = fr.read(1)

        # Always close the stream!
        fr.close()

    except IOError as e:
        # Python catches IOError (or OSError) for file related issues
        print(f"An error occurred: {e}")

def read_with_buffered_reader(filename):
    """
    Method 2: "BufferedReader" equivalent
    READS: Whole lines at a time.

    DIFFERENCES:
    - Java: Must wrap FileReader in BufferedReader to get readLine().
    - Python: The file object returned by open() already has buffering
      and a readline() method.
    """
    try:
        # No wrapper needed in Python; open() returns a file object
        br = open(filename, 'r')

        line = br.readline()

        # readline() returns empty string '' at end of file.
        # Unlike Java's readLine() which returns null.
        while line != '':
            # Java's readLine() strips the newline character, so println adds one.
            # Python's readline() keeps the newline character.
            # To match Java's output, we allow proper spacing or control it with end=''.
            print(line, end='')

            line = br.readline()

        br.close()

    except IOError as e:
        print(f"An error occurred: {e}")

def read_with_scanner(filename):
    """
    Method 3: "Scanner" equivalent
    READS: Lines (or tokens) by iterator.

    DIFFERENCES:
    - Java: Scanner is a distinct class for parsing tokens/lines.
    - Python: Iterating directly over the file object is the standard
      "line-by-line" reading method, similar to Scanner's hasNextLine loop.
    """
    try:
        file_obj = open(filename, 'r')

        # Standard for-loop pattern for files in Python.
        # This is equivalent to while(sc.hasNextLine())
        for line in file_obj:
            print(line, end='')

        file_obj.close()

    except FileNotFoundError as e:
        # Scanner specifically throws FileNotFoundException (subclass of IOException)
        # Python raises FileNotFoundError
        print(f"File not found: {filename}")

# Standard boilerplate to run the main method
if __name__ == "__main__":
    main(sys.argv)
