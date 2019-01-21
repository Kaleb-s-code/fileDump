package app;

/* TCSS 143
 * Professor Schuessler
 * Programming1.java
 * 01/22/2019
 */
import java.util.Scanner;
import FileNotFoundException;
 /**
  * This program accepts user input for the population of a town
  * then converts that population to a chart of stars 
  * each representing 1000 people 
  * 
  * @author Kaleb Moreno (kalebm2@uw.edu)
  * @version 01/13/2019
  */
public class App {
     /**
     * This method is the main method which assigns the town
     * population variables and calls all the appropiate methods 
     *
     *  @param theArgs
     */
    public static void main(String[] theArgs) {
        Scanner input = null;
        PrintStream output = null;
        String inFileName = "in2a.txt";
        String outFileName = "out.txt";
        boolean filesOk = false;

        try {
            input = new Scanner(new File(inFileName));
            output = new PrintStream(new File(outFileName));
            filesOk = true;
        }
        catch (FileNotFoundException e) {
            System.out.println("can't open the file - " + e);
        }
        if (filesOk) {
            // This is where everythinf should go for processing stuff
        }
    }
    /**
     * This method accepts the town number and then prompts user for population
     * then returns the population entered
     * 
     * @param theTownNumber This is the town number
     * @param theUserInput this is the population that the user input
     * @return This method returns the entered population value
     */
    public static int getPopulation(int theTownNumber, Scanner theUserInput) {
        int townPop = 0;
        
        System.out.print("Enter the population for town " + theTownNumber + ":");
        townPop = theUserInput.nextInt();

        return townPop;
    }
    /**
     * This method accepts the town number and uses it to display the 
     * correct town. Then the method displays a graph where each star
     * represents 1000 residents.
     * 
     * @param theTownNum This is the town number
     * @param theTownPop This is the town's population
     */
    public static void drawPopulationBar(int theTownNum, int theTownPop) {
        String stars = "";
        while (theTownPop >= 1000) {
            theTownPop -= 1000;
            stars += "*";
        }
        System.out.println("Town " + theTownNum + ": " + stars);
    }
}