package BruteForce.level1;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3 ,3 ,1 ,1 ,2 ,2, 4, 4, 5, 5};

        int[] res = new int[3];

        res[0] = getAnswerCount(p1, answers);
        res[1] = getAnswerCount(p2, answers);
        res[2] = getAnswerCount(p3, answers);

        int highScore = Math.max(res[0], res[1]);
        highScore = Math.max(highScore, res[2]);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (res[i] == highScore) {
                list.add(i + 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private int getAnswerCount(int[] write, int[] answers) {
        int count = 0;

        for (int i = 0; i < answers.length; i++) {
            if (write[i % write.length] == answers[i]) {
                count++;
            }
        }

        return count;
    }
}
