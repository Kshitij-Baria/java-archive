import java.util.Arrays;

public class AreStringsAnagrams {
    public static void main(String[] args) {
        String string1 = "listen";
        String string2 = "silent";

        System.out.println(areStringsAnagramsUsingSorting(string1, string2));
        System.out.println(areStringsAnagramsUsingCharacterMap(string1, string2));
    }

    public static boolean areStringsAnagramsUsingSorting(String string1, String string2) {
        if (string1.length() != string2.length()) return false;

        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }


    public static boolean areStringsAnagramsUsingCharacterMap(String string1, String string2) {
        if (string1.length() != string2.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i) - 'a']++;
            count[string2.charAt(i) - 'a']--;
        }

        for(int c: count) {
            if (c != 0) return false;
        }

        return true;
    }
}