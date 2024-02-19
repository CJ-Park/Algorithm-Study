package DP.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 전깃줄 - dp / LIS (최장 증가 부분 수열)
// 아이디어 - 최소 삭제 전선 개수 = 전체 전선 - 최대 연결 전선
public class BaekJoon2565 {
    int n, res, maxConnect; // 전기줄 개수, 결과, 전선 최대연결 개수
    final int MAX = 501;
    List<Integer> startIdx = new ArrayList<>(); // 시작 전기줄 번호 true / 최대 500이하
    int[] line;
    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        line = new int[MAX];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            startIdx.add(start);
            line[start] = end;
        }

        // 오름차순 정렬
        Collections.sort(startIdx);

        // 최소 삭제할 전선 개수 = 전체 전선 개수 - 최대 연결 전선 개수
        // 최대 연결 가능한 전선 개수 구해서 n 에서 빼주면 됨
        for (int i = 0; i < n; i++) {
            maxConnect = Math.max(maxConnect, checkLine(i));
        }
        res = n - maxConnect;

        System.out.print(res);
    }

    // 재귀 - 탑다운 방식
    public int checkLine(int idx) {
        // 탐색 안했을 경우
        if (dp[idx] == 0) {
            dp[idx] = 1;

            // 시작 인덱스 이후의 전기줄 연결 정보 비교
            for (int i = idx + 1; i < n; i++) {

                // startIdx 전깃줄이 연결된 위치보다 커야 연결 가능
                if (line[startIdx.get(idx)] < line[startIdx.get(i)]) {

                    // 연결 가능할 경우 이후 연결된 전깃줄 확인 결과 + 1 과 비교해서 더 큰 경우를 저장
                    dp[idx] = Math.max(dp[idx], checkLine(i) + 1);
                }
            }
        }
        return dp[idx];
    }
}
