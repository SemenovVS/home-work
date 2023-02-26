package module11;

import java.util.List;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        int c = 11;
        int m = 2 ^ 48;

        List<Long> result = random(c, m, 0).toList();
        System.out.println("result = " + result);

        List<Long> sortedResult = random(c, m, 0).sorted().toList();
        System.out.println("sortedResult = " +sortedResult);
    }

    public static Stream<Long> random(int c, int m, long seed) {
        long a = 25214903917L;
        return Stream.iterate(seed, x -> (x * a + c) % m)
                .limit(15);
    }
}