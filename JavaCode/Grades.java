import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Grades {
    public static void main(String[] theArgs) {
        int[] gradesCount = new int[101];
        Scanner input = null;
        try {
            input = new Scanner(new File("/Users/adminuser/Code/codeDumpingGround/fileDump/textFiles/Scores.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e);
            System.exit(-1);
        }
        int[] actualGrades = getScores(input, gradesCount);
        System.out.println(convertArrayToString(gradesCount));
        System.out.println(convertArrayToString(actualGrades));
        displayHistogram(gradesCount);
        double average = getAverage(actualGrades);
        System.out.println("Class average = " + average + "%");
    }
    public staticdouble getAverage(int[] theA) {
        double total = 0.0;
        for (int i = 0; i < theA.length; i++) {
            total += theA[i];
        }
        return total / theA.length;
    }
    public static int[] getScores(Scanner theIn, int[] theGradesCnt) {
        int[] grades = new int[theIn.nextInt()];
        int index = 0;
        while (index < grades.length) {
            int score = theIn.nextInt();
            grades[index] = score;
            theGradesCnt[score] ++;
            index ++;
        }
        return grades;
    }
    public static void displayHistogram(int[] theA) {
        int index = 0;
        while (index < theA.length) {
            if (theA[index] > 0) {
                System.out.print(String.format("%3d: ", index));
                for (int starCount = 0; startCount < theA[index]; starCount ++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        index ++;
        }
    }
    public static String convertArrayToString(int[] theA) {
        String result = "[" + theA[0];
        int index = 1;
        while (index < theA.length) {
            result = result + "," + theA[index];
            index += 1;
        }    
         result += "]";
         return result;
    }
}