package app;

public class App {
    public static void main(String[] args) throws Exception {
        double num1 = 3.1235;
        double num2 = 3.1234;
        
        System.out.println(areEqualByThreeDecimalPlaces(num1, num2));
    }
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        boolean value = false;
        double val = num1 * 1000;
        double val2 = num2 * 1000;
        if ((int) val == (int) val2) {
            value = true;
        }
        return value;
    }
}