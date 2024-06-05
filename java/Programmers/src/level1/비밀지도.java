package level1;

// 2018 카카오 블라인드
public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        // arr1 변환, arr2 변환 후 리턴배열에 담아서 반환
        StringBuilder sb = new StringBuilder();
        String[] result = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            String binary1 = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);

            binary1 = String.format("%1$" + n + "s", binary1).replace(' ', '0');
            binary2 = String.format("%1$" + n + "s", binary2).replace(' ', '0');

            for (int j = 0; j < n; j++) {
                if (binary1.charAt(j) == '1' || binary2.charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }

            result[i] = sb.toString();
            sb.setLength(0);
        }

        return result;
    }

    // 더 간단하고 성능좋은 방법 참고
    // String.format 변경 시 위 코드보다 훨씬 좋은 성능인 코드
    // 16자리 포맷 변환 후 substring 자르는 방식 사용
    public String[] solution_2(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        String str;

        for (int i = 0; i < n; i++) {
            str = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
            str = str.substring(str.length() - n);
            str = str.replaceAll("1", "#");
            str = str.replaceAll("0", " ");

            result[i] = str;
        }

        return result;
    }
}
