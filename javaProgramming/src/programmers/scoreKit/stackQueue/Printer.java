package com.yoon.programmers.stackQueue;

import com.yoon.programmers.hash.Participants;

import java.util.*;

public class Printer {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<PrinterEle> list = new LinkedList<>();

        for (int i=0; i<priorities.length; i++) {
            list.add(new PrinterEle(i, priorities[i]));
        }

        while(!list.isEmpty()) {
            PrinterEle element = list.poll();
            int len = list.size();

            for (int i=0; i<list.size(); i++) {
                PrinterEle tmp = list.get(i);
                if (tmp.priority > element.priority) {
                    list.add(element);
                    break;
                }
            }

            if (len != list.size()) continue;
            answer++;
            if (element.pos == location) break;
        }

        return answer;

    }

    public class PrinterEle {
        int pos;
        int priority;

        public PrinterEle (int pos, int priority) {
            this.pos = pos;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        int loc = 0;

        sc.nextLine();
        for (int i=0; i<num; i++) {
            arr[i] = sc.nextInt();
        }

        sc.nextLine();
        loc = sc.nextInt();
        sc.nextLine();

        System.out.println(p.solution(arr, loc));

    }
}
