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
            System.out.println("Oh snap");
        if (bob == false && topScore > 4000)
            System.out.println("And");
        if ((bob == false) || topScore < 50)
            System.out.println("And you");
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
//You should probably use brackets in if blocks 
        if (remainder >= 20) {
            System.out.println("Sexy time");
        }
        int myVariable = 50;
        myVariable ++;
        System.out.println(myVariable);
//Code blocks 
        boolean gamrOver = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus = 100;

        if (score == 5000 || score > 3000) {
            System.out.println("Your score was: " + score);
        } else if(score <= 2000) {
            System.out.println("Your score was not 5000");
        } else {
            System.out.println("Dog doo doo");
        }
        
    }
}