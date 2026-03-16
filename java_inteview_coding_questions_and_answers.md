# Java Coding Interview Questions

## Basic Coding Problems

### Reverse a String

```java
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
```

---

### Check if a String is a Palindrome

```java
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
```

Output:
```
is helloworld a palindrome?: false
is racecar a palindrome?: true
```

---

### Find the Largest Element in an Array

```java
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
```

Output
```
Array: [1, 2, 3, 4, 5, 6, 7, 8, 99, 9, 10]
Largest element in the array is 99
```

---

### Find the Second Largest Element in an Array

```java
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
```

Output:
```
Array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Second largest element in array is 9
```

---

### Reverse an Array

```java
import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(String.format("Array: %s", Arrays.toString(array)));
        reverseArray(array);
        System.out.println(String.format("Reversed array: %s", Arrays.toString(array)));
    }

    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }
}
```

Output:
```
Array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Reversed array: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
```

---

### Count Vowels and Consonants in a String

```java
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
```

Output:
```
Total vowels in helloWorld: 3
Total consonants in helloWorld: 7
```

---

### Swap Two Numbers Without Using a Third Variable

```java
public class SwapTwoNumbersWithoutTemp {
    public static void main(String[] args) {
        int a = 5;
        int b = -10;

        System.out.println(String.format("Before swapping, a = %d and b = %d", a, b));

        a = a + b;
        b = a - b;
        a = a - b;

        // another approach
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(String.format("After swapping, a = %d and b = %d", a, b));
    }
}
```

Output:
```
Before swapping, a = 5 and b = -10
After swapping, a = -10 and b = 5
```

---

### Find the Factorial of a Number

```java
public class FactorialWithRecursion {
    public static void main(String[] args) {
        int number = 6;
        System.out.println(String.format("Factorial of %d is %d", number, factorial(number)));
    }

    public static int factorial(int number) {
        if (number > 1) {
            return number * factorial(number - 1);
        }
        return 1;
    }
}
```

Output:
```
Factorial of 6 is 720
```

---

### Generate Fibonacci Series

#### Generate Fibonacci series with recursion
```java
import java.util.ArrayList;
import java.util.List;

public class GenerateFibonacciSeriesWithRecurssion {
    public static void main(String[] args) {
        System.out.println(fibonacciList(10));
    }

    public static List<Integer> fibonacciList(int number) {
        if (number <= 0) {
            return new ArrayList<>();
        } else if (number == 1) {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(0);
            return sequence;
        } else if (number == 2) {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(0);
            sequence.add(1);
            return sequence;
        }

        List<Integer> sequence = fibonacciList(number - 1);

        sequence.add(sequence.get(sequence.size() - 1) + sequence.get(sequence.size() - 2));

        return sequence;
    }
}
```

Output:
```
[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
```

---

#### Generate Fibonacci series without recursion

```java
import java.util.ArrayList;
import java.util.List;

public class GenerateFibonacciSeriesWithoutRecurssion {
    public static void main(String[] args) {
        System.out.println(fibonacciList(10));
    }

    public static List<Integer> fibonacciList(int number) {
        if (number <= 0) {
            return new ArrayList<>();
        } else if (number == 1) {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(0);
            return sequence;
        } else if (number == 2) {
            List<Integer> sequence = new ArrayList<>();
            sequence.add(0);
            sequence.add(1);
            return sequence;
        }

        List<Integer> sequence = new ArrayList<>();
        sequence.add(0);
        sequence.add(1);

        for (int i = 0; i < number - 2; i++) {
            sequence.add(sequence.get(sequence.size() - 1) + sequence.get(sequence.size() - 2));
        }

        return sequence;
    }
}
```

Output:
```
[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
```

---

### Check if a Number is Prime

```java
public class IsNumberPrime {
    public static void main(String[] args) {
        int number = 5;
        System.out.println(String.format("Is %d a prime number? %s", number, isNumberPrime(number)));
    }

    public static boolean isNumberPrime(int number) {
        if (number <= 1) {
            return false;
        }

        int divisors = 0;
        for(int i = 1; i <= Math.sqrt(number); i++) {
            divisors += number % i == 0 ? 1 : 0;
        }

        return divisors <= 1;
    }
}
```

Output:
```
Is 5 a prime number? true
```

---

### Check if a Number is Armstrong

```java
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
```

Output:
```
Is 153 an armstrong number? true
```

---

### Sum of Digits of a Number

```java
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
        char[] chars = numberString.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum += chars[i] - '0';
        }
        return sum;
    }
}
```

Output:
```
9
9
```

---

### Reverse Digits of a Number

```java
public class ReverseDigitsOfANumber {
    public static void main(String[] args) {
        int number = 153;
        System.out.println(reverseDigits(number));
        System.out.println(reverseDigitsUsingStringConversion(number));
    }

    public static int reverseDigits(int number) {
        int temp = number;
        int reverse = 0;
        while (temp > 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp /= 10;
        }
        return reverse;
    }

    public static int reverseDigitsUsingStringConversion(int number) {
        String numberString = Integer.toString(number);

        char[] charArray = numberString.toCharArray();

        int left = 0;
        int right = numberString.length() - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        String reversedNumberString = new String(charArray);
        return Integer.parseInt(reversedNumberString);
    }
}
```

Output:
```
351
351
```

---

## String Coding Questions

### Find Duplicate Characters in a String

```java
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
```

Output:
```
{r=1, d=1, e=1, W=1, H=1, l=3, o=2}
```

---

### Remove Duplicate Characters from a String

```java
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
```

Output:
```
heloWrd
heloWrd
```

---

### Count the Occurrence of Each Character in a String

```java
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
```

Output:
```
{r=1, d=1, e=1, W=1, H=1, l=3, o=2}
```

---

### Check if Two Strings are Anagrams

```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AreStringsAnagrams {
    public static void main(String[] args) {
        String string1 = "listen";
        String string2 = "silent";

        System.out.println(areStringsAnagrams(string1, string2));
    }

    public static boolean areStringsAnagrams(String string1, String string2) {
        Map<String, Integer> occurrenceMap1 = getCharacterOccurrences(string1);
        Map<String, Integer> occurrenceMap2 = getCharacterOccurrences(string2);

        for(Entry<String, Integer> entry: occurrenceMap1.entrySet()) {
            if (entry.getValue() != occurrenceMap2.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, Integer> getCharacterOccurrences(String string) {
        List<String> characterList = Arrays.stream(string.split("")).toList();
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for(String character: characterList) {
            if (occurrenceMap.get(character) == null) {
                occurrenceMap.put(character, 1);
            } else {
                occurrenceMap.put(character, occurrenceMap.get(character) + 1);
            }
        }
        return occurrenceMap;
    }
}
```

Output:
```
true
true
```

---

### Find the First Non-Repeated Character in a String

### Find the Longest Substring Without Repeating Characters

### Check if a String Contains Only Digits

### Convert String to Integer Without Using parseInt()

## Array Coding Questions

### Find Missing Number in an Array

### Find Duplicate Elements in an Array

### Remove Duplicates from an Array

### Find the Intersection of Two Arrays

### Find the Union of Two Arrays

### Move All Zeros to the End of an Array

### Rotate an Array Left or Right

### Find the Maximum Subarray Sum (Kadane’s Algorithm)

### Merge Two Sorted Arrays

### Sort an Array (Bubble Sort / Selection Sort / Insertion Sort)

## HashMap / Set Based Questions

### Count Frequency of Elements in an Array

### Find the First Repeated Element in an Array

### Group Anagrams Together

### Find Pairs with a Given Sum

## Linked List Questions

### Reverse a Linked List

### Find the Middle of a Linked List

### Detect a Loop in a Linked List

### Remove Nth Node from End of List

### Merge Two Sorted Linked Lists

## Stack and Queue Questions

### Implement Stack Using Array

### Implement Queue Using Array

### Reverse a Stack

### Check for Balanced Parentheses

### Implement Queue Using Two Stacks

## Recursion Based Questions

### Factorial Using Recursion

### Fibonacci Using Recursion

### Reverse a String Using Recursion

### Tower of Hanoi

## Sorting and Searching

### Binary Search

### Linear Search

### Quick Sort

```java
import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {8, 3, 1, 7, 0, 10, 2};
        System.out.println("Initial Array: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("Final Sorted Array: " + Arrays.toString(array));
    }
}
```

Output:
```
Initial Array: [8, 3, 1, 7, 0, 10, 2]
Final Sorted Array: [0, 1, 2, 3, 7, 8, 10]
```

---

### Merge Sort