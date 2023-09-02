# RECURSION TEST

from bdb import Bdb
import sys


class RecursionDetected(Exception):
    pass


class RecursionDetector(Bdb):
    def do_clear(self, arg):
        pass

    def __init__(self, *args):
        Bdb.__init__(self, *args)
        self.stack = set()

    def user_call(self, frame, argument_list):
        code = frame.f_code
        if code in self.stack:
            raise RecursionDetected
        self.stack.add(code)

    def user_return(self, frame, return_value):
        self.stack.remove(frame.f_code)


def test_recursion(func):
    detector = RecursionDetector()
    detector.set_trace()
    try:
        func()
    except RecursionDetected:
        return True
    else:
        return False
    finally:
        sys.settrace(None)

# END TEST RECURSION


load_file_in_context('challenge.py')

try:
    if not test_recursion(lambda: find_min([1, 2, 3, 4])):
        fail_tests(
            "Define `find_min()` so that it uses RECURSIVE calls. Do not use iteration!")
    test_1 = find_min([-1, 2, 3])
    test_2 = find_min([4, 9, 2])
    test_3 = find_min([])

    if test_1 != -1:
        fail_tests("`find_min([-1, 2, 3])` should return `-1`.")
    if test_2 != 2:
        fail_tests("`find_min([4, 9, 2])` should return `2`.")
    if test_3 != None:
        fail_tests("`find_min([])` should return `None`.")
except NameError:
    fail_tests("Is the `find_min()` function defined?")

pass_tests()
