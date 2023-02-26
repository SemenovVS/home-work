package module11;

import java.util.*;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {

        Stream<Integer> first = Stream.of(1, 2, 3);
        Stream<Integer> second = Stream.of(15,16,17,18, 19, 20, 21, 22,23,24,25,26,27);

        List<Integer> res = zip(first, second)
                .toList();
     }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> result = new ArrayList<>();
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();

        while (iteratorFirst.hasNext() && iteratorSecond.hasNext()){
            result.add(iteratorFirst.next());
            result.add(iteratorSecond.next());
        }
        return result.stream();
    }
}
