"""
InClassException.py

Demonstrates Exception handling in Python and compares it with Java.
"""
import sys
import traceback

def main(args):
    null_var = None
    # real_var = "All the things!"

    try:
        i = 0

        # Java: nullVar.charAt(0)
        # Python equivalent: accessing index 0 of the variable.
        # DIFFERENCE:
        # In Java, calling a method on null throws NullPointerException.
        # In Python, None is an object. Trying to use it like a string (subscript)
        # raises TypeError ('NoneType' object is not subscriptable).
        # Calling a method on it raises AttributeError.
        print(null_var[0])

        # print(real_var[0])

    except ZeroDivisionError as e:
        # Java: ArithmeticException (e.g. 1/0)
        # Python: ZeroDivisionError
        print("Caught ZeroDivisionError")

    except (TypeError, AttributeError) as e:
        # Java: NullPointerException
        # Python: TypeError or AttributeError are the closest equivalents
        # depending on how you try to use the None object.
        print("Caught TypeError/AttributeError (similar to NullPointerException)")
        print(f"Exception Message: {e}")

        # Python doesn't have a direct printStackTrace() on the exception object,
        # but the traceback module can print it.
        traceback.print_exc()

        # Re-raising the exception to mimic 'throw e'
        raise e

    except Exception as ex:
        # Java: Exception (catch-all)
        # Python: Exception (catch-all)
        print("Caught Exception")
        # print(f"Exception Message: {ex}")

    finally:
        print("This always runs")

    # Calling a method that raises an exception
    throwing_method()

    # Example of catching the thrown error (commented out in original)
    # try:
    #     pass
    # except Exception as e:
    #     print("Catch throwing error")


    print("The end")

def throwing_method():
    """
    Helper method that causes a division by zero.
    DIFFERENCE:
    - Java specifies 'throws ArithmeticException' in signature (optional for runtime exceptions).
    - Python does not declare thrown exceptions in the signature.
    """
    # Python uses // for integer division, / for float division.
    # Both raise ZeroDivisionError if dividing by zero.
    return 1 // 0

def other_throwing_method():
    some_condition = True
    if some_condition:
        # Java: throw new RuntimeException("Some message");
        # Python: raise RuntimeError("Some message")
        raise RuntimeError("Some message")

if __name__ == "__main__":
    main(sys.argv)
