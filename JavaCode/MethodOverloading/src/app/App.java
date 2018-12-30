package app;
// This covers method overloading, and constants 
public class App {
    // This is a constant, always typed in UPPER_CASE!! 
    private static final String INVALID_VALUE_MESAGE = "Invalid value";
    
    public static void main(String[] args) throws Exception {
        int feet = 6;
        int inches = -10;
        
        System.out.println(calcFeetAndInchesToCentimeters(feet, inches));
        double test = calcFeetAndInchesToCentimeters(-10);
        System.out.println("This is: " + test + " centimeters.");
        System.out.println(getDurationString(65, 9));
        System.out.println(getDurationString(3945));
        System.out.println(getDurationString(-41));
    }
    // All you have to do is create the same method but use different parameters to perform different functions.
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

    private static String getDurationString(int minutes, int seconds) {
        if ((minutes < 0) || (seconds < 0) || (seconds > 59)) {
            return (INVALID_VALUE_MESAGE);
        }
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        
        // This is an alternative way to get the the leading zero format...You could use the join method to accomplish this.
        
        String hoursString = hours + "h";
        if (hours < 10) {
            hoursString = "0" + hoursString;
        }
        String minutesString = remainingMinutes + "m";
        if (remainingMinutes < 10) {
            minutesString = "0" + minutesString;
        }
        String secondString =  seconds + "s";
        if (seconds < 10) {
            secondString = "0" + secondString;
        }
        // ***********************************
        
        return (hoursString + " " + minutesString + " " + secondString);
    }
    private static String getDurationString(int seconds) {
        if (seconds < 0) {
            return(INVALID_VALUE_MESAGE);
        }
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return (getDurationString(minutes, remainingSeconds));
    }

}