""" My name is Fran Sabetpour and here is my script for a fraction calculator! """

class Fraction: 

    def __init__(self, numerator, denominator): 
        self.numerator = numerator 
        self.denominator = denominator
        if self.denominator == 0:
            raise ValueError

    def plus(self,other):
        resultNumerator = self.numerator*other.denominator + self.denominator*other.numerator
        resultDenominator = self.denominator * other.denominator 
        return Fraction(resultNumerator, resultDenominator)

    def minus(self, other):
        resultNumerator = (self.numerator * other.denominator) - (self.denominator * other.numerator)
        resultDenominator = self.denominator * other.denominator
        return Fraction(resultNumerator, resultDenominator)

    def times(self,other):
        resultNumerator = self.numerator * other.numerator
        resultDenominator = self.denominator * self.denominator
        return Fraction(resultNumerator, resultDenominator)

    def divide(self,other):
        resultNumerator = self.numerator * other.denominator
        resultDenominator = self.denominator * other.numerator
        return Fraction(resultNumerator, resultDenominator)

    def equal(self, other):
        return (self.numerator*other.denominator) == (self.denominator*other.numerator)

    def __str__(self):
        return f"{self.numerator}/{self.denominator}"

""" Here is the test suite for numbers to be tested. """

def test_suite():
    f12 = Fraction(1, 2)
    f44 = Fraction(4, 4)
    f128 = Fraction(12, 8)
    f32 = Fraction(3, 2)
    print(f"{f12} + {f12} = {f12.plus(f12)} [4/4]")
    print(f"{f44} - {f12} = {f44.minus(f12)} [4/8]")
    print(f"{f12} + {f44} = {f12.plus(f44)} [12/8]")
    print(f"{f128} == {f32} is {f128.plus(f32)} [True]")

""" Here is where the user can enter the value for both of the fractions. """

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
    except:
        print("You either entered an invalid character or 0. Remember, you can't divide by 0.")
        return
    if Operation == "+":
        f3 = f1.plus(f2)
        print(f"{f1} + {f2} = {f3}")
    if Operation == "-":
        f3 = f1.minus(f2)
        print(f"{f1} - {f2} = {f3}")
    if Operation == "*":
        f3 = f1.times(f2)
        print(f"{f1} * {f2} = {f3}")
    if Operation == "/":
        f3 = f1.divide(f2)
        print(f"{f1} / {f2} = {f3}")
    elif (Fraction1numerator*Fraction2denominator) == (Fraction1denominator*Fraction2numerator) and Operation == "+":
        print("True")

if __name__ == "__main__":
    main()