public class IsStringPalindrome {
    public static void main(String[] args) {
        String string1 = "helloworld";
        String string2 = "racecar";

        System.out.println(String.format("is %s a palindrome?: %s", string1, isStringPalindrome(string1)));

        System.out.println(String.format("is %s a palindrome?: %s", string2, isStringPalindrome(string2)));
    }

    public static boolean isStringPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;

        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}