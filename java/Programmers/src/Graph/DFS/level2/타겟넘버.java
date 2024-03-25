package Graph.DFS.level2;

public class 타겟넘버 {
    int count = 0;

    public int solution(int[] numbers, int target) {
        recur(numbers, target, 0, 0);
        return count;
    }

    public void recur(int[] numbers, int target,
                      int cnt, int res) {
        if (cnt == numbers.length) {
            if (res == target) {
                count++;
            }
            return;
        }

        recur(numbers, target, cnt + 1, res + numbers[cnt]);
        recur(numbers, target, cnt + 1, res - numbers[cnt]);
    }
}
