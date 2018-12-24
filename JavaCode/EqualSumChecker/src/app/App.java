package app;


public class App {
    public static void main(String[] args) throws Exception {
        int val1 = 1;
        int val2 = -1;
        int val3 = 0;
        System.out.println(hasEqualSum(val1, val2, val3));
    }
    public static boolean hasEqualSum(int val1, int val2, int val3) {
        boolean result = false;

        if (val1 + val2 == val3) {
            result = true;
        }
        return result;
    }
}