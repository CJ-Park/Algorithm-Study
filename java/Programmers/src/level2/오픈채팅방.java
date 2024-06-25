package level2;

import java.util.*;

// 2019 카카오 블라인드
public class 오픈채팅방 {
    private class User {
        public String uid;
        public boolean enter;
        public String nickname;

        public User(String id, boolean enter) {
            this.uid = id;
            this.enter = enter;
        }

        public void changeName(String name) {
            this.nickname = name;
        }
    }

    public String[] solution(String[] record) {
        // Queue에다가 uid + 입장퇴장 기록 저장
        // uid에 해당하는 닉네임 저장
        HashMap<String, String> matchName = new HashMap<>();
        Queue<User> queue = new ArrayDeque<>();
        List<String> res = new ArrayList<>();

        // enter나 leave 일 경우 queue에 저장
        // enter나 change 일 경우 matchName 수정
        for (String str : record) {
            String[] s = str.split(" ");

            if (s[0].equals("Enter")) { // 입장하는 경우
                queue.add(new User(s[1], true));
                matchName.put(s[1], s[2]);
            } else if (s[0].equals("Change")) { // 이름 바꾸는 경우
                matchName.put(s[1], s[2]);
            } else { // 나가는 경우
                queue.add(new User(s[1], false));
            }
        }

        while (!queue.isEmpty()) {
            User user = queue.poll();
            String nickname = matchName.get(user.uid);

            if (user.enter) { // user 입장
                res.add(nickname + "님이 들어왔습니다.");
            } else { // user 퇴장
                res.add(nickname + "님이 나갔습니다.");
            }
        }

        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
