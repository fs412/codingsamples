import java.util.Scanner;
public class rectangleTest{
    private class therectangle {
        private double width = 1;
        private double height = 1;
        private therectangle() {
        }
        private therectangle(double width, double height) throws Exception {
            if (width < 0 || height < 0) throw new Exception();
            this.width = width;
            this.height = height;
        }
        private double thearea() {
            return width * height;
        }
        private double theperimeter() {
            return (width + height) * 2;
        }
    }
    public static void main(String[]args){
        rectangleTest test = new rectangleTest();
        Scanner input = new Scanner(System.in);
        System.out.println("This program will provide you with the area and perimeter of a rectangle. Type 'OK' to begin.");
        String s = input.next();
        if(s.equals("OK")){
            therectangle recordeddata;
            while(true){
                System.out.println("Input the width of the rectangle: ");
                double width = input.nextDouble();
                System.out.println("Input the height of the rectangle: ");
                double height = input.nextDouble();
                try{
                    recordeddata = test.new therectangle(width, height);
                    break;
                }catch (Exception e){
                    System.out.println("Error, please enter a valid input. ");
                }
            }
            System.out.println("Area of the rectangle: "+ recordeddata.thearea());
            System.out.println("Perimeter of the rectangle is: "+ recordeddata.theperimeter());
        }
    }
}