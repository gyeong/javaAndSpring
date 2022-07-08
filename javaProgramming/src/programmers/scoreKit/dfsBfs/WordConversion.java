package programmers.scoreKit.dfsBfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class WordConversion {
    public LinkedList<String> list = new LinkedList<>();
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        for(boolean v : visited) v = false;

        conversion(begin, target, words);
        list.forEach(x -> System.out.println(x));
        return list.size()-1;
    }

    public void conversion(String word, String target, String[] words) {
        list.add(word);
        if ( words.equals(target) ) return;

        for (int i=0; i<words.length; i++) {
            if (list.contains(words[i])) continue;
            if ( isCanChange(word, words[i]) )
                conversion(words[i], target, words);
        }
    }
    public boolean isCanChange(String words, String target) {
        int cnt = 0;
        for (int i=0; i<words.length(); i++) {
            if (words.charAt(i) != target.charAt(i)) cnt++;
        }
        return cnt < 2 ? true : false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/programmers/scoreKit/dfsBfs/WordConversion.txt"));
        Scanner sc = new Scanner(System.in);
        WordConversion obj = new WordConversion();

        String begin = sc.nextLine();
        String target = sc.nextLine();
        String[] words = sc.nextLine().split(" ");
        System.out.println(obj.solution(begin,target,words));
    }
}
