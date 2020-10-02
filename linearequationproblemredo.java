/* *9.11 (Algebra: linear equations) Design a class named
ax2+bx+c=0
b2−4ac.
r1= −b+b2−4ac2a and r2= −b−b2−4ac2a
2×2
LinearEquation for a system of linear equations:
The class contains:
Private data fields a , b , c , d , e , and f .
A constructor with the arguments for a , b , c , d , e , and f .
Six getter methods for a , b , c , d , e , and f .
A method named isSolvable() that returns true if is not
0.
Methods getX() and getY() that return the solution for the
equation.
Draw the UML diagram for the class then implement the class.
Write a test program that prompts the user to enter a , b , c , d , e ,
and f and displays the result. If is 0, report that “The
equation has no solution.” See Programming Exercise 3.3 for
sample runs.
**9.12 (Geometry: intersecting point) Suppose two line segments
intersect. The two endpoints for the first line segment are ( x1 , y1 )
and ( x2 , y2 ) and for the second line segment are ( x3 , y3 ) and
( x4 , y4 ). Write a program that prompts the user to enter these four
endpoints and displays the intersecting point. As discussed in
Programming Exercise 3.25 , the intersecting point can be
found by solving a linear equation. Use the LinearEquation class in
Programming Exercise 9.11 to solve this equation. See
Programming Exercise 3.25 for sample runs
*/

import java.util.Scanner;
public class linearequationproblemredo {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    public linearequationproblemredo(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    public double getA(){
        return this.a;
    }
    public double getB(){
        return this.b;
    }
    public double getC(){
        return this.c;
    }
    public double getD(){
        return this.d;
    }
    public double getE(){
        return this.e;
    }
    public double getF(){
        return this.f;
    }
    public boolean isSolvable(){
        if(this.a * this.d - this.b * this.c == 0) return false;
        return true;
    }
    public double getX(){
        if(isSolvable()) return ((e * d) - (b * f))/((a * d) - (b * c));
        return -1;
    }
    public double getY(){
        if(isSolvable()) return ((a * f) - (e * c))/((a * d) - (b * c));
        return -1;
    }

    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a, b, c, d, e, f one at a time starting with a. ");
        double []in = new double[6];
        for(int l = 0; l < 6; l++){
            in[l] = input.nextDouble();
        }
        linearequationproblemredo test = new linearequationproblemredo(in[0], in[1], in[2], in[3], in[4], in[5]);
        while(true){

            System.out.println("Type in a-f to show what you have entered OR 'progress' to progress with the script.");
            String t = input.next();

            if(t.equals("progress")) break;
            else if(t.equals("a")) System.out.println(test.getA());
            else if(t.equals("b")) System.out.println(test.getB());
            else if(t.equals("c")) System.out.println(test.getC());
            else if(t.equals("d")) System.out.println(test.getD());
            else if(t.equals("e")) System.out.println(test.getE());
            else if(t.equals("f")) System.out.println(test.getF());
            else System.out.println("Error, please enter a valid input. ");
        }

        while(true){
            System.out.println("To show the output of either x or y, enter 'x' or 'y' or type 'quit' to end the script.");
            String output = input.next();
            if(output.equals("quit")) break;

            try{
                if(!test.isSolvable()) throw new Exception();
                if(output.equals("x")) System.out.println(test.getX());
                else if(output.equals("y")) System.out.println(test.getY());
                else System.out.println("Error, please enter a valid input. ");
            }catch (Exception e){
                System.out.println("The equation has no solution.");
                break;
            }
        }
    }
}