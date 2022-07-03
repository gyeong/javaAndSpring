package programmers.scoreKit.exhaustiveSearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class MockExam {
    public static int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] arr = {};
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        HashMap<Integer, Integer> score = new HashMap<>();
        List<Person> person = new LinkedList<Person>();
        boolean sameFlag = false;

        for (int i=1; i<=3; i++) person.add(new Person(i, 0));
        score.put(0, 0);
        score.put(1, 0);
        score.put(2, 0);

        for (int i=0; i<answers.length; i++) {
            if ( p1[i%p1.length] == answers[i]) person.get(0).score++;
            if ( p2[i%p2.length] == answers[i]) person.get(1).score++;
            if ( p3[i%p3.length] == answers[i]) person.get(2).score++;
        }

        Collections.sort(person);

        for (int i=0; i<person.size(); i++) {
            answer.add(person.get(i).idx);
            if (i < 2 && person.get(i).score == person.get(i+1).score) sameFlag = true;
            else sameFlag = false;

            if (sameFlag) continue;
            else break;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static class Person implements Comparable<Person>{
        int idx;
        int score;

        public Person(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Person o) {
            if (o.score < this.score) return -1;
            else if(o.score > this.score ) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/programmers/scoreKit/exhaustiveSearch/MockExam.txt"));
        Scanner sc = new Scanner(System.in);
        int[] answer = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(answer));
    }
}
