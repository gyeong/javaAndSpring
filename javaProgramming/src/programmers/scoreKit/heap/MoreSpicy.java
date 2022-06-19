package programmers.scoreKit.heap;

import org.codehaus.groovy.runtime.dgmimpl.arrays.IntegerArrayGetAtMetaMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MoreSpicy {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int item : scoville) pq.add(item);
        while ( !pq.isEmpty() && pq.peek() < K  ) {
            int item = pq.poll();
            if (pq.isEmpty()) return -1;
            else {
                pq.add(item + (pq.poll() * 2));
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        MoreSpicy ms = new MoreSpicy();
        System.setIn(new FileInputStream("src/programmers/scoreKit/heap/MoreSpicy.txt"));
        Scanner sc = new Scanner(System.in);

        int[] scoville = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int K = sc.nextInt();

        System.out.println(ms.solution(scoville, K));
    }
}
