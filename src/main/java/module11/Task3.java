package module11;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        String[] arrOfNumbers = {"1, 2, 0","4, 5"};

    Sort sort = new Sort ();
    sort.methodOfSort(arrOfNumbers);
        String result = sort.methodOfSort(arrOfNumbers);

        System.out.println(result);
    }

}
class Sort{
    public String methodOfSort(String [] file){
        List<String> str = new ArrayList<>();
        String res = "";
        for (int i = 0; i < file.length; i++) {
            if (file[i].length()>1){
                for (int j = 0; j < file[i].length(); j++) {
                    if (file[i].charAt(j) == ' ' || file[i].charAt(j) == ',') {

                    }
                    else {
                        str.add(String.valueOf(file[i].charAt(j)));
                    }
                }
                continue;
            }
                if (file[i].startsWith(" ") || file[i].startsWith(",")) {

                } else {
                    str.add(file[i]);
                }
            }

        for (int i = 0; i < str.size(); i++) {
            res += str.get(i)+",";

        }
        return res.substring(0,res.length()-1);
    }
}
