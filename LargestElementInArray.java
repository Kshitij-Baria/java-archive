import java.util.Arrays;

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 99, 9, 10};
        System.out.println(String.format("Array: %s", Arrays.toString(array)));
        System.out.println(String.format("Largest element in the array is %d", max(array)));
    }

    public static int max(int[] array) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++) {
            max = max < array[i] ? array[i] : max;
        }

        return max;
    }
}
