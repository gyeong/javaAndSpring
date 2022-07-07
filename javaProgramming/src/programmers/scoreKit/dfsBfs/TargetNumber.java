package programmers.scoreKit.dfsBfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class TargetNumber {
    public static int[] dir = {1, -1};
    public static Stack<Integer> stack = new Stack<>();
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(0, numbers, target);
        return answer;
    }

    public static int dfs(int idx, int[] numbers, int target) {
        int answer = 0;

        if (stack.size() == numbers.length) {
            int sum = 0;
            for (int num : stack) {
                sum += num;
            }
            return sum == target ? 1 : 0;
        } else {
            int nextIdx = idx+1;
            for (int dirNum : dir) {
                stack.push(numbers[idx] * dirNum);
                answer += dfs(nextIdx, numbers, target);
                stack.pop();
            }
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/programmers/scoreKit/dfsBfs/TargetNumber.txt"));
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(sc.nextLine());

        System.out.println(solution(numbers, target));
    }
}
