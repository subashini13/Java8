import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        findSecondLargest(arr);

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {4, 5, 6, 7, 8};

        findCommonElement(arr1, arr2);

        int[] revInt = {2, 3, 5, 7, 8};
        findReverse(revInt);

        String[] strings = {"Apple","Avocado","pear","orange"};
        findLongLength(strings);
    }

    private static void findLongLength(String[] strings) {

      int max =   Arrays.stream(strings).mapToInt(String::length).max().orElse(0);

    }

    private static void findReverse(int[] revInt) {

        IntStream.range(0, revInt.length / 2).forEach(i -> {
            int temp = revInt[i];
            revInt[i] = revInt[revInt.length - i - 1];
            revInt[revInt.length - i - 1] = temp;
        });
        System.out.println(Arrays.toString(revInt));

    }

    private static void findCommonElement(int[] arr1, int[] arr2) {

        List<Integer> commonList = Arrays.stream(arr1).filter(n -> Arrays.stream(arr2).anyMatch(arr2Number -> arr2Number == n)).boxed().collect(Collectors.toList());
        System.out.println(commonList);
    }


    private static void findSecondLargest(int[] arr) {
        int secSmallestElmt = Arrays.stream(arr).sorted().distinct().skip(1).findFirst().orElseThrow(() -> new IllegalArgumentException("No secomd largest element"));
        System.out.println(secSmallestElmt);
    }


}