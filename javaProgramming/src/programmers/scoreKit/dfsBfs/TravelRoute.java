package programmers.scoreKit.dfsBfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TravelRoute {
    public static boolean[] visited = {};
    public static Queue<String> queue = new LinkedList<>();
    public static Queue<String> list = new LinkedList<>();
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        for (boolean b : visited) b = false;

        queue.add("INC");
        list.add("INC");
        dfs(tickets);

        return list.toArray(new String[0]);
    }

    public void dfs(String[][] tickets) {
        while (!queue.isEmpty()) {
            String ticket = queue.poll();
            String nextTicket = "";
            int newIdx = 0;

            for (int i=0; i<tickets.length; i++) {
                if (tickets[i][0].equals(ticket) && !visited[i]) {
                    if (nextTicket.equals("")) {
                        nextTicket = tickets[i][1];
                        newIdx = i;
                    } else {
                        if (nextTicket.charAt(0) > tickets[i][1].charAt(0)) {
                            nextTicket = tickets[i][1];
                            newIdx = i;
                        }
                    }
                }
            }
            if (nextTicket.equals("")) return;
            visited[newIdx] = true;
            queue.add(nextTicket);
            list.add(nextTicket);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        TravelRoute t = new TravelRoute();
        System.setIn(new FileInputStream("src/programmers/scoreKit/dfsBfs/TravelRoute.txt"));
        Scanner sc = new Scanner(System.in);

        int cnt = Integer.parseInt(sc.nextLine());
        String[][] ticket = new String[cnt][2];

        for (int i=0; i<cnt; i++) {
            ticket[i] = sc.nextLine().split(" ");
        }

        String[] result =(t.solution(ticket));
        for(String str : result) System.out.println(str);
    }

}
