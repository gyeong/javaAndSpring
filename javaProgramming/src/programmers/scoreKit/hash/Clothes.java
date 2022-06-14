package com.yoon.programmers.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Clothes {

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }

        System.out.println(map);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue() + 1;
        }

        return answer-1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        sc.nextLine();
        String[][] str = new String[cnt][2];
        for (int i=0; i<cnt; i++) {
            String input = sc.nextLine();
            str[i][0] = input.split(" ")[0];
            str[i][1] = input.split(" ")[1];
        }

        System.out.println(solution(str));
    }
}
