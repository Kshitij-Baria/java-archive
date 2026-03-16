import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        String string = "helloWorld";
        System.out.println(removeDuplicatesUsingStream(string));
        System.out.println(removeDuplicatesUsingSet(string));
    }

    public static String removeDuplicatesUsingStream(String string) {
        return Arrays.stream(string.split(""))
        .distinct()
        .collect(Collectors.joining(""));
    }

    public static String removeDuplicatesUsingSet(String string) {
        Set<Character> characterSet = new LinkedHashSet<>();

        for(char c: string.toCharArray()) {
            characterSet.add(c);
        }

        StringBuilder result = new StringBuilder();
        for(char c: characterSet) {
            result.append(c);
        }

        return result.toString();
    }
}