package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2019 카카오 블라인드
public class 실패율 {
    class Fail implements Comparable<Fail> {
        int stage;
        double failure;

        public Fail(int s, double f) {
            this.stage = s;
            this.failure = f;
        }

        public int compareTo(Fail fail) {
            if (this.failure < fail.failure) {
                return 1;
            }

            if (this.failure > fail.failure) {
                return -1;
            }

            return Integer.compare(this.stage, fail.stage);
        }
    }

    public int[] solution(int N, int[] stages) {
        List<Fail> failList = new ArrayList<>();
        int[] count = new int[N + 1];
        int[] result = new int[N];

        int size = stages.length;

        // count - [0, 1, 3, 2, 1, 0]
        for (int i = 0; i < size; i++) {
            int idx = stages[i];

            if (idx > N) {
                continue;
            }

            count[idx]++;
        }

        for (int i = 1; i <= N; i++) {
            if (size == 0) {
                failList.add(new Fail(i, 0));
            } else {
                double failureRate = (double) count[i] / size;
                failList.add(new Fail(i, failureRate));
                size -= count[i];
            }
        }

        Collections.sort(failList);

        for (int i = 0; i < N; i++) {
            Fail fail = failList.get(i);
            result[i] = fail.stage;
        }

        return result;
    }
}
