package Graph.level3;

import java.util.HashSet;
import java.util.Set;

// 유니온 파인드로 해결
public class 네트워크 {
    static int[] parent;

    public int solution(int n, int[][] computers) {
        Set<Integer> set = new HashSet<>();
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // 실제 부모를 가리키고 있지 않을 경우 존재
        // 한번 더 findParent 호출 후 set 에 add
        for (int p : parent) {
            int num = findParent(p);
            set.add(num);
        }

        return set.size();
    }

    public void union(int i, int j) {
        int p1 = findParent(i);
        int p2 = findParent(j);

        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }

    public int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        return findParent(parent[node]);
    }
}
