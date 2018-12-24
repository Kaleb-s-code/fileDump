package app;

public class App {
    public static void main(String[] args) throws Exception {
        int num1 = 22;
        int num2 = 23;
        int num3 = 34;
        System.out.println(hasTeen(num1, num2, num3));
    }
    public static boolean hasTeen(int num1, int num2, int num3) {
        boolean value = false;
        
        if (num1 >= 13 && num1 <= 19 || num2 >= 13 && num2 <= 19 || num3 >= 13 && num3 <= 19) {
            value = true;
        }
        return value;
    }
}
