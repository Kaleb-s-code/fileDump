package app;
public class App {

    public static void main(String[] args) {
        Test classObject = new Test();
        classObject.stuff();
        double radius = 5.0;
        double side_x = 5.0;
        double side_y = 4.0;
        System.out.println(area(radius));
        System.out.println(area(side_x, side_y));
    }
    public static double area(double radius) {
        if (radius < 0) {
            return -1;
        }
        double numbers = Math.pow(radius, 2) * Math.PI;
        return numbers;
    }
    public static double area(double x, double y) {
        if ((x < 0) || (y < 0)) {
            return -1;
        }
        double numbers = x * y;
        return numbers;
    }
}