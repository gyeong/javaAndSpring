package programmers.scoreKit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/12905
public class BiggestSquare {

    public int solution(int [][]board) {
        {
           int answer = 1;
           int h = board.length;
           int w = board[0].length;
           int[][] map = new int[h+1][w+1];

           for (int i=0; i<board.length; i++)
               for (int j=0; j<board.length; j++)
                   map[i+1][j+1] = board[i][j];

           for (int i=1; i<h+1; i++) {
               for (int j=0; j<w+1; j++) {
                   if (map[i][j] != 0) { // 0이 아닌 경우에 한해서, 최소를 찾는다
                       map[i][j] = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]) + 1;
                       answer = Math.max(answer, map[i][j]); // 최대값 갱신
                   }
               }
           }
            return answer * answer;
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/programmers/scoreKit/BiggestSquare.txt"));
        Scanner sc = new Scanner(System.in);
        BiggestSquare b = new BiggestSquare();

        int n = Integer.parseInt(sc.nextLine());
        int[][] board = new int[n][n];
        for (int i=0; i<n; i++) {
            board[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(b.solution(board));
    }
}
