public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        int myIntValue = 5 / 2;
        float myFloat = 5f / 3f;
        double myDouble = 5d / 3d;
        System.out.println(myIntValue);
        System.out.println(myFloat);
        System.out.println(myDouble);
        double pounds = 200d;
        double kilo = 0.45359237;
        double conversion = (pounds * kilo);
        System.out.println(pounds + " Pounds is equal to: " + conversion + " Kilos");
        
    }
}