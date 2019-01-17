// package app;

/* TCSS 143
 * Professor Schuessler
 * Programming1.java
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
     * This method is the main method which assigns the town
     * population variables and calls all the appropiate methods 
     *
     *  @param theArgs
     */
    public static void main(String[] theArgs) {
        Scanner userInput = new Scanner(System.in);
        int town1Population = getPopulation(1, userInput);
        int town2Population = getPopulation(2, userInput);
        int town3Population = getPopulation(3, userInput);
        int town4Population = getPopulation(4, userInput);
        int town5Population = getPopulation(5, userInput);
        
        System.out.println();
        System.out.println("POPULATION GRAPH:");
        drawPopulationBar(1, town1Population);
        drawPopulationBar(2, town2Population);
        drawPopulationBar(3, town3Population);
        drawPopulationBar(4, town4Population);
        drawPopulationBar(5, town5Population);
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