package programmers.scoreKit.exhaustiveSearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class PrimeNumber {
    public static LinkedList<Integer> list = new LinkedList<>();

    public static int solution(String numbers) {
        String[] numberArr = new String[numbers.length()];
        int answer = 0;

        for (int i=0; i<numbers.length(); i++) {
            numberArr[i] = String.valueOf(numbers.charAt(i));
        }

        for (int i=0; i< numberArr.length; i++) {
            String number = numberArr[i];
            String idxStr = Integer.toString(i);

            if( isPrimeNumber(Integer.parseInt(number)) && !list.contains(Integer.parseInt(number)))  {
                answer ++;
                list.add(Integer.parseInt(number));
            }
            answer += combination(number, idxStr, numberArr);
        }
        return answer;
    }

    public static int combination(String number, String idx, String[] numberArr) {
        int cnt = 0;
        String newNumber = "";

        for (int i=0; i< numberArr.length; i++) {
            if ( number.contains(numberArr[i]) && idx.contains(Integer.toString(i))) continue;
            if ( list.contains(Integer.parseInt(number + numberArr[i]))) continue;

            newNumber = number + numberArr[i];
            if (isPrimeNumber(Integer.parseInt(newNumber))) {
                cnt++;
                list.add(Integer.parseInt(newNumber));
            }
            cnt += combination(newNumber, idx+Integer.toString(i), numberArr);
        }
        return cnt;
    }

    public static boolean isPrimeNumber(int number) {
        if ( number < 2) return false;
        if ( number == 2 || number == 3 ) return true;

        for (int i=2; i<number; i++) {
            if ( number % i == 0 ) return false;
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/programmers/scoreKit/exhaustiveSearch/PrimeNumber.txt"));
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();

        System.out.println(solution(numbers));
    }
}
