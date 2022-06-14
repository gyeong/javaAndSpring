package com.yoon.programmers.hash;

import com.sun.javafx.collections.SortableList;

import java.util.*;

public class BestAlbum {

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> map1 = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i=0; i<genres.length; i++) {
            map1.put(genres[i], map1.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> keyList = new ArrayList<>(map1.keySet());
        Collections.sort(keyList, ((o1, o2) -> (map1.get(o2).compareTo(map1.get(o1)))));

        for (String key : keyList) {
            HashMap<Integer, Integer> map2 = new HashMap<>();
            for (int i=0; i<genres.length; i++) {
                if ( genres[i].equals(key) ) map2.put(i, plays[i]);
            }
            List<Integer> cntList = new ArrayList<>(map2.keySet());
            Collections.sort(cntList, ((o1, o2) -> (map2.get(o2).compareTo(map2.get(o1)))));

            for (int i=0; i<cntList.size(); i++) {
                if (i == 2) break;
                answerList.add(cntList.get(i));
            }
        }

        answer = new int[answerList.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        int[] plays = new int[input1.split(" ").length];
        for (int i=0; i<plays.length; i++) {
            plays[i] = sc.nextInt();
        }

        System.out.println(solution(input1.split(" "), plays));
    }
}
