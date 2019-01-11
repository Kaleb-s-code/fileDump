package app;

public class App {

    public static void main(String[] args) {
        int salary = 27500;
        double tax = 0;
        if (salary > 0 && salary <= 7150) {
            tax = (salary * .10);
        }
        else if (salary > 7150 && salary <= 29050) {
            tax = 715 + ((salary - 7150) * .15);
        }
        else if (salary > 29050 && salary <= 70350) {
            tax = 4000 + ((salary - 29050) * .25);
        }
        else {
            tax = 14325 + ((salary - 70350) * .28);
        }
System.out.println(tax);    }
}