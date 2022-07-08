package programmers.scoreKit.dfsBfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Network {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(boolean v : visited) v = false;
        for (int i=0; i<n; i++) {
            if (visited[i] == false) {
                answer++;
                dfs(i, visited, computers);
            }
        }
        return answer;
    }

    public void dfs(int x, boolean[] visisted, int[][] computers) {
        visisted[x] = true;

        for (int i=0; i<computers.length; i++) {
            if (visisted[i] == true) continue;
            if (computers[x][i] != 0) dfs(i, visisted, computers);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/programmers/scoreKit/dfsBfs/Network.txt"));
        Scanner sc = new Scanner(System.in);
        Network network = new Network();

        int n = Integer.parseInt(sc.nextLine());
        int[][] computers = new int[n][n];
        for (int i=0; i<n; i++) {
            computers[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(network.solution(n, computers));
    }
}
