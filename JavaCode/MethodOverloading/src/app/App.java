package app;

public class App {
    public static void main(String[] args) throws Exception {
        int feet = 6;
        int inches = -10;
        
        System.out.println(calcFeetAndInchesToCentimeters(feet, inches));
        double test = calcFeetAndInchesToCentimeters(-10);
        System.out.println("This is: " + test + " centimeters.");
        System.out.println(getDurationString(61, 5));
    }
    // All you have to do is create the same method but use different parameters
    // to perform different functions.
    public static double calcFeetAndInchesToCentimeters(int feet, int inches) {
        double value = -1;
        if (feet >= 0) {
            value = (feet * 12) * 2.54;
            if (inches >= 0 && inches <= 12) {
                double totalInches = (feet * 12) + inches;
                value = totalInches * 2.54;

            }
        } 
        return value;
    }
    public static double calcFeetAndInchesToCentimeters(int inches) {
        if (inches <= 0) {
            return -1;
        }

        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        System.out.println("inches is == to: " + feet + " feet and " + remainingInches + " inches");
        return calcFeetAndInchesToCentimeters((int) feet, (int)remainingInches);
    }
// This is a continuation on overloading

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || seconds < 0 && seconds > 59) {
            return "invalid value";
        }
        int totalMins = minutes + (seconds / 60);
        int hours = totalMins / 60;
        totalMins = totalMins % 60;
        int calcSeconds = 0;
        return ("0" + hours + "h " + "0" + totalMins + "m " + "0" + calcSeconds + "s");
       
    


    }
}