package programmers.scoreKit.sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class BiggestNumber {
    public static String solution(int[] numbers) {
        String answer = "", zero = "";
        List<Number> list= new ArrayList<>();
        Boolean chk = false;

        for (int number : numbers) {
            if (number != 0) {
                list.add(new Number(number));
                chk = true;
            } else zero += "0";
        }
        if (!chk) return "0";
        else  Collections.sort(list);

        for (Number number : list ) answer += number.strNumber;

        return answer + zero;
    }

    public static class Number implements Comparable<Number>{
        String strNumber;

        public Number(int number) {
            this.strNumber = Integer.toString(number);
        }

        @Override
        public int compareTo(Number o) {
            String sum1 = o.strNumber + this.strNumber;
            String sum2 = this.strNumber + o.strNumber;

            if ( Integer.parseInt(sum1) > Integer.parseInt(sum2) ) return 1;
            else if ( Integer.parseInt(sum1) < Integer.parseInt(sum2) ) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/programmers/scoreKit/sort/BiggestNumber.txt"));
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(numbers));
    }


}
