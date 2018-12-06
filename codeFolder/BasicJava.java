// import java.util.Scanner;

// public class BasicJava {
//     public static void main(String[] theArgs) {
//         System.out.println("Hello, world");
        
        // String greeting = "Hello, World";
        // System.out.println(greeting);

        // Scanner console = new Scanner(System.in);
        // System.out.print("Enter your full name: ");
        // String name = console.nextLine();
        // System.out.print("Enter your age");
        // int age = console.nextInt();
        // System.out.println(name + " is age " + age);
        
        // int space = greeting.indexOf(" ");
        // String outString = greeting.substring(0, space + 1) + name + 
        //                 "! you are " + age + " years old!";
        // System.out.println(outString);

//     int[] a = {25, 30, 38,};
//     int[] b = {50, 60, 75, 100, 300};
    
//     System.out.println("average a & b content are: " + 
//                     convertArrayToString(a) + "," + 
//                     converyArrayToString(b));

    
//     // int[] c = new int[15];

//     }
//     public static String convertArrayToString(int[] theA) {
//         String result = "[" + theA[0];
//         int index = 1;
//         while (index < theA.length) {
//             result = result + "," + theA[index];
//             index += 1;
//         }    
//         result += "]";
//         return result;
//     }
// } 
public static String convertArrayToString(int[] theA, int[] theB) {
    int sizeA = theA.length;
    int sizeB = theB.length;
    int[] result = new int[sizeA + sizeB];
    int index = 0;
    while (index < sizeA) {
        result[index] = theA[index];
        index += 1;
    }
    while (index < result.length) {
        result[index] = theB[index - sizeA];
        index ++;
    }
    return result;
}