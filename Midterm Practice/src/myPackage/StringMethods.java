package myPackage;

public class StringMethods {

	public static void main(String[] args) {
		
		String someString = "Once upon a time";
		String anotherString = "once upon a time There was";
		int someInt = 500;
		String someVar = "";
		System.out.println(someString.indexOf("Once"));
		
		System.out.println(someString.charAt(0));
		
		System.out.println(someString.substring(5, 13));
		
		System.out.println(someString.compareToIgnoreCase(anotherString));
		
		System.out.println(someString.contains("a"));
		
		System.out.printf("%S, there were: %n%d cats.",someString, someInt);
		System.out.println();
		
		someVar = String.format("I have something to say: %s%nYou should pay attention to this also: %s", someString, anotherString);
		System.out.println(someVar);
	
	}

}
