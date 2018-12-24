package app;

public class App {
    public static void main(String[] args) throws Exception {
        int year = -2000;
        System.out.println(isLeapYear(year));
        System.out.println("4 test: " + year % 4);
        System.out.println("400 test: " + year % 400);
        System.out.println("100 test: " + year % 100);
    }
    public static boolean isLeapYear(int year) {
        boolean isYear = false;
        if (year >= 1 && year <= 9999) {
            if (year % 4 == 0 && year % 100 != 0) {
                isYear = true;
            }
            if (year % 100 == 0 && year % 400 == 0) {
                isYear = true;
            }
        }
        return isYear;
    }
}
// 1800 {false}, 1924{true}