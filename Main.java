package Pros;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Введите числа 1-10, через пробел со знаком нужной операции. Пример: 2 * 3; X / IX");
        System.out.print("Задача: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("Решение: " + input + " = " + calc(input) );
        System.out.println("Ответ: " + calc(input));
    }

    public static String calc(String input) throws Exception {

        String[] rome = {"","I","II","III","IV","V","VI","VII","VIII","IX","X",
                "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
                "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
                "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
                "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
                "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
                "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
                "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
                "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
                "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C" };

        boolean isRoman;

        if (!((isRoman = input.matches("[IVX]{1,4}" + " " + "[+\\-*/]" + " " + "[IVX]{1,4}")) || input.matches("\\d{1,2}" + " " + "[+\\-*/]" + " " + "\\d{1,2}")))
            throw new Exception("Не верный формат ввода. Попробуйте ввести: a ^ b. Вместо \"^\", введите операцию которую вы хотите провести. Виды операций: '*,/,+,-'");


        String[] arr = input.split(" ");
        int a = 0, b = 0;

        if(isRoman){
            for (int i = 1; i < rome.length; i++) {
                if(arr[0].equals(rome[i]))a = i;
                if(arr[2].equals(rome[i]))b = i;
            }
        } else {
            a = Integer.parseInt(arr[0]);
            b = Integer.parseInt(arr[2]);
        }

        if(a > 10 || a < 1 || b > 10 || b < 1) throw new Exception("Значение за пределами 1-10");

        int res = switch (arr[1]) {
            case ("+") -> a + b;
            case ("-") -> a - b;
            case ("*") -> a * b;
            case ("/") -> a / b;
            default -> 0;
        };

        if(isRoman){
            if(res < 1) throw new Exception("В римской системе минимальное число = I");

            char[] num = Integer.toString(res).toCharArray();
            StringBuilder ress = new StringBuilder();

            for (int i = 0, j = num.length - 1; i < num.length; i++, j--)
                ress.append(rome[Integer.parseInt(String.valueOf(num[i])) * ((int) Math.pow(10, j))]);

            return ress.toString();

        } else return Integer.toString(res);
    }
}
