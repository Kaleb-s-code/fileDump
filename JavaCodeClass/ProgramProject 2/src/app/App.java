package app;

/* TCSS 143
 * Professor Schuessler
 * Programming1.java
 * 01/22/2019
 */
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;



 /**
  * This program reads from an input file and prints
  * to an output file the various arrays in the proper orders.  
  * In addition to that, two arrays are added, two are 
  * subtracted, and two are multiplied in the output file.
  *
  * @author Kaleb Moreno (kalebm2@uw.edu)
  * @version 01/21/2019
  */
public class App {
     /**
     * This method is the main method which creates a scanner,
     * a printstream and utilizes a try catch block.
     * After the files are opened, the two main methods are called
     * getDimensions and doTheMath.
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
            int[][] listOfArrays = getDimensions(input, output);
            doTheMath(listOfArrays, output);
            }
        }
    /**
     * This method does three main things: 
     * 1.) This method finds the dimensions of the matricies and 
     *     puts them in a two dimensional array for reference
     * 2.) This method then assigns the numbers from the 
     *     matricies into two dimensional arrays. 
     * 3.) This method then makes a call to the method 
     *     displayToOutput for each array, so that 
     *     they can be printed to the out file in the proper order. 
     * 
     * @param theInput This is the Scanner input file object.
     * 
     * @param theOutput This is the file I write to via Printstream. 
     * 
     * @return This method returns an array of all the numbers
     *         from the matricies appropriately split into their
     *         cooresponding arrays. 
     */
        public static int[][] getDimensions(Scanner theInput, PrintStream theOutput) {
        int dimensionArray[][];
        int allTheArrays[][];
        int coluOne = 0;
        int coluTwo = 1;
        int idx = 0;
        allTheArrays = new int[4][10];
        dimensionArray = new int[4][2];
        while(theInput.hasNext()) {
            int a = theInput.nextInt();
            int b = theInput.nextInt();
            int num = 0;
            while (num < (a * b) && theInput.hasNext()) {   
                allTheArrays[idx][num] = theInput.nextInt();
                num ++;
            }
            dimensionArray[idx][coluOne] = a;
            dimensionArray[idx][coluTwo] = b;
            idx ++;
        }
        // Array one
        int arrayOne [][];
        int a = 0;
        int b = 0;
        int c = 0;
        arrayOne = new int[dimensionArray[0][0]][dimensionArray[0][1]];
        while (c < dimensionArray[0][0] * dimensionArray[0][1]) {
            arrayOne[a][b] = allTheArrays[0][c];
            if (c == 1) {
                a ++;
            }
            if (b == 1) {
                b = 0;
            } else {
                b ++;
            }
            c ++; 
        }
        displayToOutput(0, arrayOne, theOutput);
        
        //  Array two
        int arrayTwo [][];
        a = 0;
        b = 0;
        c = 0;
        arrayTwo = new int[dimensionArray[1][0]][dimensionArray[1][1]];
        
        while (c < dimensionArray[1][0] * dimensionArray[1][1]) {
            arrayTwo[a][b] = allTheArrays[1][c];
            if (c == 1) {
                a ++;
            }
            if (b == 1) {
                b = 0;
            } else {
                b ++;
            }
            c ++;
        }
        displayToOutput(1, arrayTwo, theOutput);
        a = 0;
        b = 0;
        c = 0;

        //  Array three
        int arrayThree [][];
        arrayThree = new int[dimensionArray[2][0]][dimensionArray[2][1]];
        while (c < dimensionArray[2][0] * dimensionArray[2][1]) {
            arrayThree[a][b] = allTheArrays[2][c];
            if (c % 2 == 0) {
                if (c < 1) {
                    a = 0;
                }
            } else {
                a ++;
            }
            if (b == 1) {
                b = 0;
            } else {
                b ++;
            }
            c ++;
        }
        displayToOutput(2, arrayThree, theOutput);
        a = 0;
        b = 0;
        c = 0;

        // Array four
        int arrayFour [][];
        arrayFour = new int[dimensionArray[3][0]][dimensionArray[3][1]];
        while (c < dimensionArray[3][0] * dimensionArray[3][1]) {
            arrayFour[a][b] = allTheArrays[3][c];
            if (c == 4) {
                a ++;
            }
            if (b == 4) {
                b = 0;
            } else {
                b ++;
            }
            c ++;
        }
        displayToOutput(3, arrayFour, theOutput);
        return allTheArrays;
    }
    /**
     * The function of this method is three fold:
     * 1.) This method adds Arrays A and B together 
     *     then sends the numbers to displayToOutput.
     * 2.) Next, this method subtracts arrays A and B
     *     then sends the numbers to displayToOutput.
     * 3.) Finally, this method multiplies arrays C & D
     *     and repeats the sending.  
     * 
     * @param theList This argument is the same array returned from 
     *                the getDimensions method. It is an array of
     *                all the array data from the input file.
     * 
     * @param theOut  This is the out file that is being passed 
     *                along to the displayToOutput method calls
     *                within this method. 
     */
    public static void doTheMath(int[][] theList, PrintStream theOut) {

        int[][] additionArray;
        int[][] subtractionArray;
        int[][] multipArray;

        additionArray = new int[2][2];
        subtractionArray = new int[2][2];
        multipArray = new int[5][5];
        for (int i = 0; i < theList[0].length; i++) {
            additionArray[0][0] = theList[0][0] + theList[1][0];
            additionArray[0][1] = theList[0][1] + theList[1][1];
            additionArray[1][0] = theList[0][2] + theList[1][2];
            additionArray[1][1] = theList[0][3] + theList[1][3];
        }
        displayToOutput(4, additionArray, theOut);

        for (int i = 0; i < theList[0].length; i++) {
            subtractionArray[0][0] = theList[0][0] - theList[1][0];
            subtractionArray[0][1] = theList[0][1] - theList[1][1];
            subtractionArray[1][0] = theList[0][2] - theList[1][2];
            subtractionArray[1][1] = theList[0][3] - theList[1][3];
        }
        displayToOutput(5, subtractionArray, theOut);
       int s = 0;
       int x = 1;
        while (s < 5) {
            multipArray[s][0] = (theList[2][s * 2] * theList[3][0]) + (theList[2][x] * theList[3][5]);
            multipArray[s][1] = (theList[2][s * 2] * theList[3][1]) + (theList[2][x] * theList[3][6]);
            multipArray[s][2] = (theList[2][s * 2] * theList[3][2]) + (theList[2][x] * theList[3][7]);
            multipArray[s][3] = (theList[2][s * 2] * theList[3][3]) + (theList[2][x] * theList[3][8]);
            multipArray[s][4] = (theList[2][s * 2] * theList[3][4]) + (theList[2][x] * theList[3][9]);
            s++;
            x += 2;
        }
        displayToOutput(6, multipArray, theOut);
       
    }
    /**
     * This method is where I do all the actual sending of the 
     * array data to the output file for display. 
     * 
     * @param tellNum This argument is what I used to 
     *                identify which array I was working with 
     *                to avoid mistakes. 
     * @param theArray This argument is a placeholder for 
     *                 whatever array is sent to this method 
     *                 for processing.
     * @param theOut This is the output file object passed along 
     *               from main. 
     */
    public static void displayToOutput(int tellNum, int[][]theArray, PrintStream theOut) {
        String writeItem = "";
        
        if ((tellNum < 2) || (tellNum > 3)) {
            if (tellNum == 0) {
                writeItem = "Array A:";
            } else if (tellNum == 1) {
                writeItem = "Array B:";
            } else if (tellNum == 4) {
            writeItem = "A + B =";
            } else if (tellNum == 5) {
            writeItem = "A - B =";
            } else {
            writeItem = "C X D =";
            }
            theOut.println(writeItem);
            for (int i = 0; i < theArray.length; i++) {
                for (int j = 0; j < theArray.length; j++) {
                    theOut.printf("  %d", theArray[i][j]);
                }
                theOut.println();
            }
            theOut.println();

        } else if (tellNum == 2 || tellNum == 3){
            if (tellNum == 2) {
                writeItem = "Array C:"; 
            } else if (tellNum == 3)
                writeItem = "Array D:";
            theOut.println(writeItem);
            for (int x = 0; x < theArray.length; x++) {
                for (int y = 0; y < theArray[0].length; y++) {
                    theOut.printf(" \t%d", theArray[x][y]);
                }
                theOut.println();
            }
            theOut.println();
        }
    }   
            
}