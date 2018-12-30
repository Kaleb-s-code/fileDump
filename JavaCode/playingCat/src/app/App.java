package app;

public class App {
    public static void main(String[] args) throws Exception {
        boolean summer = false;
        int temperature = 35;
        System.out.println(isCatPlaying(summer, temperature));
    }
    public static boolean isCatPlaying(boolean summer, int temperature) {
        boolean someVar = false;
        
        if (summer == false) {
            if ((temperature >= 25) && (temperature <= 35)) {
                someVar = true;
            }
        }
        if (summer == true) {
            if ((temperature >= 25) && (temperature <= 45)) {
                someVar = true;
            }
        }
        return someVar;
    }
}