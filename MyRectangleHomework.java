/* 
*10.13 (Geometry: the MyRectangle2D class) Define the
MyRectangle2D class that contains:
Two double data fields named x and y that specify the center
of the rectangle with getter and setter methods. (Assume the
rectangle sides are parallel to x- or y- axis.)
The data fields width and height with getter and setter
methods.
A no-arg constructor that creates a default rectangle with ( 0 ,
0 ) for ( x , y ) and 1 for both width and height .
A constructor that creates a rectangle with the specified x , y ,
width , and height .
A method getArea() that returns the area of the rectangle.
A method getPerimeter() that returns the perimeter of the
rectangle.
A method contains(double x, double y) that returns true if the
specified point ( x , y ) is inside this rectangle (see Figure
10.24a ).
A method contains(MyRectangle2D r) that returns true if the
specified rectangle is inside this rectangle (see Figure 10.24b
).
A method overlaps(MyRectangle2D r) that returns true if the
specified rectangle overlaps with this rectangle (see Figure
10.24c ).
Figure 10.24
A point is inside the rectangle. (b) A rectangle is inside another
rectangle. (c) A rectangle overlaps another rectangle. (d) Points
are enclosed inside a rectangle.
Draw the UML diagram for the class then implement the class.
Write a test program that creates a MyRectangle2D object r1 ( new
MyRectangle2D (2, 2, 5.5, 4.9) ), displays its area and perimeter,
and displays the result of r1.contains(3, 3) , r1.contains(new
MyRectangle2D(4, 5, 10.5, 3.2)) , and r1.overlaps(new
MyRectangle2D(3, 5, 2.3, 5.4)) .
*/

import java.util.Scanner;
class MyRectangle2D{
    private double x;
    private double y;
    private double width;
    private double height;
    public MyRectangle2D(){
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.height = 1;
    }

    public MyRectangle2D(double x,double y, double widthinfo,double heightinfo) throws Exception {
        if(widthinfo < 0 || heightinfo < 0) throw new Exception();
        this.x = x;
        this.y = y;
        this.width = widthinfo;
        this.height = heightinfo;
    }

    public void partofX(double x){this.x = x;}
    public void partofY(double y){this.y = y;}
    public void partofWidth(double widthinfo) throws Exception {
        if(widthinfo < 0) throw new Exception();
        this.width = widthinfo;
    }
    public void partofHeight(double heightinfo) throws Exception {
        if(heightinfo < 0) throw new Exception();
        this.height = heightinfo;
    }

	public double obtainWidth(){return this.width;}
	public double obtainHeight(){return this.height;}
    public double obtainX(){return this.x;}
    public double obtainY(){return this.y;}
	public double obtainPerimeter(){return 2*(this.width + this.height);}
    public double obtainArea(){return this.height * this.width;}
    public boolean contains(double x, double y){
        if(Math.abs(x - this.x)<=this.width / 2 && Math.abs(y - this.y)<=this.height / 2) return true;
        return false;
    }

    public boolean contains(MyRectangle2D r){
        double bottomX = r.x - r.width/2;
        double bottomY = r.y - r.height/2;
        double aboveX = r.x + r.width/2;
        double aboveY = r.y + r.height/2;
        if(contains(bottomX, bottomY) && contains(aboveX, aboveY)) return true;
        return false;
    }

    public boolean overlaps(MyRectangle2D r){
        double bottomX = r.x - r.width/2;
        double bottomY = r.y - r.height/2;
        double aboveX = r.x + r.width/2;
        double aboveY = r.y + r.height/2;
        if(!contains(r) &&
                (contains(bottomX, bottomY) || contains(bottomX, aboveY)
                        || contains(aboveX, bottomY) || contains(aboveX, aboveY))
        ) return true;
        return false;
    }
}

public class MyRectangleHomework {
    public static void main(String []args) throws Exception {
        Scanner input = new Scanner(System.in);
        while(true){
			System.out.println("This program is to have you enter the parts of a rectangle as well to help identify if the points are in the rectangle. Input 'b' to begin. ");
			String s = input.next();
			
            if(s.equals("b")){
				halfway:
				
                while(true){
                    System.out.println("Enter the base of the rectangle. ");
                    System.out.println("Enter the center point for x: ");
                    double x = input.nextDouble();
                    System.out.println("Enter the center point for y: ");
                    double y = input.nextDouble();
                    System.out.println("Enter the width: ");
                    double w = input.nextDouble();
                    System.out.println("Enter the height: ");
					double h = input.nextDouble();
					
					MyRectangle2D rectangles;
					
                    try{
                         rectangles = new MyRectangle2D(x, y, w, h);
                    }catch (Exception e){
                        System.out.println("Enter a valid input.");
                        break halfway;
                    }
                    while(true){
                        System.out.println("Enter '1' to test a point or '2' to test a rectangle: ");
						String test = input.next();
						
                        if(test.equals("1")){
                            double []testingpoint = new double [2];
                            System.out.println("For testing a point, enter an x value: ");
                            testingpoint[0] = input.nextDouble();
                            System.out.println("For testing a point, enter a y value: ");
                            testingpoint[1] = input.nextDouble();
                            if(rectangles.contains(testingpoint[0], testingpoint[1])) System.out.println("Fortunately, this point provided is in the rectangle.");
							else System.out.println("Unfortunately, this point provided is not in the rectangle.");
							
                        }else if(test.equals("2")){
                            double []testingsiderectangle = new double[4];
                            System.out.println("For testing a rectangle, enter an x value: ");
                            testingsiderectangle[0] = input.nextDouble();
                            System.out.println("For testing a rectangle, enter a y value: ");
                            testingsiderectangle[1] = input.nextDouble();
                            System.out.println("For testing a rectangle, enter the width: ");
                            testingsiderectangle[2] = input.nextDouble();
                            System.out.println("For testing a rectangle, enter the height: ");
							testingsiderectangle[3] = input.nextDouble();
							
                            try{
                                MyRectangle2D testingtherectangle = new MyRectangle2D(testingsiderectangle[0],testingsiderectangle[1],testingsiderectangle[2],testingsiderectangle[3]);
                                if(rectangles.contains(testingtherectangle)) System.out.println("The test rectangle is in the actual rectangle.");
                                else if(rectangles.overlaps(testingtherectangle)) System.out.println("There is an overlap of the test rectangle in the rectangle.");
                                else System.out.println("There is no overlap of the test rectangle in the actual rectangle.");
                            }catch (Exception e) {
								System.out.println("Input entered is invalid.");
								break;
                            }
                        }else System.out.println("Input entered is invalid.");
                        System.out.println("Hit 4 to leave or any key to try out either a point or rectangle.");
                        String i = input.next();
                        if(i.equals("4")) break halfway;
                    }
                }
            }
            System.out.println("Hit x to end the program or any key to start all over again: ");
            s = input.next();
            if(s.equals("x")) break;
        }
    }
}