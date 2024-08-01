package level2.re;

import java.util.ArrayList;
import java.util.List;

// 2019 카카오 블라인드
// 재귀 + 백트래킹 + 구현

/*
후보키의 조건
1. 유일성
2. 최소성
===============================
1. 후보키는 1개부터 선택해가며 검사
2. 등록된 후보키가 포함된 부분은 스킵
3. 포함 안됐다면 검사해가며 중복 발생 시 스킵
*/
public class 후보키 {
    private String[][] map;
    private List<String> usedKey = new ArrayList<>();

    public int solution(String[][] relation) {
        map = relation;

        int columnSize = relation[0].length;

        // 1. 유일성 검사 => 2. 최소성 검사
        for (int i = 1; i <= columnSize; i++) { // 후보키 검사 1개부터 시작
            checkKey(i, 0, new boolean[columnSize], new ArrayList<>(), columnSize);
        }

        for (String key : usedKey) {
            System.out.println(key);
        }

        return usedKey.size();
    }

    // usedKey [1, 3] 키 있다면
    // key 0,1,2 o => 유일성 체크 / 0,1,3 x => 유일성 체크 x / 0,2,3 o / 1,2,3 x
    private void checkKey(int keyCount, int start, boolean[] visited,
                          List<String> key, int keySize) {
        if (keyCount == key.size()) {
            // 최소성 검사 후 유일성 검사 진행
            if (isMin(key) && isUnique(key)) {
                StringBuilder sb = new StringBuilder();
                for (String s : key) {
                    sb.append(s);
                }
                usedKey.add(sb.toString());
            }
            return;
        }

        for (int i = start; i < keySize; i++) {
            if (visited[i]) { // 이미 방문한 컬럼
                continue;
            }

            visited[i] = true;
            key.add(String.valueOf(i));

            checkKey(keyCount, start + 1, visited, key, keySize);

            visited[i] = false;
            key.remove(String.valueOf(i));
        }
    }

    // 최소성 검사
    private boolean isMin(List<String> key) {
        // key에 이미 사용됐던 키값이 전부 포함되면 false 리턴
        // [0], [1, 3]
        // 하나라도 다르면 true 리턴
        for (String used : usedKey) {
            String[] s = used.split("");
            int count = 0;

            for (int i = 0; i < s.length; i++) {
                if(key.contains(s[i])) {
                    count++;
                }
            }

            if (count == s.length) {
                return false;
            }
        }

        return true;
    }

    // 유일성 검사
    private boolean isUnique(List<String> key) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            for (String j : key) {
                int idx = Integer.parseInt(j);
                sb.append(map[i][idx]);
            }

            String s = sb.toString();
            if (list.contains(s)) { // 튜플 중복이 존재함
                return false;
            }
            list.add(s);

            sb.setLength(0);
        }

        return true;
    }
}
