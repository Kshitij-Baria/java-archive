public class SumOfDigitsOfANumber {
    public static void main(String[] args) {
        int number = 153;
        System.out.println(getSumOfDigits(number));
        System.out.println(getSumOfDigitsUsingStringConversion(number));
    }

    public static int getSumOfDigits(int number) {
        int temp = number;
        int sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }

    public static int getSumOfDigitsUsingStringConversion(int number) {
        String numberString = Integer.toString(number);
        char[] charArray = numberString.toCharArray();
        int sum = 0;
        for (int i = 0; i < charArray.length; i++) {
            sum += charArray[i] - '0';
        }
        return sum;
    }
}