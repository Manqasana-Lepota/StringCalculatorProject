import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private String delimiter;

    public String getDelimiter(String number) {
        String delimiterChange = number.split("\\n")[0];
        delimiter = delimiterChange.substring(2);
        return delimiter;
    }


    public int Add(String number) {
        String[] tokens;

        if (number.startsWith("//")) {
            delimiter = getDelimiter(number);
            String calculation = number.split("\\n")[1];
            tokens = calculation.split("[" + delimiter + "]+");
        }
        else
            tokens = number.split(",|\\n");
            if (number.isEmpty()) {
                return 0;
            }
            if (number.length() == 1) {
            return Integer.parseInt(number);
            }
            else {
            return Sum(tokens);
        }
    }

    public int Sum(String[] numbers) throws IllegalArgumentException {
        int sum = 0;

        ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            if (Integer.parseInt(numbers[i]) < 0) {
                negativeNumbers.add(Integer.parseInt(numbers[i]));
            }
            if (Integer.parseInt(numbers[i]) >= 1000) {
                continue;
            } else
                sum += Integer.parseInt(numbers[i]);
        }
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed : " + negativeNumbers);
        }
            return sum;

    }
    public static void main(String[] args) {

        StringCalculator cal = new StringCalculator();

        System.out.println("Sum of empty String : " + cal.Add(""));
        System.out.println("Sum of one number : " + cal.Add("9"));
        System.out.println("Sum of two numbers : " + cal.Add("9,2"));
        System.out.println("Sum of multiple numbers : " + cal.Add("1,3,5,7,9"));
        System.out.println("Sum of numbers with lines between : " + cal.Add("1\n2,3"));
        System.out.println("Sum of numbers with different delimiters : " + cal.Add("//;\n1;2"));
        System.out.println("Sum that handles greater or equals integer : " + cal.Add("1000,1,2,1001"));
        System.out.println("Sum that supports delimiter length : " + cal.Add("//***\n1***2***3"));
        System.out.println("Sum that handles negative integer : " + cal.Add("-4,-1"));
    }
}




