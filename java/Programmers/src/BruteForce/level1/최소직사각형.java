package BruteForce.level1;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int walletX = 0;
        int walletY = 0;

        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                walletX = Math.max(size[1], walletX);
                walletY = Math.max(size[0], walletY);
            } else {
                walletX = Math.max(size[0], walletX);
                walletY = Math.max(size[1], walletY);
            }
        }

        return walletX * walletY;
    }
}
