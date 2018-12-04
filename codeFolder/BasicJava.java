import java.util.Scanner;

public class BasicJava {
    public static void main(String[] theArgs) {
        System.out.println("Hello, world");
        
        String greeting = "Hello, World";
        System.out.println(greeting);

        java.util.Scanner console = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String name = console.nextLine();
        System.out.print("Enter your age");
        int age = console.nextInt();
        System.out.println(name + " is age " + age);
        
        int space = greeting.indexOf(" ");
        String outString = greeting.substring(0, space + 1) + name + 
                        "! you are " + age + " years old!";
        System.out.println(outString);


    }
} 