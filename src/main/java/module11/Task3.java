package module11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<String> stringNumbers = Arrays.asList("1, 3, 2", "4, 5");
        String res = stringNumbers.stream()
                .map(numbers -> Arrays.asList(numbers.split(", ")))
                .flatMap(numbers -> numbers.stream())
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(res);
    }
}