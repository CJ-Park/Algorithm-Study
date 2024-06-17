package level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 2023 카카오 블라인드
public class 개인정보_수집_유효기간 {
    class Date {
        int year;
        int month;
        int day;

        public Date(String y, String m, String d) {
            this.year = Integer.parseInt(y);
            this.month = Integer.parseInt(m);
            this.day = Integer.parseInt(d);
        }

        public void addMonth(int m) {
            this.month += m;
            this.day -= 1;

            while (month > 12) {
                this.year += 1;
                this.month -= 12;
            }
        }

        // d 가 더 이전일 경우 true 리턴
        public boolean compareDate(Date d) {
            if (this.year > d.year) {
                return true;
            }

            if (this.year == d.year && this.month > d.month) {
                return true;
            }

            if (this.year == d.year && this.month == d.month && this.day > d.day) {
                return true;
            }

            return false;
        }
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> term = new HashMap<>();
        for (String t : terms) {
            String[] s = t.split(" ");
            term.put(s[0], Integer.parseInt(s[1]));
        }

        Date todayDate = getDate(today);

        for (int i = 1; i <= privacies.length; i++) {
            String[] s = privacies[i - 1].split(" ");
            Date privacyDate = getDate(s[0]);
            int month = term.get(s[1]);

            privacyDate.addMonth(month);

            if (todayDate.compareDate(privacyDate)) {
                list.add(i);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private Date getDate(String date) {
        // . 문자 이스케이프 처리
        String[] s = date.split("\\.");

        return new Date(s[0], s[1], s[2]);
    }
}
