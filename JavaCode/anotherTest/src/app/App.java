package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    printMegaBytesAndKileBytes(2050);
        
    }
    public static void printMegaBytesAndKileBytes(int kiloBytes) {
        int mega = kiloBytes % 1_024;
        int kilo = kiloBytes % 1_024;
        System.out.println(kiloBytes + " KB = " + mega + " MB and " + kilo + " KB");

    }   
}