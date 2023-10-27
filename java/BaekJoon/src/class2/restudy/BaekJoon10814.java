package class2.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 병합정렬 다시 공부하기 => 시간복잡도 NlogN 정렬 알고리즘 구현 다시해보기
// 나이순 정렬
public class BaekJoon10814 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        Person[] tmp = new Person[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

//        // people 배열의 나이 값만 비교하면서 버블정렬 진행 => 시간복잡도 n**2 이므로 시간초과 발생
//        for (int i = 0; i < N - 1; i++) {
//            for (int j = 0; j < N - i - 1; j++) {
//                if(people[j].age > people[j + 1].age) {
//                    Person tmp = people[j];
//                    people[j] = people[j + 1];
//                    people[j + 1] = tmp;
//                }
//            }
//        }

        // 병합정렬 사용
        // 1. 분할해서 정렬하기 => 재귀함수 사용
        // 2. 정렬된 애들 병합하면서 합치기
        mergeSort(0, N - 1, people, tmp);

        for (int i = 0; i < N; i++) {
            sb.append(people[i].age).append(" ").append(people[i].name);
            System.out.println(sb);
            sb.setLength(0);
        }
    }

    void mergeSort(int start, int end, Person[] people, Person[] tmp) {
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid, people, tmp);
            mergeSort(mid + 1, end, people, tmp);
            merging(start, mid, end, people, tmp);
        }
    }

    void merging(int start, int mid, int end, Person[] people, Person[] tmp) {
        for (int i = start; i <= end; i++) {
            tmp[i] = people[i];
        }
        int left = start;
        int right = mid + 1;
        int idx = start;

        while(left <= mid && right <= end) { // 왼쪽, 오른쪽 두 배열 중 하나가 끝나면 끝
            if (tmp[left].age <= tmp[right].age) {
                people[idx] = tmp[left];
                left++;
            } else {
                people[idx] = tmp[right];
                right++;
            }
            idx++;
        }

        if (mid >= left) { // 오른쪽 배열이 끝났는데 왼쪽 배열이 안끝났을 때
            for (int i = 0; i <= mid - left; i++) people[idx + i] = tmp[left + i];
        }
    }

    public class Person {
        int age;
        String name;
        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
