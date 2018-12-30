package app;

public class App {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        int num3 = 3;
        printEqual(num1, num2, num3);
    }
    public static void printEqual(int num1, int num2, int num3) {
        String someVar = "Neither all equal or different";
        if ((num1 >= 0) || (num2 >= 0) || (num3 >= 0)) {
            if ((num1 == num2) && (num1 == num3)) {
                someVar = "All numbers are equal";
            }
            if ((num1 != num2) && (num1 != num3) && (num2 != num3)) {
                someVar = "All numbers are different";
            }
        }
        if ((num1 < 0) || (num2 < 0) || (num3 < 0)) {
            someVar = "Invalid Value";
        }
        System.out.println(someVar);
    }
}