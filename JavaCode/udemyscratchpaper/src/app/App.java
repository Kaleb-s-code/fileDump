package app;

public class App {

    public static void main(String[] args) {
        boolean barking = true;
        int hourOfDay = 10;
        System.out.println(bark(barking, hourOfDay));
    }
    public static boolean bark(boolean barking, int hourOfDay) {
        boolean value = false;
        if (hourOfDay >= 0 && hourOfDay <= 23) {
            if (barking == true) {
                value = true;
            }
        }
        return value;
        }
    }