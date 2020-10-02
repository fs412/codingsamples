""" My name is Fran Sabetpour and here is my script for several tests including vowel counting, list, fraction simplifier and generator. """
import unittest
#part 1
def count_vowels(string):
    vowels = ['a', 'e', 'i', 'o', 'u']
    count = 0
    for c in string:
        if c.lower() in vowels:
            count += 1
    return count

class CountVowelsTest(unittest.TestCase):

    def test_count_vowels(self):
        """ Test for counting vowels """
        self.assertEqual(count_vowels('hello world'), 3)
        self.assertEqual(count_vowels('hEllO wrld'), 2)
        self.assertEqual(count_vowels('hll wrld'), 0)
#part 2
def find(target, list): 
    last = None
    for i in range(len(list)): 
        if list[i] == target:
            last = i
    return last

class findTest(unittest.TestCase):

    def test_find(self):
        """ Test for find and list """
        self.assertEqual(find(33,[42,33,21,33]), 3)
        self.assertEqual(find(42,[42,33,21,33]), 0)
        self.assertEqual(find(21,[42,33,21,33]), 2)

#part 3
class Fraction: 

    def __init__(self, numerator, denominator): 
        self.numerator = numerator 
        self.denominator = denominator
        if denominator == 0:
            raise ZeroDivisionError("0 is an invalid denominator.")
        self.simplify()

    def __add__(self, other):
        resultNumerator = self.numerator*other.denominator + self.denominator*other.numerator
        resultDenominator = self.denominator * other.denominator 
        return Fraction(resultNumerator, resultDenominator)

    def __sub__(self, other):
        resultNumerator = (self.numerator * other.denominator) - (self.denominator * other.numerator)
        resultDenominator = self.denominator * other.denominator
        return Fraction(resultNumerator, resultDenominator)

    def __mul__(self, other):
        resultNumerator = self.numerator * other.numerator
        resultDenominator = self.denominator * self.denominator
        return Fraction(resultNumerator, resultDenominator)

    def __truediv__(self, other):
        resultNumerator = self.numerator * other.denominator
        resultDenominator = self.denominator * other.numerator
        return Fraction(resultNumerator, resultDenominator)

    def __eq__(self, other):
        return (self.numerator*other.denominator) == (self.denominator*other.numerator)

    def __ne__(self, other):
        return not self == other

    def __lt__(self, other):
        return True if (self.numerator*other.denominator) < (self.denominator*other.numerator) else False

    def __le__(self, other):
        return (self.numerator*other.denominator) <= (self.denominator*other.numerator)

    def __gt__(self, other):
        return (self.numerator*other.denominator) > (self.denominator*other.numerator)

    def __ge__(self, other):
        return (self.numerator*other.denominator) >= (self.denominator*other.numerator)

    def __str__(self):
        if(self.denominator == 1):
            return str(self.numerator)
        return (str(self.numerator) + '/' + str(self.denominator))

    def simplify(self):
        a = self.numerator
        b = self.denominator
        while b:
            a, b = b, a % b
        self.numerator //= a
        self.denominator //= a

class FractionTest(unittest.TestCase): 

    def test_plus(self):
        """ Testing for adding fractions. """
        f12 = Fraction(1, 2)
        f44 = Fraction(4, 4)
        self.assertTrue((f12 + f12) == Fraction(4, 4))
        self.assertTrue((f12 + f44) == Fraction(12, 8))
        self.assertFalse((f12 + f44) == Fraction(9, 3))

    def test_sub(self):
        """ Testing for subtracting fractions. """
        f44 = Fraction(4, 4)
        f12 = Fraction(1, 2)
        self.assertTrue((f44 - f12) == Fraction(4, 8))
        self.assertFalse((f44 - f12) == Fraction(9, 3))

    def test_mul(self):
        """ Testing for multiplying fractions. """
        f24 = Fraction(2, 4)
        f12 = Fraction(1, 2)
        self.assertTrue((f24 * f12) == Fraction(1, 4))
        self.assertFalse((f24 * f12) == Fraction(3, 9))

    def test_truediv(self):
        """ Testing for dividing fractions. """
        f56 = Fraction(5, 6)
        f78 = Fraction(7, 8)
        self.assertTrue((f56 / f78) == Fraction(40, 42))
        self.assertFalse((f56 / f78) == Fraction(3, 9))

    def test_eq(self):
        """ Testing to see if the fractions are equal to each other. """
        f11 = Fraction(1, 1)
        self.assertTrue((f11 == f11) == Fraction(1, 1))
        f1 = Fraction(3, 4)
        f2 = Fraction(6, 8)
        f3 = Fraction(9, 12)
        self.assertTrue(f1 == f1)
        self.assertTrue(f1 == f2)
        self.assertTrue(f1 == f3)
        self.assertTrue(f2 == f3)
        self.assertFalse(f1 == Fraction(3, 5))
        f128 = Fraction(12, 8)
        f32 = Fraction(3, 2)
        self.assertTrue(f128 == f32)

    def test_ne(self):
        """ Testing to see if the fractions are not equal to each other. """
        f89 = Fraction(8, 9)
        f46 = Fraction(4, 6)
        self.assertTrue(f89 != f46) 
        self.assertFalse(f89 != f89) 

    def test_lt(self):
        """ Testing for x < y. """
        f12 = Fraction(1, 2)
        f34 = Fraction(3, 4)
        self.assertTrue(f12 < f34)
        self.assertFalse(f34 < f12)

    def test_le(self):
        """ Testing for x <= y. """
        f23 = Fraction(2, 3)
        f34 = Fraction(3, 4)
        self.assertTrue(f23 <= f34)
        self.assertFalse(f34 <= f23)

    def test_gt(self):
        """ Testing for x > y. """
        f22 = Fraction(2, 2)
        f12 = Fraction(1, 2)
        self.assertTrue(f22 > f12)
        self.assertFalse(f12 > f22)

    def test_ge(self):
        """ Testing for x >= y. """
        f64 = Fraction(6, 4)
        f12 = Fraction(1, 2)
        self.assertTrue(f64 >= f12)
        self.assertFalse(f12 >= f64)

def test_suite():
    """ Here is the test suite for numbers to be tested. """
    f12 = Fraction(1, 2)
    f44 = Fraction(4, 4)
    f128 = Fraction(12, 8)
    f32 = Fraction(3, 2)
    print(f"{f12} + {f12} = {f12.__add__(f12)} [4/4]")
    print(f"{f44} - {f12} = {f44.__sub__(f12)} [4/8]")
    print(f"{f12} + {f44} = {f12.__add__(f44)} [12/8]")
    print(f"{f128} == {f32} is {f128.__add__(f32)} [True]")

def get_number(prompt):
    while True:
        inp = input(prompt)
        try:
            return float(inp)
        except ValueError:
            print("Error " + inp + " is not a number. Please try again.")

def main():
    print ("Welcome to the fraction calculator! Let's get started!")
    try:
        Fraction1numerator = int(input("Fraction 1 numerator: "))
        Fraction1denominator = int(input("Fraction 1 denominator: "))
        Operation = input("Operation (+, -, *, /): ")
        Fraction2numerator = int(input("Fraction 2 numerator: "))
        Fraction2denominator = int(input("Fraction 2 denominator: "))
        f1 = Fraction(Fraction1numerator, Fraction1denominator)
        f2 = Fraction(Fraction2numerator, Fraction2denominator)
    except ValueError:
        print("Error! You entered an invalid character. Please try again.")
        return


    if Operation == "+":
        f3 = f1.__add__(f2)
        print(str(f1) + " + " + str(f2) + " = " + str(f3))
    elif Operation == "-":
        f3 = f1.__sub__(f2)
        print(str(f1) + " - " + str(f2) + " = " + str(f3))
    elif Operation == "*":
        f3 = f1.__mul__(f2)
        print(str(f1) + " * " + str(f2) + " = " + str(f3))
    elif Operation == "/":
        f3 = f1.__truediv__(f2)
        print(str(f1) + " / " + str(f2) + " = " + str(f3))
    elif f1.__eq__(f2):
        print("True")
    else:
        print("Error: " + Operation + " is an unrecognized operation. Please enter either + to add, - to subtract, * to multiply, or / to divide.")
#part 4
def my_enumerate(seq):
    for i in range(len(seq)):
        yield i, seq[i]

class MyEnumerateTest(unittest.TestCase):
    def test_with_string(self):
        """ Test with strings. """
        self.assertEqual([(0, "h"), (1, "i"), (2, "!")], list(my_enumerate("hi!")))

    def test_with_integers(self):
        """ Test with numbers. """
        self.assertEqual([(0, 3), (1, 4), (2, 5)], list(my_enumerate([3, 4, 5])))

if __name__ == "__main__":
    unittest.main(exit=False, verbosity=2)