package app;


public class App {
    public static void main(String[] args) throws Exception {
        char someVar = 'X';
        switch(someVar) {
            case 'A': case 'B': case 'C': case 'D':
                System.out.println("Some message");
                break;
            
            default:
                System.out.println("Nothing found");
                break;
        }
    }
}