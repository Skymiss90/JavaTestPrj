import java.util.Scanner;
public class Main
{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception
    {

        String result = calc((scanner.nextLine()));
        System.out.println(result);
    }

    static class RomansNumbers 
    {
        int numR;

        public int romanToArabic(String num) throws Exception 
        {
            switch (num) 
            {
                case "I" -> numR = 1;
                case "II" -> numR = 2;
                case "III" -> numR = 3;
                case "IV" -> numR = 4;
                case "V" -> numR = 5;
                case "VI" -> numR = 6;
                case "VII" -> numR = 7;
                case "VIII" -> numR = 8;
                case "IX" -> numR = 9;
                case "X" -> numR = 10;
                default -> throw new Exception("Введено недопустимое значение");
            }
            return numR;

        }

        public String arabicToRoman(int num) 
        {
            String[] romanNum = 
            {
                    "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
            };
            return romanNum[num];
        }
    }
    public static String calc(String input) throws Exception
    {
        String resultStr;
        String[] numbers = input.split(" ");
        if (numbers.length != 3)
        {
            throw new Exception("строка не является математической операцией");
        }
        int result;
        char romanNum1 = numbers[0].charAt(0);
        char romanNum2 = numbers[2].charAt(0);
        if ((romanNum1 == 'I' || romanNum1 == 'V' || romanNum1 == 'X') && (romanNum2 == 'I' || romanNum2 == 'V' || romanNum2 == 'X')) 
        {
            RomansNumbers convert = new RomansNumbers();
            int operand1 = convert.romanToArabic(numbers[0]);
            int operand2 = convert.romanToArabic(numbers[2]);
            switch (numbers[1]) 
            {
                case "-" -> result = operand1 - operand2;
                case "+" -> result = operand1 + operand2;
                case "*" -> result = operand1 * operand2;
                case "/" -> result = operand1 / operand2;
                default -> throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
            if (result > 0) 
            {
                resultStr = convert.arabicToRoman(result);
            } else throw new Exception("В римской системе нет отрицательных чисел");

        } 
        else 
        {
            int numAr1 = 0;
            int numAr2 = 0;
            try 
            {
                numAr1 = Integer.parseInt(numbers[0]);
                numAr2 = Integer.parseInt(numbers[2]);
            } 
            catch (NumberFormatException e)
            {
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

            if (!(0 < numAr1 && numAr1 <= 10) || !(0 < numAr2 && numAr2 <= 10)) 
            {
                throw new Exception("Допустимы числа от 1 до 10");
            }
            switch (numbers[1]) 
            {
                case "-" -> result = numAr1 - numAr2;
                case "+" -> result = numAr1 + numAr2;
                case "*" -> result = numAr1 * numAr2;
                case "/" -> result = numAr1 / numAr2;
                default -> throw new Exception("строка не является математической операцией");
            }
            resultStr = String.valueOf(result);
        }
        return resultStr;
    }

}
