public class ReverseAString {
    public static void main(String[] args) {
        String string = "helloWorld";
        System.out.println(reverseString(string));
    }

    public static String reverseString(String string) {
        int left = 0;
        int right = string.length() - 1;
        
        char[] charArray = string.toCharArray();

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }
}