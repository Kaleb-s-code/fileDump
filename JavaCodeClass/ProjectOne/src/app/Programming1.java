package app;

/* TCSS 143
 * Professor Schuessler
 * Programming assignment 1
 * 01/15/2019
 */
import java.util.Scanner;
 /**
  * This program accepts user input for the population of a town
  * then converts that population to a chart of stars 
  * each representing 1000 people 
  * 
  * @author Kaleb Moreno (kalebm2@uw.edu)
  * @version 01/13/2019
  */
public class Programming1 {
    /**
     * This method is the main method which gets user input for the towns
     * and sends all the data to the getPopulation() method for 
     * further processing
     * 
     * @param theArgs
     */
    public static void main(String[] theArgs) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter population of town 1: ");
        int town1 = scanner.nextInt();

        System.out.print("Enter population of town 2: ");
        int town2 = scanner.nextInt();

        System.out.print("Enter population of town 3: ");
        int town3 = scanner.nextInt();

        System.out.print("Enter population of town 4: ");
        int town4 = scanner.nextInt();

        System.out.print("Enter population of town 5: ");
        int town5 = scanner.nextInt();
        
        getPopulation(town1, town2, town3, town4, town5);
    } 
    /**
     * The purpose of this method is to get the population
     * and send it to the breakItUp() method to figure
     * out how many stars should be printed
     * 
     * @param theT1
     * This holds the value input by the user in town1
     * @param theT2
     * This holds the value input by the user in town2
     * @param theT3
     * This holds the value input by the user in town3
     * @param theT4
     * This holds the value input by the user in town4
     * @param theT5
     * This holds the value input by the user in town5
     */
    public static void getPopulation(int theT1, int theT2, int theT3, int theT4, int theT5) {
        if (theT1 >= 1000) {
            theT1 = breakItUp(theT1);
        }
        if (theT2 >= 1000) {
            theT2 = breakItUp(theT2);
        }
        if (theT3 >= 1000) {
            theT3 = breakItUp(theT3);
        }
        if (theT4 >= 1000) {
            theT4 = breakItUp(theT4);
        }
        if (theT5 >= 1000) {
            theT5 = breakItUp(theT5);
        }
        drawPopulationBar(theT1, theT2, theT3, theT4, theT5); 
    }
    /**
     * The purpose of this method is to determine the amount of
     * stars that should be printed to the console for each town
     * 
     * @param theNumber
     * This parameter holds population value for a passed town
     * @return
     * This method returns the number of times a number can be reduced by 1000
     */
    public static int breakItUp(int theNumber) {
        int i = 0;
        while (theNumber >= 1000) {
            theNumber -= 1000;
            i ++;
        }
        return (i);
    }
    /**
     * This method handles the actual display of the towns and stars
     * 
     * @param theT1
     * This holds the number of stars to be drawn for town1
     * @param theT2
     * This holds the number of stars to be drawn for town2
     * @param theT3
     * This holds the number of stars to be drawn for town3
     * @param theT4
     * This holds the number of stars to be drawn for town4
     * @param theT5
     * This holds the number of stars to be drawn for town5
     */
    public static void drawPopulationBar(int theT1, int theT2, int theT3, int theT4, int theT5) {  
        String stars1 = "";
        for (int i = 0; i < theT1; i++) {
            stars1 += "*";
        }
        // This is the header of the output table 
        System.out.println();
        System.out.println("POPULATION GRAPH:");
        System.out.println("Town 1:" + stars1);
        
        String stars2 = "";
        for (int i = 0; i < theT2; i++) {
            stars2 += "*";
        }
        System.out.println("Town 2:" + stars2);
        String stars3 = "";
        for (int i = 0; i < theT3; i++) {
            stars3 += "*";
        }
        System.out.println("Town 3:" + stars3);
        String stars4 = "";
        for (int i = 0; i < theT4; i++) {
            stars4 += "*";
        }
        System.out.println("Town 4:" + stars4);
        String stars5 = "";
        for (int i = 0; i < theT5; i++) {
            stars5 += "*";
        }
        System.out.println("Town 5:" + stars5);
    }
}
