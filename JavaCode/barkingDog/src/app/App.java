package app;

public class App {

    public static void main(String[] args) {
        boolean barking = true;
        int hourOfDay = 1;
        System.out.println(bark(barking, hourOfDay));
    }
    
    public static boolean bark(boolean barking, int hourOfDay) {
        boolean wakeUp = false;
        if (hourOfDay >= 0 && hourOfDay <= 23) {
            if (barking == true) {
                if (hourOfDay < 8 || hourOfDay > 22) {
                    wakeUp = true;
                }
            }
        }
        return wakeUp;
        }
    }