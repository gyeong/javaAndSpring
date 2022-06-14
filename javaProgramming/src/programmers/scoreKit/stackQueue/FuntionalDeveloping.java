package com.yoon.programmers.stackQueue;

import com.yoon.programmers.hash.Participants;

import java.util.*;

public class FuntionalDeveloping {

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int cnt = 1, beforeData = 0;
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i=progresses.length-1; i>=0; i--) {
            int rest = (100-progresses[i])%speeds[i] == 0 ? 0 : 1;
            stack.push(((100-progresses[i])/speeds[i])+rest);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();

            if ( stack.size() == 0 ) {
                list.add(cnt++);
                break;
            }

            if ( pop >= stack.peek() || (beforeData != 0 && beforeData >= stack.peek())) {
                cnt++;
                beforeData = beforeData < pop ? pop : beforeData;
            } else {
                list.add(cnt++);
                cnt = 1;
            }
        }

        answer = new int[list.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }

        System.out.println(list);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];

        sc.nextLine();
        for (int i=0; i<len; i++) arr1[i] = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<len; i++) arr2[i] = sc.nextInt();

        System.out.println(solution(arr1, arr2));
    }
}
