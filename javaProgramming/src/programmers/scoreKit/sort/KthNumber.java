package programmers.scoreKit.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class KthNumber {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int cnt = 0;

        for (int[] command : commands) {
            List<Integer> list = new ArrayList<>();
            for (int i=command[0]-1; i<command[1]; i++) list.add(array[i]);
            Collections.sort(list);
            answer[cnt] = list.get(command[2]-1);
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/programmers/scoreKit/sort/KthNumber.txt"));
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = Integer.parseInt(sc.nextLine());
        int[][] commands = new int[length][3];
        for (int i=0; i<length; i++) {
            commands[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution(array, commands));
    }
}
