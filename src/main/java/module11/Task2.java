package module11;


import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Vova", "Vasia", "Petya", "Kolya", "Vlad");
        System.out.println(sortedList(names));
    }
    public static List<String> sortedList (List<String> names){
        return names.stream()
                .sorted((n1, n2) -> n2.compareToIgnoreCase(n1))
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
    }
}