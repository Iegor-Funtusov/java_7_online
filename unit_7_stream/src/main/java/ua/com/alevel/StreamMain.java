package ua.com.alevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {


//        for (int i = 0; i < list.size(); i++) {
//            Integer integer = list.get(i);
//            integer *= 2;
//            list.set(i, integer);
//        }

//        for (Integer integer : list) {
//            System.out.println("integer = " + integer);
//        }

//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 12, 10, 5, 3);
        List<Integer> evenList = new ArrayList<>();
        List<Integer> evenSortList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (Integer integer : list) {
            if (integer % 2 == 0) {
                evenList.add(integer);
            }
        }

        for (int i = 0; i < evenList.size(); i++) {
            int count = 0;
            for (int i1 = 0; i1 < evenList.size(); i1++) {
                if (evenList.get(i) == evenList.get(i1)) {
                    ++count;
                }
            }
            if (count == 1) {
                evenSortList.add(evenList.get(i));
            }
        }

        Collections.sort(evenSortList);

        System.out.println("evenSortList = " + evenSortList);
//        System.out.println("strings = " + strings);


        System.out.println();

//        Stream<Integer> integerStream = list.stream();


        String integersFilter = list
//        List<String> integersFilter = list
                .stream()
                .distinct()
//                .skip(2)
                .filter(integer -> integer %2 == 0)
                .sorted()
                .map(Object::toString)
                .map(string -> string.concat("!!!"))
                .collect(Collectors.joining());
//                .collect(Collectors.toList());

        System.out.println("integersFilter = " + integersFilter);

        // conver

//        Stream<Integer> evenIntegerStream = integerStream.filter(integer -> integer %2 == 0);

//        evenIntegerStream.forEach(integer -> System.out.println("integer = " + integer));


        // ternal

//        List<Integer> integersFilter = evenIntegerStream.toList();



        // mutable - immutable


        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println("count = " + integers
                .stream()
                .filter(integer -> integer %2 == 0)
                .count());
        System.out.println("min = " + integers
                .stream()
                .filter(integer -> integer %2 == 0)
                .min(Integer::compareTo)
                .get());
        System.out.println("max = " + integers
                .stream()
                .filter(integer -> integer %2 == 0)
                .max(Integer::compareTo)
                .get());

        String s = "vkbh4qh543hvjvvbv754vbbbqc12c,";
        System.out.println("s = " + s);

        int sum = Arrays
                .stream(
                        s.chars()
                                .mapToObj(c -> (char) c)
                                .toArray(Character[]::new))
                .map(String::valueOf)
                .filter(s1 -> s1.matches("[0-9]"))
                .mapToInt(Integer::valueOf)
                .sum();
        System.out.println("sum = " + sum);

        List<String> integers1 = Arrays.asList("1", "4", "7", "4");

        sum = integers1
                .stream()
                .map(el -> Integer.parseInt(el))
                .reduce(0, (a, b) -> a + b);

        System.out.println("sum = " + sum);

        sum = integers1
                .stream()
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);

        System.out.println("sum = " + sum);


        integers1 = Arrays.asList("1", "4", "g", "7", "4");

        sum = integers1
                .stream()
                .distinct()
                .filter(el -> el.matches("[0-9]"))
                .map(Integer::parseInt)
                .reduce(0, MathUtil::sum);

        System.out.println("sum = " + sum);
    }

    private static class MathUtil {
        public static int sum(int a, int b) {
            return a + b;
        }
    }
}
