package com.yoon.programmers.hash;

import java.lang.reflect.Array;
import java.util.*;

public class PhoneNumber {

    public static boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i=0; i<phone_book.length; i++) {
            for (int j=0; j<phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(solution(input.split(" ")));
    }
}
