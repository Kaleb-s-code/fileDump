package app;

public class App {
    public static void main(String[] args) {
 
        long minutes = 561600;
        printYearsAndDays(minutes);
    }
    public static void printYearsAndDays(long minutes) {
        if (minutes >= 0) {
            
            long hours = 0;
            long days = 0;
            long years = 0;
            String origMinutes = minutes + " min = ";
            
            if (minutes >= 60) {
                hours = minutes / 60;
                
                if (hours >= 24) {
                    days = hours / 24;

                    if (days >= 365) {
                        years = days / 365;
                        days = days % 365;
                        
                    }

                }
            }
            System.out.println(origMinutes + years + " y and " + days + " d");
        }
        if (minutes < 0) {
            System.out.println("Invalid Value");
        }
    }
}