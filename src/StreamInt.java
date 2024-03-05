import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamInt {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(23);
        intList.add(67);
        intList.add(9);
        intList.add(67);

       double avg =  intList.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
       System.out.println(avg);

       List<String> stringList = Arrays.asList("apple","banana","tender","cat","apple");
       stringList.stream().map(n->n.toUpperCase()).forEach(System.out::println);

       List<String> modifiedList = stringList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("UpperCase: " + modifiedList);

        List<Integer> numList = Arrays.asList(1,2,3,45,6,7,8);
        int sumOfEven = numList.stream().filter(n->n%2==0).mapToInt(Integer::intValue).sum();
        System.out.println("sum of even values = "+sumOfEven);

        int sumOfOdd = numList.stream().filter(n->n%2!=0).mapToInt(Integer::intValue).sum();
        System.out.println("sum of odd numbers = "+ sumOfOdd);

        stringList.stream().distinct().forEach(System.out::println);

        int count = (int)stringList.stream().filter(s -> s.startsWith("a")).count();
        System.out.println(count);

        stringList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
       int secondLargest =  numList.stream().sorted(Comparator.reverseOrder()).skip(1).max(Integer::compare).orElse(null);
        System.out.println(secondLargest);
        System.out.println(numList);
        int secondsmallest =  numList.stream().sorted().skip(1).findFirst().orElse(0);
        System.out.println(secondsmallest);
        System.out.println("--------");
        IntStream.iterate(0,i->i+1).peek(System.out::println).filter(i->i%2==0).limit(3).forEach(System.out::println);

    }
}
