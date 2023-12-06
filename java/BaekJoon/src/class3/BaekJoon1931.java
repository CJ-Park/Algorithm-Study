package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// Comparable / Comparator 구현하는거 연습하기
// 회의실 배정 - 정렬 문제
public class BaekJoon1931 {
    int n;
    ArrayList<Meeting> meetingList = new ArrayList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetingList.add(new Meeting(start, end));
        }

        Collections.sort(meetingList);

        System.out.println(getMeetingCount());
    }

    public int getMeetingCount() {
        int next = 0;
        int count = 0;
        for (Meeting m : meetingList) {
            if (m.start >= next) {
                next = m.end;
                count++;
            }
        }
        return count;
    }

    public class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) return Integer.compare(this.start, o.start);
            return Integer.compare(this.end, o.end);
        }
    }
}
