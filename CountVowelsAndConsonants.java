public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        String string = "hello World";

        String normalizedString = string.replaceAll("[\\W+\\d+]", "").toLowerCase();
        String stringWithOnlyVowels = normalizedString.replaceAll("[^aeiou]", "");
        String stringWithOnlyConsonants = normalizedString.replaceAll("[aeiou]", "");

        System.out.println(String.format("Total vowels in %s: %d", string, stringWithOnlyVowels.length()));
        System.out.println(String.format("Total consonants in %s: %d", string, stringWithOnlyConsonants.length()));
    }
}