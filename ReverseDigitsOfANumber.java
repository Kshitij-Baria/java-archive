public class ReverseDigitsOfANumber {
    public static void main(String[] args) {
        int number = 153;
        System.out.println(reverseDigits(number));
        System.out.println(reverseDigitsUsingStringConversion(number));
    }

    public static int reverseDigits(int number) {
        int temp = number;
        int reverse = 0;
        while (temp > 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp /= 10;
        }
        return reverse;
    }

    public static int reverseDigitsUsingStringConversion(int number) {
        String numberString = Integer.toString(number);

        char[] charArray = numberString.toCharArray();

        int left = 0;
        int right = numberString.length() - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        String reversedNumberString = new String(charArray);
        return Integer.parseInt(reversedNumberString);
    }
}
