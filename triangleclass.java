/*
11.1 (The Triangle class) Design a class named Triangle that
extends GeometricObject . The class contains:
Three double data fields named side1 , side2 , and side3 with
default values 1.0 to denote three sides of a triangle.
A no-arg constructor that creates a default triangle.
A constructor that creates a triangle with the specified side1 ,
side2 , and side3 .
The accessor methods for all three data fields.
A method named getArea() that returns the area of this
triangle.
A method named getPerimeter() that returns the perimeter of
this triangle.
A method named toString() that returns a string description
for the triangle.
For the formula to compute the area of a triangle, see
Programming Exercise 2.19 . The toString() method is
implemented as follows:
return "Triangle: side1 = " + side1 + " side2 = " + side2 +
" side3 = " + side3;
Sections 11.5–11.14
Draw the UML diagrams for the classes Triangle and
GeometricObject and implement the classes. Write a test program
that prompts the user to enter three sides of the triangle, a color,
and a Boolean value to indicate whether the triangle is filled. The
program should create a Triangle object with these sides and set
the color and filled properties using the input. The program
should display the area, perimeter, color, and true or false to
indicate whether it is filled or not

*12.5 ( IllegalTriangleException ) Programming Exercise 11.1
defined the Triangle class with three sides. In a triangle, the sum
of any two sides is greater than the other side. The Triangle class
must adhere to this rule. Create the IllegalTriangleException
class, and modify the constructor of the Triangle class to throw an
IllegalTriangleException object if a triangle is created with sides
that violate the rule, as follows:
/** Construct a triangle with the specified sides 
public Triangle(double side1, double side2, double side3)
throws IllegalTriangleException {
// Implement it
}
*/
import java.util.Scanner;
class Triangle{
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    Triangle(){}
    Triangle(double side1, double side2, double side3) throws exceptionforillegaltriangle{
        if(side1 <=0 || side2 <=0 || side3 <=0) throw new exceptionforillegaltriangle("This input is invalid.");
        if (side1 >= side2 + side3)
            throw new exceptionforillegaltriangle("Side #1 is > Side #2 and Side #3");
        else if (side2 >= side1 + side3)
            throw new exceptionforillegaltriangle("Side #2 is > Side #1 and Side #3");
        else if (side3 >= side2 + side1)
            throw new exceptionforillegaltriangle("Side #3 is > Side #1 and Side #2");

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    double obtainside1() {return this.side1;}
    double obtainside2() {return this.side2;}
    double obtainside3() {return this.side3;}
    double getPerimeter(){
        return this.side1 + this.side2 + this.side3;
    }

    double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * ((p - side1) * (p - side2) * (p - side3)));
    }

    public String toString(){
        return "Side #1 of the triangle = " + this.obtainside1() +
                " | Side #2 of the triangle = " + this.obtainside2() +
                " | Side #3 of the triangle = "+ this.obtainside3();
    }
}

public class triangleclass {
    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program will have a triangle class in which you will be able to have the area, perimeter, and whether it is filled or not. Press 'c' to continue. ");
        String start = input.nextLine();
        if(start.equals("c")){
            Triangle test;
            halfway:

            while (true){
                System.out.println("You will now enter the sides of the triangle. Press 't' to continue.");
                String choose = input.next();
                if(choose.equals(("t"))){
                    while(true){
                        System.out.println("Enter the first side of the triangle: ");
                        double side1 = input.nextDouble();
                        System.out.println("Enter the second side of the triangle: ");
                        double side2 = input.nextDouble();
                        System.out.println("Finally, enter the third side of the triangle: ");
                        double side3 = input.nextDouble();

                        try{
                            test = new Triangle(side1, side2, side3);
                            break halfway;

                        }catch (exceptionforillegaltriangle e){
                            System.out.println(e.getaside());
                            System.out.println("Please re-enter.");
                        }
                    }

                }else System.out.println("Input is invalid. Try again. ");
            }
            System.out.println(test.toString() +
                    "\nThe area of the triangle is: " + test.getArea() +
                    " and the perimeter of the triangle is: " + test.getPerimeter());
        }
    }
}