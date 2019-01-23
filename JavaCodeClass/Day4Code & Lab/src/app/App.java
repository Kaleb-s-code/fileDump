package app;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

// Used "ArraysDemo" for class name
// TO BE CONTINUED 
public class App {
    public static void main(String[] theArgs) {
        // This is the code for the array example
        Scanner input = null;
        PrintStream output = null;
        int [][] a1;
        int [][] a2;
        int [][] a3;
        int [][] a4;
        int [][] a5;
        int [][] arraySum;
        // This wont work until you get the input file
        try {
            input = new Scanner(new File("arrays.txt"));
            output = new PrintStream(new File("output.txt"));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        a1 = getArray(input);
        a2 = getArray(input);
        a3 = getArray(input);
        a4 = getArray(input);
        a5 = getArray(input);

        // output.println("Arrays 1 and 2 are the same size: " + CheckArrays.sameDimensions(a1, a2));

        // if (CheckArrays.sameDimensions(a1, a2)) {
        //     output.println("Arrays 1 & 2 are equal in contantents: " + CheckArrays.areEqual(a1, a2));
        // }
        // boolean sameSize = CheckArrays.sameDimensions(a1, a3);
        // output.println("Arrays 1 & 3 the same size: " + sameSize);

        // if (sameSize) {
        //     output.println("Arrays 1 & 3 are equal in contents: " + CheckArrays.areEqual(a1, a3));
        // }
        // sameSize = CheckArrays.sameDimensions(a4, a5);
        // output.println("Arrays 4 & 5 the same size: " + sameSize);

        // if (sameSize) {
        //     output.println("Arrays 4 & 5 are equal in contents: " + CheckArrays.areEqual(a4, a5));
        // }
        writeArray(a4, 4, output);
        // displayArraySum(4, CheckArrays.sum(a4), output);
        
        input.close();
        output.close();

        public static void displayArraySum(int theNum, int theSum, Printstream theOut) {
            theOut.printf("The sum of array%d = %d\n", theNum, theSum);
        }

        public static void writeArray(int[][] theA, int theNum, PrintStream theOut) {
            theOut.printf("Contents of array%d:\n", theNum);

            for (int r = 0; r < theA.length; r++) {
                for (int c = 0; c < theA[r].length; c++) {
                    theOut.print(String.format("%5d", theA[r][c]));
                }
                theOut.println();
            }
        }
        public static int[][] getArray(Scanner theIn) {
            int[][] a = new int[theIn.nextInt()][theIn.nextInt()];
            
            for (int r = 0; r < a.length; r++) {
                for (int c = 0; c < a[r].length; c++) {
                    a[r][c] = theIn.nextInt();
                }
                return a;
            }
        
        }
        // There was another class that was used..

        public class CheckArrays {
            public static boolean sameDimensions(int[][] theA, int[][]theB) {
                return theA.length == theB.length && theA[0].length == theB[0].length;
            }
            public static boolean areEqual(int[][]theA, int[][]theB) {
                boolean result = sameDimensions(theA, theB);
                for (int row = 0; row < theA.length && result; row ++) {
                    for (int col = 0; col < theA[row] && result; col ++) {
                        result = theA[row][col] == theB[row][col];
                    }
                }
            return result;
            }
        }
        public static int sum(int[][]theA, int[][]theB) {
            int result = 0;
            for (int row = 0; row < theA.length; row ++) {
                for (int col = 0; col < theA[row]; col ++) {
                    result += theA[row][col];
                }
            }
        return result;
        }

        // This is different code demonstrating arrays generally

        int[]a = new int[6]; 
        // 5 rows 9 columns 
        int [][] b = new int[5][9];   
        System.out.println(a.length);
        System.out.println(b.length);
        System.out.println(b[0].length);
        // This addresses the fence post problem
        for (int r = 0; r < b.length; r++) {
            System.out.print(b[r][0]);
            for (int c = 1; c < b[r].length; c++) {
                System.out.print(", " + b[r][c]);
            }
            System.out.println();
        }
    }

    public static void name() {
        
    }
}