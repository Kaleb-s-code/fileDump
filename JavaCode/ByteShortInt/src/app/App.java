public class App {
    public static void main(String[] args) throws Exception {
        // This is a comment
        // int width 32
        // byte width 8
        // short width 16
        // long width 64
        System.out.println("Hello Java");
        int myNum = 10_000;
        System.out.println(myNum);
        byte myByteValue = 10;
        short myShort = 32_767;
        long myLongValue = 887_766L;
        System.out.println(myShort / myByteValue);
        byte myNumber = (byte) (myShort - myNum);
        System.out.println(myNumber);
        short myNewShort = (short) (myShort / 2);
        System.out.println("myNewShoerValue: " + myNewShort);
        
        byte aNum = 12;
        short shortNum = 1234;
        int intNum = 1_234_456_789;
        long var = 50_000L + (10L * (aNum + shortNum + intNum));
        System.out.println("This is my doing: " + var);

    }
}