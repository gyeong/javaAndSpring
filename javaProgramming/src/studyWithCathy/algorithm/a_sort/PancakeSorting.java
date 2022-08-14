package studyWithCathy.algorithm.a_sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PancakeSorting {

    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> rslt = new ArrayList<>();

        for (int x = arr.length, i; x>0; x--) {
            for (i=0; arr[i] != x; i++);
            reverse(arr, i+1);
            rslt.add(i+1);
            reverse(arr, x);
            rslt.add(x);
        }

        return rslt;
    }

    public static void reverse(int[] arr, int x) {
        for (int i=0,j=x-1; i<j; i++,j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/studyWithCathy/algorithm/a_sort/PancakeSorting.txt"));
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(pancakeSort(arr));
    }
}
