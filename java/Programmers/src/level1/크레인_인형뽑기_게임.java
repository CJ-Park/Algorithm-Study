package level1;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

// 2019 카카오 겨울 인턴십
public class 크레인_인형뽑기_게임 {
    public int solution(int[][] board, int[] moves) {
        HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();
        Stack<Integer> bucket = new Stack<>();
        int deleteCount = 0;

        // board 형태로 map 초기화
        for (int i = 0; i < board.length; i++) {
            map.put(i + 1, new ArrayDeque<>());

            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 0) {
                    continue;
                }
                map.get(i + 1).addLast(board[j][i]);
            }
        }

        // moves 돌면서 인형 꺼내고 before 와 deleteCount 갱신
        for (int idx : moves) {
            if (map.get(idx).isEmpty()) { // 빈 곳에서 뽑을경우 넘기기
                continue;
            }

            int next = map.get(idx).poll();

            if (!bucket.isEmpty() && next == bucket.peek()) {
                bucket.pop();
                deleteCount += 2;
            } else { // 바구니가 비었거나 같은 모양이 겹치지 않을 경우
                bucket.push(next);
            }
        }

        return deleteCount;
    }
}
