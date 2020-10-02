/* 9.1 (The Rectangle class) Following the example of the Circle
class in Section 9.2 , design a class named Rectangle to
represent a rectangle. The class contains:
Two double data fields named width and height that specify
the width and height of the rectangle. The default values are 1
for both width and height .
A no-arg constructor that creates a default rectangle.
A constructor that creates a rectangle with the specified width
and height .
A method named getArea() that returns the area of this
rectangle.
A method named getPerimeter() that returns the perimeter.
Draw the UML diagram for the class then implement the class.
Write a test program that creates two Rectangle objects—one with
width 4 and height 40 , and the other with width 3.5 and height
35.9 . Display the width, height, area, and perimeter of each
rectangle in this order 
*/

import java.util.Scanner;
public class therectangle {
    private double height = 1;
    private double width = 1;
    private therectangle(){}
    private therectangle(double width, double height) throws Exception {
        if(width < 0 || height < 0) throw new Exception();
        this.height = height;
        this.width = width;

    }
    private double getArea(){
        return width * height;

    }
    private double getPerimeter(){
        return (width + height) * 2;

    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("This script is made to calculate the perimeter and area of a rectangle. Type 'yes' to continue or 'no' to quit. ");
        String intro = input.next();

        if(intro.equals("yes")){
            therectangle response;
            while(true){
                System.out.println("Please enter the width of the rectangle: ");
                double width = input.nextDouble();
                System.out.println("Please enter the height of the rectangle: ");
                double height = input.nextDouble();
                try{
                    response = new therectangle(width, height);
                    break;
                }catch (Exception e){
                    System.out.println("Error, please enter a valid input. ");
                }
            }

            while(true){
                System.out.println("Enter 'area' to obtain the area or 'perimeter' to obtain the perimeter. ");
                String solution = input.next();
                if(solution.equals("area")) System.out.println("The area of the rectangle is " + response.getArea());
                else if(solution.equals("perimeter")) System.out.println("The perimeter of the rectangle is " + response.getPerimeter());
                else System.out.println("Error, please enter a valid input. ");
            }
        }
    }
}