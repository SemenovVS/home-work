package module11;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader("C:\\Users\\Бублик\\IdeaProjects\\untitled7\\src\\main\\resources\\names.txt"));
        List<String> array = new ArrayList<>();
        String str;
       while ((str = buff.readLine()) !=null){
           array.add(str);
       }
Sorted sorted = new Sorted();
List<String> newList = sorted.sort(array);
    }
}
    class Sorted {
        public List<String> sort (List<String> file){
            List<String> newList = file
                    .stream()
                    .filter(x -> {
                        if (x.contains("1") || x.contains("3") || x.contains("5")
                                || x.contains("7") || x.contains("9")) {
                            return true;
                        }
                        return false;
                    })
                    .toList();
        return newList;
        }
    }



