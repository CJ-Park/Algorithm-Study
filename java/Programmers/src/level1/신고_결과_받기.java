package level1;

import java.util.*;

// 2022 카카오 블라인드
public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Set<String>> reportInfo = new HashMap<>();
        HashMap<String, Integer> messageCount = new HashMap<>();
        List<String> bannedId = new ArrayList<>();
        int[] result = new int[id_list.length];

        // 초기화
        for (String id : id_list) {
            reportInfo.put(id, new HashSet<>());
            messageCount.put(id, 0);
        }

        // reportInfo 에 (신고당한사람, 신고한사람들) 저장
        for (String re : report) {
            String[] s = re.split(" ");
            reportInfo.get(s[1]).add(s[0]);
        }

        // 정지된 사람 저장
        for (String id : id_list) {
            if (reportInfo.get(id).size() >= k) {
                bannedId.add(id);
            }
        }

        for (String ban : bannedId) {
            for (String reporter : reportInfo.get(ban)) {
                messageCount.put(reporter, messageCount.get(reporter) + 1);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            result[i] = messageCount.get(id_list[i]);
        }

        return result;
    }
}
