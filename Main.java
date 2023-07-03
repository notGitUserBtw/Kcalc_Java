import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression = input.nextLine().trim();
        String[] seq = expression.split(" "); // number1 = seq[0], number2 = seq[2], operation = seq[1]
        if(seq.length != 3){
            System.out.println("Калькулятьр работает лишь с двумя числами. Разделителем служит пробел.");
            System.exit(1);
        }
        String operation = seq[1];

        String typeNum1 = ""; // римская или арабскаяа цифра
        String typeNum2 = ""; // римская или арабскаяа цифра

        //Римские числа
        Map<String, String> romeNumbers = new HashMap<String, String>();
        romeNumbers.put("I", "1");
        romeNumbers.put("II", "2");
        romeNumbers.put("III", "3");
        romeNumbers.put("IV", "4");
        romeNumbers.put("V", "5");
        romeNumbers.put("VI", "6");
        romeNumbers.put("VII", "7");
        romeNumbers.put("VIII", "8");
        romeNumbers.put("IX", "9");
        romeNumbers.put("X", "10");

        //--Проверка значений(4 цикла фор подряд... Надо в функцию запихнуть)--
        /*for(var i: romeNumbers.keySet()){
            if(i.equals(seq[0])) typeNum1 = "roman";
        }
        for(var i: romeNumbers.values()){
            if(i.equals(seq[0])) typeNum1 = "arabic";
        }
        for(var i: romeNumbers.keySet()){
            if(i.equals(seq[2])) typeNum2 = "roman";
        }
        for(var i: romeNumbers.values()){
            if(i.equals(seq[2])) typeNum2 = "arabic";
        }*/
        typeNum1 = defineType(seq[0], romeNumbers);
        typeNum2 = defineType(seq[2], romeNumbers);
        //--end--
        // для арабских чисел
        if(typeNum1 == "arabic" && typeNum2 == "arabic" ){
            long number_1 = Long.parseLong(seq[0]);
            long number_2 = Long.parseLong(seq[2]);
            switch(operation){
                case "+":
                    System.out.println(number_1 + " + " + number_2 + " = " + (number_1 + number_2));
                    break;
                case "-":
                    System.out.println(number_1 + " - " + number_2 + " = " + (number_1 - number_2));
                    break;
                case "*":
                    System.out.println(number_1 + " * " + number_2 + " = " + (number_1 * number_2));
                    break;
                case "/":
                    System.out.println(number_1 + " / " + number_2 + " = " + (number_1 / number_2));
                    break;
                default:
                    System.out.println("Допущенна ошибка. Калькулятор поддерживает операции +(сложение), -(вычитание), *(умножение), /(деления)\n только с двумя числами, от 1 до 10 включительно.");
            }
        }
        // для римских чисел
        else if(typeNum1 == "roman" && typeNum2 == "roman"){
            long number_1 = Long.parseLong(romeNumbers.get(seq[0]));
            long number_2 = Long.parseLong(romeNumbers.get(seq[2]));
            switch(operation){
                case "+": // В результате должно быть римское число, надо найти способ как получить ключ по значенью и в отдельную функцию его !!!!!!!!!!!!
                    System.out.println(seq[0] + " + " + seq[2] + " = " + getRomeNumberFromArabic(Long.toString(number_1 + number_2), romeNumbers));
                    break;
                case "-":
                    if(number_1 - number_2 >= 1){
                        System.out.println(seq[0] + " - " + seq[2] + " = " + getRomeNumberFromArabic(Long.toString(number_1 + number_2), romeNumbers));
                    }
                    else{
                        System.out.println("Римские числа не могут быть отрицательными или равны нулю.");
                    }
                    break;
                case "*":
                    System.out.println(seq[0] + " * " + seq[2] + " = " + getRomeNumberFromArabic(Long.toString(number_1 * number_2), romeNumbers));
                    break;
                case "/":
                    System.out.println(seq[0] + " / " + seq[2] + " = " + getRomeNumberFromArabic(Long.toString(number_1 / number_2), romeNumbers));
                    break;
                default:
                    System.out.println("Допущенна ошибка. Калькулятор поддерживает операции +(сложение), -(вычитание), *(умножение), /(деления)\nтолько с двумя числами, от 1(I) до 10(X) включительно.");
            }
        }
        else if((typeNum1=="arabic" && typeNum2=="roman") || (typeNum2=="arabic" && typeNum1=="roman")){
            System.out.println("Калькулятор не поодерживает операции с римскими и арабскими числами одновременно");
        }
        else {
            System.out.println("Ошибка. Числа могут быть от 1 до 10 включительно.");
        }
    }
    public static String getRomeNumberFromArabic(String arabicNumber, Map<String, String> romeNumbers){
        for(String i: romeNumbers.keySet()){
            if(romeNumbers.get(i).equals(arabicNumber)) return i;
        }
        return arabicNumber;
    }
    public static String defineType(String undefineNumber, Map<String, String> romeNumbers){
        String result = "";
        if(romeNumbers.containsKey(undefineNumber)) result = "roman";
        else if(romeNumbers.containsValue(undefineNumber)) result = "arabic";
        return result;
        /***for(var i: romeNumbers.keySet()){
         if(i.equals(seq[0])) typeNum1 = "roman";
         }
         for(var i: romeNumbers.values()){
         if(i.equals(seq[0])) typeNum1 = "arabic";
         }
         for(var i: romeNumbers.keySet()){
         if(i.equals(seq[2])) typeNum2 = "roman";
         }
         for(var i: romeNumbers.values()){
         if(i.equals(seq[2])) typeNum2 = "arabic";
         }***/
    }
}


