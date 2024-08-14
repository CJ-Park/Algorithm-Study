package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
강의실 배정 - 골드5

시작시간 정렬 후 같으면 끝나는 시간 정렬

1 3 / 2 4 / 3 5
3 -> 3 4 -> 4 5

우선순위 큐 두번 이용
1 4 / 2 3 / 3 5
4 -> 3 4 -> 4 5
 */
public class BaekJoon11000 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Lecture(start, end));
        }

        PriorityQueue<Integer> pq_2 = new PriorityQueue<>();
        Lecture first = pq.poll();
        pq_2.add(first.end);

        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();

            if (lecture.start < pq_2.peek()) {
                pq_2.add(lecture.end);
            } else {
                pq_2.poll();
                pq_2.add(lecture.end);
            }
        }

        System.out.println(pq_2.size());
    }

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start > o.start) {
                return 1;
            } else if (this.start == o.start) {
                return this.end - o.end;
            } else {
                return -1;
            }
        }
    }
}
