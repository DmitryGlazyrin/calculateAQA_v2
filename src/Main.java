import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        System.out.print("Input: ");
        Scanner scan = new Scanner(System.in);
        String strExpression = scan.nextLine();
        calculate(strExpression);
        String resultStr = calculate(strExpression);
        System.out.println("Output: "+resultStr);

    }
    public static String calculate(String strExpression){

        String [] strExpressionArr = strExpression.split(" ");
        String exceptionVariable;

        try {
            if(isRomanNum(strExpressionArr)){
                throw new IOException();
            }
        } catch (IOException e){
            return exceptionVariable = "Roman number isn`t supported";
        }

        try {
            short num1 = Short.parseShort(strExpressionArr[0]);
            short num2 = Short.parseShort(strExpressionArr[2]);
        } catch (NumberFormatException e){
           return exceptionVariable = "Number isn`t natural";
        }

        short num1 = Short.parseShort(strExpressionArr[0]);
        char znak = strExpressionArr[1].charAt(0);
        short num2 = Short.parseShort(strExpressionArr[2]);
        short result = 0;

        if ((num1<1 || num1>10) || (num2<1 || num2>10)){
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e){
               return exceptionVariable = "Number is incorrect";
            }
        }

        if(!(znak == '+' || znak == '-' || znak == '/' || znak == '*') || (strExpression.length()>7)){
            try {
                throw new IOException();
            } catch (IOException e){
                return exceptionVariable = "This expression is not mathematical and does not support";
            }
        }
        String output = " ";
        switch (znak){
            case '+':
                result = (short) (num1+num2);
                output = String.valueOf(result);
                return output;
            case '-':
                result = (short) (num1-num2);
                output = String.valueOf(result);
                return output;
            case '*':
                result = (short) (num1*num2);
                output = String.valueOf(result);
                return output;
            case '/':
                result = (short) (num1/num2);
                output = String.valueOf(result);
                return output;
        }
        return output;
    }

    public static boolean isRomanNum(String[] strExpressionArr){
        Pattern romanPattern = Pattern.compile("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
        String num1 = strExpressionArr[0];

        if(romanPattern.matcher(num1).matches()){
            return true;
        }

        String num2 = strExpressionArr[2];
        if(romanPattern.matcher(num2).matches()){
            return true;
        }

        return false;
    }
}