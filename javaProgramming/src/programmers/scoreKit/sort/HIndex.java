package programmers.scoreKit.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class HIndex {
    public static int solution(int[] citations) {
        int answer = 0, sum = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int num:citations) {
            if (num != 0) sum += num;
            list.add(num);
        }

        if ( sum == 0 ) return 0;
        Collections.sort(list);

        for (int i=list.size()-1; i > -1; i--) {
            if ( i+1 == list.get(i)) return i+1;
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
