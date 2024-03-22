package Sort.level1;

import java.io.*;
import java.util.*;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        int[] result = new int[size];

        // cut and sort
        for (int i = 0; i < size; i++) {

            // cut
            int a = commands[i][0] - 1;
            int b = commands[i][1] - 1;
            int cnt = commands[i][2] - 1;

            int[] arr = new int[b - a + 1];

            for (int j = a; j <= b; j++) {
                arr[j - a] = array[j];
            }

            // sort
            Arrays.sort(arr);

            // get result
            int res = arr[cnt];
            result[i] = res;
        }

        return result;
    }
}
