import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("введите арифметическое выражение");
        Scanner scan = new Scanner(System.in);
        System.out.println(calc(scan.nextLine()));
    }

    public static String calc(String input){
        String[] rim = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", ""};
        String[] arabic = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", ""};
        int num0 = 0, num1 = 0, i = 1;
        char oper;
        boolean fRim = false, fRim0 = false, fRim1 = false;
        boolean fArabic = false, fArabic0 = false, fArabic1 = false;

        input = input.replace(" ","");
        String[] numbers = input.split("[+-/*]");

        if (numbers.length != 2) {
            input = "неверное выражение";
        }
        else
            while (i<12 ^ !fRim ^ !fArabic) {
                if(numbers[0].equals(rim[i]) & !fRim0){
                    fRim0 = true;
                    num0 = i;
                }
                if(numbers[1].equals(rim[i]) & !fRim1){
                    fRim1 = true;
                    num1 = i;
                }
                if(numbers[0].equals(arabic[i]) & !fArabic0){
                    fArabic0 = true;
                    num0 = i;
                }
                if(numbers[1].equals(arabic[i]) & !fArabic1){
                    fArabic1 = true;
                    num1 = i;
                }
                if(fRim0 & fRim1){
                    fRim = true;
                }
                if(fArabic0 & fArabic1){
                    fArabic = true;
                }
                i++;
        }
            if(!fRim & !fArabic){
                input = "неверное выражение";
            }

            if(fArabic){
                oper = input.charAt(numbers[0].length());
                switch(oper){
                    case '+': input = Integer.toString(num0+num1); break;
                    case '-': input = Integer.toString(num0-num1); break;
                    case '*': input = Integer.toString(num0*num1); break;
                    case '/': input = Integer.toString(num0/num1); break;
                    default: input = "неверное выражение";
                }
        }
            if(fRim){
                oper = input.charAt(numbers[0].length());
                int res = 0;
                switch(oper){
                    case '+': res = num0+num1; break;
                    case '-': res = num0-num1; break;
                    case '*': res = num0*num1; break;
                    case '/': res = num0/num1; break;
 //                   default: input = "неверное выражение4";
                }

                if (res<1){
                    input = "неверное выражение ";
                }
                else if (res<11) input = rim[res];
                else if (res<20) input = "X" + rim[res%10];
                else if (res<30) input = "XX" + rim[res % 10];
                else if (res<40) input = "XXX" + rim[res % 10];
                else if (res<50) input = "XL" + rim[res % 10];
                else if (res<60) input = "L" + rim[res % 10];
                else if (res<70) input = "LX" + rim[res % 10];
                else if (res<80) input = "LXX" + rim[res % 10];
                else if (res<90) input = "LXXX" + rim[res % 10];
                else if (res<100) input = "XC" + rim[res % 10];
                else input = "C";
            }
        return(input);
    }
}
