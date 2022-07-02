package programmers.scoreKit.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class HIndex {
    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i=0; i<citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/programmers/scoreKit/sort/HIndex.txt"));
        Scanner sc = new Scanner(System.in);

        int[] citations = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(citations));
    }
}
