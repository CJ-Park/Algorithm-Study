package level3.re;

import java.util.HashSet;

// 2019 카카오 인턴
public class 불량_사용자 {
    // 백트래킹 사용
    public String[] users;
    public String[] banned;
    public HashSet<HashSet<String>> res = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        users = user_id;
        banned = banned_id;

        recur(new HashSet<>(), 0);

        return res.size();
    }

    private void recur(HashSet<String> set, int depth) {
        if (depth == banned.length) {
            res.add(set);
            return;
        }

        for (String userId : users) {
            if (set.contains(userId)) {
                continue;
            }

            if (validate(userId, banned[depth])) {
                set.add(userId);
                recur(new HashSet<>(set), depth + 1);
                set.remove(userId);
            }
        }
    }

    private boolean validate(String userId, String banId) {
        if (userId.length() != banId.length()) {
            return false;
        }

        for (int i = 0; i < userId.length(); i++) {
            if (banId.charAt(i) == '*') {
                continue;
            }

            if (userId.charAt(i) != banId.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
