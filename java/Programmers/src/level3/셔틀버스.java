package level3;

/*
분단위 int 배열 생성
0분 ~ 23시59분 == 1439분
해당 분의 idx 에 기다리는 사람 수 저장

1. waiting 배열 확인하면서 버스에 크루 태우기
2. 마지막 버스일 경우 무조건 타야됨

1. 버스는 9시부터 시작
2. t분마다 버스 옴
3. 버스는 총 n개 옴
4. 버스는 m명 태울 수 있음
*/
public class 셔틀버스 {
    int[] waiting = new int[1440];

    public String solution(int n, int t, int m, String[] timetable) {
        for (String time : timetable) {
            String[] s = time.split(":");
            int hour = Integer.parseInt(s[0]);
            int minute = Integer.parseInt(s[1]);

            int idx = hour * 60 + minute;
            waiting[idx]++;
        }

        int busCount = 1;
        int busTime = 540;
        int first = 0;
        int lastTime = 0;

        // 대기자의 시간 ~ 버스 시간 확인
        while (busCount <= n) {
            int takeBus = 0;

            for (int i = first; i <= busTime; i++) { // 해당 버스 시간까지 탐색
                if (waiting[i] > 0) { // 크루원 탑승
                    waiting[i]--;
                    i--;
                    takeBus++;
                }

                lastTime = i;

                if (takeBus == m) { // 버스 만원
                    first = i + 1; // 다음 첫번째 탑승자 idx
                    break;
                }
            }

            busTime += t; // 다음 버스 시간
            busCount++;
        }

        int hour = lastTime / 60;
        int minute = lastTime % 60;
        String res = String.format("%02d:%02d", hour, minute);
        return res;
    }
}
