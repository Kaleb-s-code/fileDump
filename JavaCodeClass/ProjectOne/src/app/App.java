package app;
import java.util.Scanner;

public class App {
    public static void main(String[] theArgs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter population of town 1: ");
        int town1 = scanner.nextInt();

        System.out.println("Enter population of town 2: ");
        int town2 = scanner.nextInt();

        System.out.println("Enter population of town 3: ");
        int town3 = scanner.nextInt();

        System.out.println("Enter population of town 4: ");
        int town4 = scanner.nextInt();

        System.out.println("Enter population of town 5: ");
        int town5 = scanner.nextInt();
        
        getPopulation(town1, town2, town3, town4, town5);
    }   
    public static void getPopulation(int theT1, int theT2, int theT3, int theT4, int theT5) {
    // Get the population here
        int i = 0; 
        while (theT1 >= 1000) {
               theT1 /= 1000;
               i++;
            }
        i = 0;
        while (theT2 >= 1000) {
                theT2 /= 1000;
                i++;
            }
        i = 0;
        while (theT3 >= 1000) {
            theT3 /= 1000;
            i++;
            }
        i = 0;
        while (theT4 >= 1000) {
            theT4 /= 1000;
            i++;
            }
        i = 0;
        while (theT5 >= 1000) {
            theT5 /= 1000;
            i++;
            }
        i = 0;
        
            System.out.println("This is theT1: " + theT1);
            System.out.println("This is i: " + i);
        // int pT1 = theT1 % 1000;
        // int pT2 = theT2 % 1000;
        // int pT3 = theT3 % 1000;
        // int pT4 = theT4 % 1000;
        // int pT5 = theT5 % 1000;
        
        // System.out.println();
        // System.out.println(pT1);
        // System.out.println(pT2);
        // System.out.println(pT3);
        // System.out.println(pT4);
        // System.out.println(pT5);
    }
    // public static void drawPopulationBar(int /*specific town population*/) {
        
    // }
}
