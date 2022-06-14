package com.yoon.programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Participants {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();
        String answer = "";

        for (String item : participant) {
            hash.put(item, hash.getOrDefault(item, 0) + 1);
        }
        for ( String item : completion) {
            hash.put(item, hash.get(item) - 1);
        }

        Iterator<HashMap.Entry<String, Integer>> iter = hash.entrySet().iterator();
        while (iter.hasNext()) {
            HashMap.Entry<String, Integer> tmp = iter.next();
            if ( tmp.getValue() != 0) {
                answer = tmp.getKey();
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Participants p = new Participants();
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();

        System.out.println(p.solution(input1.split(" "), input2.split(" ")));
    }
}
