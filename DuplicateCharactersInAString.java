import java.util.HashMap;
import java.util.Map;

public class DuplicateCharactersInAString {
    public static void main(String[] args) {
        String string = "HelloWorld";
        System.out.println(findDuplicates(string));
    }

    public static Map<Character, Integer> findDuplicates(String string) {
        Map<Character, Integer> occurrenceMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            int value = occurrenceMap.get(string.charAt(i)) == null ? 1 : occurrenceMap.get(string.charAt(i)) + 1;
            occurrenceMap.put(string.charAt(i), value);

            // A better way for java 23 onwards would be
            // occurrenceMap.put(string.charAt(i), occurrenceMap.getOrDefault(string.charAt(i), 0) + 1);
        }
        return occurrenceMap;
    }
}