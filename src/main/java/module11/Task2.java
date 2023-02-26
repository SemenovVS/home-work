package module11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader("C:\\Users\\Бублик\\IdeaProjects\\untitled7\\src\\main\\resources\\namesForSort.txt"));
        List<String> array = new ArrayList<>();
        String str;
        while ((str = buff.readLine()) !=null){
            array.add(str.toUpperCase());
        }
        SortUpper sortUpper = new SortUpper();

        List<String> simple = sortUpper.method(array);

    }
}
class SortUpper {
    public List<String> method (List<String> file){
      Collections.sort(file);
      Collections.reverse(file);
        return file;
    }
}
