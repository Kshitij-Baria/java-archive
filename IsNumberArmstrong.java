import java.util.ArrayList;
import java.util.List;

public class IsNumberArmstrong {
    public static void main(String[] args) {
        int number = 153;
        System.out.println(String.format("Is %d an armstrong number? %s", number, isNumberArmstrong(number)));
    }

    public static List<Integer> getDigits(int number) {
        String numberString = Integer.toString(number);

        List<Integer> digits = new ArrayList<>();
        for (char c: numberString.toCharArray()) {
            digits.add(c - '0');
        }
        return digits;
    }

    public static boolean isNumberArmstrong(int number) {
        List<Integer> digits = getDigits(number);

        int sum = 0;
        for(int i: digits) {
            int j = (int) Math.pow(i, digits.size());
            sum += j;
        }

        return sum == number;
    }
}