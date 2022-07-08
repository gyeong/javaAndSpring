package programmers.scoreKit.dfsBfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WordConversion {
    public static Queue<String> queue = new LinkedList<>();
    public static int[] visited = {};
    public static int minCnt = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new int[words.length];
        queue.add(begin);
        conversion(0, target, words);

        return minCnt;
    }

    public void conversion(int cnt, String target, String[] words) {
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int nextCnt = cnt + 1;

            if ( word.equals(target) ) {
                if ( minCnt == 0 || minCnt > cnt ) minCnt = cnt;
                return;
            }

            for (int i=0; i<words.length; i++) {
                if (isCanChange(word, words[i])) {
                    if (visited[i] == 0 || visited[i] > cnt) {
                        queue.add(words[i]);
                        visited[i] = nextCnt;
                        conversion(nextCnt, target, words);
                    }
                }
            }
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
