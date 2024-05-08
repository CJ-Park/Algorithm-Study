package Hash.level2;

import java.util.Arrays;

// 정렬없이 이중포문 돌릴 경우 시간초과 발생
// 정렬 후 인접 인덱스간 비교 진행
public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        int size = phone_book.length;

        Arrays.sort(phone_book);

        for (int i = 0; i < size - 1; i++) {
            if (phone_book[i].startsWith(phone_book[i + 1]) ||
                    phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
