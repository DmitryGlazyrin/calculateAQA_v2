import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        calculate();

    }
    static void calculate(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Input: ");

        String strExpression = scan.nextLine();
        String [] strExpressionArr = strExpression.split(" ");

        try {
            short num1 = Short.parseShort(strExpressionArr[0]);
            short num2 = Short.parseShort(strExpressionArr[2]);
        } catch (NumberFormatException e){
            System.out.println("Number is not natural");
            scan.close();
            return;
        }

        short num1 = Short.parseShort(strExpressionArr[0]);
        char znak = strExpressionArr[1].charAt(0);
        short num2 = Short.parseShort(strExpressionArr[2]);
        short result = 0;

        if ((num1<1 || num1>10) || (num2<1 || num2>10)){
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e){
                System.out.println("Number is incorrect");
                scan.close();
                return;
            }
        }

        if((znak != '+' && znak !='-' && znak != '*' && znak != '/') || (strExpression.length()>7)){
            try {
                throw new IOException();
            } catch (IOException e){
                System.out.println("This expression is not mathematical and does not support");
                scan.close();
                return;
            }
        }

        switch (znak){
            case '+':
                result = (short) (num1+num2);
                break;
            case '-':
                result = (short) (num1-num2);
                break;
            case '*':
                result = (short) (num1*num2);
                break;
            case '/':
                result = (short) (num1/num2);
                break;
        }

        System.out.println("Output: "+result);
        scan.close();
    }
}