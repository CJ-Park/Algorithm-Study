package Graph.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// DFS, BFS
// 백트래킹
public class 여행경로 {
    static String[] result;
    static boolean[] useTicket;
    static boolean findResult;

    public String[] solution(String[][] tickets) {
        result = new String[tickets.length + 1];
        useTicket = new boolean[tickets.length];

        Arrays.sort(tickets, Comparator.comparing(t -> t[1]));

        dfs(0, "ICN", tickets, new ArrayList<>());

        return result;
    }

    private void dfs(int count, String start,
                     String[][] tickets, List<String> res) {
        res.add(start);

        // 티켓 다 썼다면 결과 저장 후 리턴
        if (count == tickets.length) {
            for (int i = 0; i <= tickets.length; i++) {
                result[i] = res.get(i);
            }
            findResult = true;
            return;
        }

        // 티켓 확인
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !useTicket[i]) {
                useTicket[i] = true;
                dfs(count + 1, tickets[i][1], tickets, res);
                useTicket[i] = false;
                res.remove(res.size() - 1);
            }

            if (findResult) {
                break;
            }
        }
    }
}
