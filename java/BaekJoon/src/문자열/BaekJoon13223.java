package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소금 폭탄
public class BaekJoon13223 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int now = getSeconds(br.readLine());
        int end = getSeconds(br.readLine());
        int gap;

        if (end <= now) {
            gap = end - now + 3600 * 24;
        } else {
            gap = end - now;
        }

        String result = getTime(gap);
        System.out.println(result);
    }

    private String getTime(int seconds) {
        int hour = seconds / 3600;
        seconds = seconds % 3600;

        int minute = seconds / 60;
        seconds = seconds % 60;

        return String.format("%02d:%02d:%02d", hour, minute, seconds);
    }

    private int getSeconds(String input) {
        String[] arr = input.split(":");
        int time = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) { // 시간
                time += Integer.parseInt(arr[i]) * 3600;
            } else if (i == 1) { // 분
                time += Integer.parseInt(arr[i]) * 60;
            } else {
                time += Integer.parseInt(arr[i]);
            }
        }

        return time;
    }
}
