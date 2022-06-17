package programmers.scoreKit.stackQueue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Stock {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();

        for ( int price : prices ) queue.add(price);
        while ( !queue.isEmpty() ) {
            int price = queue.poll(), cnt = 0;

            for (int nextPrice : queue) {
                cnt++;
                if ( nextPrice < price ) {
                    break;
                }
            }
            answer[idx] = cnt;
            idx++;
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Stock stock = new Stock();
        System.setIn(new FileInputStream("src/programmers/scoreKit/stackQueue/Stock.txt"));
        Scanner sc = new Scanner(System.in);

        int[] prices = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(stock.solution(prices));
    }
}
