package programmers.scoreKit.heap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DiskController {

    public int solution(int[][] jobs) {
        int answer = 0, count = 0, now = 0, i = 0;

        Arrays.sort(jobs, ((o1, o2) -> o1[0]-o2[0]));
        PriorityQueue<Jobs> pqJobs = new PriorityQueue<>();

        while(count < jobs.length){
            while (i < jobs.length && jobs[i][0] <= now){
                pqJobs.add(new Jobs(jobs[i][0], jobs[i][1]));
                i++;
            }

            if(pqJobs.isEmpty()){
                now = jobs[i][0];
            }else{
                Jobs tmp = pqJobs.poll();
                answer += tmp.processTime + now - tmp.startTime;
                now += tmp.processTime;
                count++;
            }
        }

        return answer/ jobs.length;
    }

    public class Jobs implements Comparable<Jobs>{
        int processTime;
        int startTime;

        public Jobs(int startTime, int processTime) {
            this.processTime = processTime;
            this.startTime = startTime;
        }

        @Override
        public int compareTo(Jobs o) {
            return this.processTime <= o.processTime ? -1 : 1;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        DiskController dc = new DiskController();
        System.setIn(new FileInputStream("src/programmers/scoreKit/heap/DiskController.txt"));
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[][] jobs = new int[count][2];
        sc.nextLine();
        for (int i=0; i<count; i++) {
            String line = sc.nextLine();
            jobs[i][0] = Integer.parseInt(line.split(" ")[0]);
            jobs[i][1] = Integer.parseInt(line.split(" ")[1]);
        }

        System.out.println(dc.solution(jobs));
    }
}
