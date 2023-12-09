package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나무 자르기 - 이분탐색
// 이분탐색 문제는 항상 조건문 경계값 어떻게 나눌지 고민할 것
public class BaekJoon2805 {
    int n, m;
    long res;
    int[] trees;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new int[n];

        // 나무들 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees); // 나무 정렬
        findMaxHeight(0, trees[n - 1]); // 가운데 높이부터 잘라보며 탐색

        System.out.println(res);
    }

    public void findMaxHeight(long startHeight, long endHeight) {
        // 두 파라미터 중 하나는 -1 또는 +1 되어서 들어오므로 start == end 인 경우 한번은 실행을 해야 됨
        // => 즉 리턴 조건은 start > end 로 설정
        if (startHeight > endHeight) return;

        long midHeight = (startHeight + endHeight) / 2;
        long sumCut = cutTree(midHeight); // 잘라서 나온 나무 길이 합

        // 적어도 m 만큼은 가져가야됨 -> sumCut >= m 나왔을 때의 최대 높이 (midHeight) 값
        // start == end 가 될때까지 전부 다 탐색해야됨
        if (sumCut >= m) {
            res = Math.max(res, midHeight);
            findMaxHeight(midHeight + 1, endHeight);
        } else { // sumCut < m 일 때는 midHeight 보다 낮은 높이를 가져야 됨
            findMaxHeight(startHeight, midHeight - 1);
        }
    }

    public long cutTree(long midHeight) {
        long result = 0;
        for (int treeHeight : trees) {
            if (treeHeight > midHeight) {
                result += treeHeight - midHeight;
            }
        }
        return result;
    }
}
