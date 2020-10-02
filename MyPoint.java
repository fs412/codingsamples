/*
10.4 (The MyPoint class) Design a class named MyPoint to
represent a point with x - and y -coordinates. The class contains:
The data fields x and y that represent the coordinates with
getter methods.
A no-arg constructor that creates a point ( 0 , 0 ).
A constructor that constructs a point with specified coordinates.
A method named distance that returns the distance from this
point to a specified point of the MyPoint type.
A method named distance that returns the distance from this
point to another point with specified x - and y -coordinates.
A static method named distance that returns the distance from
two MyPoint objects.
Draw the UML diagram for the class then implement the class.
Write a test program that creates the two points ( 0 , 0 ) and ( 10 ,
30.5 ) and displays the distance between them.
*/

public class MyPoint {
	private double x;
	private double y;
	
	public MyPoint(){
		this(0,0);
	}
	
	public MyPoint(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public double distance(double x, double y){
		return Math.sqrt(Math.pow(x - this.x,2) + Math.pow(y - this.y,2));
	}
	
	public double distance(MyPoint point){
		return distance(point.getX(), point.getY());
	}
	
	public String toString() {
		return "(x, y) = (" + x + ", " + y + ")";
	}
	public static void main(String[] args) {
		MyPoint firstpoint = new MyPoint();
		MyPoint secondpoint = new MyPoint(10.0, 30.5);
		System.out.println("First point " + firstpoint);
		System.out.println("Second point " + secondpoint);
		System.out.printf("The distance between the first point and the second point is %.2f.", firstpoint.distance(secondpoint));
	}
}