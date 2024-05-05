package BruteForce.level2;

import java.util.HashSet;
import java.util.Set;

// 문자열에서 숫자 조합 재귀로 뽑아내기
public class 소수찾기 {
    static boolean[] visited;
    static boolean[] primeNumber;
    static Set<Integer> numberList = new HashSet<>();

    public int solution(String numbers) {
        int size = numbers.length();
        int res = 0;

        // 1. 나오는 조합들을 배열에 넣기
        // 2. 배열을 돌리면서 소수 판별 진행
        getNumbers("", numbers);

        // 10^size 미만에서 판별 진행 => 범위 내의 소수 저장
        int max = (int)Math.pow(10, size);
        visited = new boolean[max];
        primeNumber = new boolean[max];

        for (int i = 2; i < max; i++) {
            if (visited[i]) {
                continue;
            }
            getPrime(i);
        }

        for (int num : numberList) {
            if (primeNumber[num]) {
                res++;
            }
        }

        return res;
    }

    public void getNumbers(String result, String left) {
        if (!result.equals("")) {
            numberList.add(Integer.parseInt(result));
        }

        for (int i = 0; i < left.length(); i++) {
            getNumbers(result + left.charAt(i),
                    left.substring(0, i) + left.substring(i + 1));
        }
    }

    public void getPrime(int number) {
        int i = 1;
        primeNumber[number] = true;
        while (number * i < primeNumber.length) {
            if (!visited[number * i]) {
                visited[number * i] = true;
            }
            i++;
        }
    }
}
