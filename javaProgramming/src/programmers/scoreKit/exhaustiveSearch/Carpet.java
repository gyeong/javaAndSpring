package programmers.scoreKit.exhaustiveSearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carpet {
    public static int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int x = 0;

        for (int i=3; i<brown/2; i++) {
            if (sum % 3 > 0) continue;
            if ( (i-2) * ((sum/i)-2) == yellow ) {
                x = i;
                break;
            }
        }

        return new int[]{sum/x, x};
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/programmers/scoreKit/exhaustiveSearch/Carpet.txt"));
        Scanner sc = new Scanner(System.in);

        int brown = Integer.parseInt(sc.nextLine());
        int yellow = Integer.parseInt(sc.nextLine());

        System.out.println(solution(brown, yellow));
    }
}
