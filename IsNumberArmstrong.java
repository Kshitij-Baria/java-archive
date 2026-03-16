public class IsNumberArmstrong {
    public static void main(String[] args) {
        int number = 153;
        System.out.println(String.format("Is %d an armstrong number? %s", number, isNumberArmstrong(number)));
    }

    public static boolean isNumberArmstrong(int number) {
        int digits = 0;
        int temp = number;

        while(temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = number;
        int sum = 0;

        while(temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        return sum == number;
    }
}