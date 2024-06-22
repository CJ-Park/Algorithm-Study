package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 2022 카카오 블라인드
public class 주차_요금_계산 {
    // 차량번호 순 정렬해서 각 차량의 주차 요금 반환
    public int[] solution(int[] fees, String[] records) {
        // 차량별 주차시간
        HashMap<String, List<Integer>> parkingTime = new HashMap<>();

        // 차량별 총 요금
        HashMap<String, Integer> totalFee = new HashMap<>();
        List<String> cars = new ArrayList<>();

        // 시간 변환 후 저장
        for (String record : records) {
            String[] s = record.split(" ");
            String[] time = s[0].split(":");
            String car = s[1];
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            int totalTime = 60 * hour + minute;

            if (!parkingTime.containsKey(car)) {
                parkingTime.put(car, new ArrayList<>());
            }

            parkingTime.get(car).add(totalTime);
        }

        for (String car : parkingTime.keySet()) {
            cars.add(car);
            List<Integer> timeList = parkingTime.get(car);
            // 출차 기록이 없다면 23:59분 출차처리
            // 23:59 == 1439
            if (timeList.size() % 2 == 1) {
                timeList.add(1439);
            }

            int time = 0;

            // 해당 차량의 주차시간 구하기
            for (int i = timeList.size() - 1; i >= 0; i -= 2) {
                time += timeList.get(i) - timeList.get(i - 1);
            }

            totalFee.put(car, getTotalFee(fees, time));
        }

        Collections.sort(cars);

        int[] result = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            result[i] = totalFee.get(cars.get(i));
        }

        return result;
    }

    // 총 요금 구하기
    private int getTotalFee(int[] fees, int time) {
        // fees[0] : 기본 시간
        // fees[1] : 기본 요금
        // fees[2] : 단위 시간
        // fees[3] : 단위 요금
        int leftTime = time - fees[0];
        if (leftTime <= 0) {
            return fees[1];
        }
        int unitCost = (int) Math.ceil(leftTime * 1.0 / fees[2]);
        return fees[1] + (unitCost * fees[3]);
    }
}
