package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class streams {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6);
        List<String> stringList = Arrays.asList("wow","Animesh","Akshay");
        stringList.stream().filter(str->str.startsWith("A")).forEach(System.out::println);
        stringList.stream().sorted().forEach(System.out::println);
        System.out.println(stringList.stream().filter(str->str.length()>5).count());
        System.out.println(stringList.stream().reduce((x,y)->x.length()>y.length()?x:y).get());
        integerList.stream().filter(num->num%2!=0).forEach(System.out::println);
        System.out.println(integerList.stream().mapToInt(i->i).reduce((x,y)->x*y).getAsInt());
        System.out.println("Max number from integer list" + integerList.stream().mapToInt(e->e).average());
        Map<Character, Long> collect1 = "lolkesh".chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet().stream().filter(map->map.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("2nd highest element"+integerList.stream().sorted(Comparator.reverseOrder()).mapToInt(i->i).skip(1).findFirst());
        stringList.stream().filter(str->str.contentEquals(new StringBuilder(str).reverse())).forEach(System.out::println);
    }
}
