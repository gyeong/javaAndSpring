package programmers.scoreKit.stackQueue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Truck {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int totalWeight = 0;
        Queue<TruckObj> queue = new LinkedList<TruckObj>();
        Queue<TruckObj> bridge = new LinkedList<TruckObj>();

        for (int truck : truck_weights) queue.add(new TruckObj(truck, 0));

        totalWeight += queue.peek().weight;
        bridge.add(queue.poll());

        while (!bridge.isEmpty()) {
            answer ++;
            bridge.forEach( truck -> truck.step++ );

            if ( bridge.peek().step + 1 > bridge_length ) {
                totalWeight -= bridge.peek().weight;
                bridge.poll();
            }

            if ( queue.size() != 0 ) {
                if ( totalWeight + queue.peek().weight > weight ) continue;
                totalWeight += queue.peek().weight;
                bridge.add(queue.poll());
            }
        }

        return answer;
    }

    public static class TruckObj {
        int weight;
        int step;

        public TruckObj(int weight, int step) {
            this.weight = weight;
            this.step = step;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/programmers/scoreKit/stackQueue/Truck.txt"));
        Scanner sc = new Scanner(System.in);

        int bridge_length = sc.nextInt();
        int weight = sc.nextInt();
        sc.nextLine();
        int[] truck_weight = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution(bridge_length, weight, truck_weight));

    }
}
