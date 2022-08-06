package studyWithCathy.algorithm.a_sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortingTheSentence {

    public static String sortSentence(String s) {
        String result = "";
        Map<Integer, String> map = new HashMap<>();
        String[] strArr = s.split(" ");

        for (String str : strArr)
            map.put(Integer.parseInt(String.valueOf(str.charAt(str.length()-1))),
                    str.substring(0, str.length()-1));

        for (int i=1; i<=map.size(); i++)
            result += i == map.size() ? map.get(i) : map.get(i) + " ";

        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/studyWithCathy/algorithm/a_sort/SortingTheSentence.txt"));
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(sortSentence(s));
    }
}
