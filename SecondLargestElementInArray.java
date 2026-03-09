import java.util.Arrays;

public class SecondLargestElementInArray {
    public static void main(String[] args) {
        int[] array = { 1, 6, 2, 10, 3, 7, 5, 9, 4, 8 };

        System.out.println(String.format("Array: %s", Arrays.toString(array)));
        System.out.println(String.format("Second largest element in array is %d", secondLargest(array)));
    }

    public static int secondLargest(int[] array) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num != largest) {
                second = num;
            }
        }

        return second;
    }
}