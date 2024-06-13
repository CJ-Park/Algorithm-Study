package level1;

import java.util.HashMap;

// 2020 카카오 인턴
public class 키패드_누르기 {
    static HashMap<Integer, Point> map = new HashMap<>();

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(Point p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }

        public void changePoint(Point p) {
            this.x = p.x;
            this.y = p.y;
        }
    }

    public String solution(int[] numbers, String hand) {
        // 가운데 숫자들만 어떤 손가락인지 확인하면 됨 나머지는 고정
        StringBuilder sb = new StringBuilder();
        Point leftHand = new Point(0, 3);
        Point rightHand = new Point(2, 3);

        mapInit();

        // 1. 가운데 숫자일 경우 숫자를 어떤 손으로 눌렀는지 체크 (거리 확인 필요)
        // 2. 해당 손의 좌표 변경
        for (int num : numbers) {
            Point point = map.get(num);

            if (point.x == 0) { // 좌측 숫자일 경우
                sb.append("L");
                leftHand.changePoint(point);
            }

            if (point.x == 2) { // 우측 숫자일 경우
                sb.append("R");
                rightHand.changePoint(point);
            }

            if (point.x == 1) { // 가운데 숫자일 경우
                int leftDis = leftHand.getDistance(point);
                int rightDis = rightHand.getDistance(point);

                if (leftDis < rightDis) { // 왼쪽손이 더 가까움
                    sb.append("L");
                    leftHand.changePoint(point);
                } else if (leftDis > rightDis) { // 오른손이 더 가까움
                    sb.append("R");
                    rightHand.changePoint(point);
                } else { // 거리가 같음
                    if (hand.equals("right")) {
                        sb.append("R");
                        rightHand.changePoint(point);
                    } else {
                        sb.append("L");
                        leftHand.changePoint(point);
                    }
                }
            }


        }

        return sb.toString();
    }

    private void mapInit() {
        map.put(1, new Point(0, 0));
        map.put(2, new Point(1, 0));
        map.put(3, new Point(2, 0));
        map.put(4, new Point(0, 1));
        map.put(5, new Point(1, 1));
        map.put(6, new Point(2, 1));
        map.put(7, new Point(0, 2));
        map.put(8, new Point(1, 2));
        map.put(9, new Point(2, 2));
        map.put(0, new Point(1, 3));
    }
}
