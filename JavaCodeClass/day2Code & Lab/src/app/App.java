package app;
import java.util.Scanner;
/* THis is code from day 2 
*  TCSS 142
*/

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        char response = 'y';
        int starCnt;

        while (response == 'y') {
            System.out.print("Enter # for pattern: ");
            starCnt = input.nextInt();
            printDesign(starCnt);
            System.out.println("Do another? [y/n] ");
            response = input.next().charAt(0);
        }
    }
    public static void printDesign(int theAmount) {
        for (int lines = 1; lines <= theAmount; lines++) {
            for (int i = 0; i < theAmount - lines; i++) {
                System.out.print("-");
            }
            for (int digits = 1; digits <= (lines - 1) * 2; digits++) {
                System.out.print(lines - 1);
            }
            for (int i = 0; i < theAmount - lines; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        // System.out.println();
    }
}

        
        // for (int i = 1; i <= 6; i++) {
        //     System.out.println(i + ": I am so smart");
        // }
        // This is converting F to C
        // int highestTemp = 5;
        // for (int i = -3; i <= highestTemp / 2; i++) {
        //     System.out.println((i * 1.8 + 32) + " ");
        // }

