package pack;

/* TCSS 143
 * Professor Schuessler
 * Programming2.java
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
  * @version 01/23/2019 (LATE)
  */
public class Assign_2 {
/**
 * This is where all the classes and methods are called, and 
 * the input / output files are created. 
 *
 *  @param theArgs
 */
    public static void main(String[] theArgs) {
        ArrayMath mathObject = new ArrayMath();
        Scanner input = null;
        PrintStream output = null;
        String inFileName = "in2b.txt";
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
            
            int [][] arrayA = findAllTheArrays(input);
            int [][] arrayB = findAllTheArrays(input);
            int [][] arrayC = findAllTheArrays(input);
            int [][] arrayD = findAllTheArrays(input);
            
            displayToOutput(0, arrayA, output);
            displayToOutput(1, arrayB, output);
            displayToOutput(2, arrayC, output);
            
            displayToOutput(4, mathObject.add(arrayA, arrayB), output);
            displayToOutput(5, mathObject.subtract(arrayA, arrayB), output);
            displayToOutput(6, mathObject.mult(arrayC, arrayD), output);
            
            input.close();
            output.close();
            }
        }
        /**
         * This method accepts the input object and creates arrays out 
         * of the file data. This then returns that carray compilation
         * @param theInput This is the input file object
         * @return This is the array compilation from the file
         */
    public static int[][] findAllTheArrays(Scanner theInput) {
        int rowsize = theInput.nextInt();
        int colSize = theInput.nextInt();
        int[][] a = new int[rowsize][colSize];

        for (int i = 0; i < a.length; i ++) {
            for (int j = 0; j < a[i].length && theInput.hasNextInt(); j ++) {
                a[i][j] = theInput.nextInt();
            }
        }
        return a;
    }
    /**
     * This method displayes all of the arrays and 
     * appropriate math results to the output file
     * @param tellNum This is a number I used to determine
     * which of the arrays I was dealing with
     * @param theArray This is a place holder array for whichever 
     * array is passed to this parameter
     * @param theOut This is the output file object that was passed  
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
                for (int j = 0; j < theArray[0].length; j++) {
                    theOut.printf("\t%5s", theArray[i][j]);
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
                    theOut.printf("\t%5s", theArray[x][y]);
                }
                theOut.println();
            }
            theOut.println();
        }
    } 
            
}