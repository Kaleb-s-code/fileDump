public class App {
    public static void main(String[] args) {
        
        System.out.println("Hello... You filthy animal");
        
        int myNum = 10 * 5;
        int anotherNum = 43 * 7;
        int newNum = anotherNum * 3;
        System.out.println(myNum);
        System.out.println(anotherNum);
        System.out.println(newNum);
        char symbol = '\u00AE';
        System.out.println(symbol);
        boolean bob = false;
        if (bob == false)
            System.out.println("Titty smack");
        int topScore = 5000;
        if (topScore == 5000)
            System.out.println("Oh snap, you gonna git pussy");
        if (bob == false && topScore > 4000)
            System.out.println("And you gonna lick it too");
        if ((bob == false) || topScore < 50)
            System.out.println("And you might even get to put it in the stinky hole");
        boolean isCar = false;
        boolean wasCar = isCar ? true: false;
        System.out.println("This is a string: " + wasCar);
        // Chanllange of sorts 
        double aNum = 20d;
        double stupidNum = 80d;
        double someNum = (aNum + stupidNum) * 25d;
        System.out.println(someNum);
        double remainder = someNum % 40d;
        System.out.println("THis is the remainder: " + remainder);
        if (remainder <= 20)
            System.out.println("Total was over the limit!");
    }
}