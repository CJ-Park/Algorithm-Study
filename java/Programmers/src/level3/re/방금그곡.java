package level3.re;

import java.util.HashMap;

// 2018 카카오 블라인드
public class 방금그곡 {
    // 0. 각각의 음악에 대해 확인 필요 (최대 100개)
    // 0-1. #이 붙은 음정은 모두 소문자로 변환 - v
    // 1. 몇분동안 재생됐는지 구하기 - v
    // 2. 악보를 재생시간까지 늘려나가며 m과 비교 - v
    // 3. 반환값의 재생시간을 저장 => 조건에 만족하는 더 긴 재생시간 음악이 있다면 갱신. - v
    // 3-1. 재생시간이 같다면 넘기기 - v
    // 4. 만족하는 음악이 없으면 "(None)" 반환 - v
    private HashMap<String, String> map = new HashMap<>();

    public String solution(String m, String[] musicinfos) {
        int resultPlayTime = 0;
        String resultTitle = "";
        initMap();

        for (String key : map.keySet()) {
            m = m.replaceAll(key, map.get(key));
        }

        for (String music : musicinfos) {
            String[] s = music.split(",");

            String start = s[0];
            String end = s[1];
            int playTime = getPlayTime(start, end);

            for (String key : map.keySet()) { // 변환
                s[3] = s[3].replaceAll(key, map.get(key));
            }

            if (checkMusic(m, playTime, s[3])) { // 조건 만족
                if (resultPlayTime < playTime) { // 더 긴 재생시간
                    resultPlayTime = playTime;
                    resultTitle = s[2];
                }
            }
        }

        return resultTitle.equals("") ? "(None)" : resultTitle;
    }

    private void initMap() {
        map.put("C#", "c");
        map.put("D#", "d");
        map.put("F#", "f");
        map.put("G#", "g");
        map.put("A#", "a");
        map.put("B#", "b");
    }

    // part를 반복해서 playTime만큼 늘려나가며 m보다 길어졌을 때부터 비교
    private boolean checkMusic(String m, int playTime, String part) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < playTime; i++) {
            if (i < part.length()) {
                sb.append(part.charAt(i));
            } else {
                sb.append(part.charAt(i % part.length()));
            }

            if (sb.length() >= m.length() && sb.toString().contains(m)) {
                return true;
            }
        }
        return false;
    }

    private int getPlayTime(String start, String end) {
        String[] s1 = start.split(":");
        String[] s2 = end.split(":");

        int endHour = Integer.parseInt(s2[0]);
        int endMinute = Integer.parseInt(s2[1]);
        int startHour = Integer.parseInt(s1[0]);
        int startMinute = Integer.parseInt(s1[1]);

        int time1 = endHour - startHour;

        if (startHour != 0 && endHour == 0) {
            time1 = 24 - startHour;
        }

        return time1 * 60 + endMinute - startMinute;
    }
}
