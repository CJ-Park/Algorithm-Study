package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 2018 카카오 블라인드
public class 파일명_정렬 {
    public class MyFile implements Comparable<MyFile> {
        String head;
        int number;
        int idx;

        public MyFile(String head, int num, int idx) {
            this.head = head;
            this.number = num;
            this.idx = idx;
        }

        public int compareTo(MyFile file) {
            if (this.head.equals(file.head)) { // head 값이 같은 경우
                return this.number - file.number;
            } else { // head 값이 다를 경우
                return this.head.compareTo(file.head);
            }
        }
    }

    public String[] solution(String[] files) {
        String[] result = new String[files.length];
        List<MyFile> sortedList = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            MyFile file = convertType(files[i], i);
            sortedList.add(file);
        }

        Collections.sort(sortedList);

        for (int i = 0; i < sortedList.size(); i++) {
            result[i] = files[sortedList.get(i).idx];
        }

        return result;
    }

    public MyFile convertType(String file, int idx) {
        int numberStartIdx = -1;
        int numberEndIdx = -1;
        int count = 0;

        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                numberStartIdx = i;
                break;
            }
        }

        for (int i = numberStartIdx; i < file.length(); i++) {
            if (!Character.isDigit(file.charAt(i)) || count > 5) {
                numberEndIdx = i;
                break;
            }

            if (i == file.length() - 1) {
                numberEndIdx = file.length();
            }
            count++;
        }

        String head = file.substring(0, numberStartIdx).toLowerCase();
        String num = file.substring(numberStartIdx, numberEndIdx);
        int number = Integer.parseInt(num);

        return new MyFile(head, number, idx);
    }
}
