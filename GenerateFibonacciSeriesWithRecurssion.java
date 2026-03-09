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