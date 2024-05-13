import java.time.*;
import java.util.*;

class Solution {

    private Map<String, Car> carMap = new HashMap<String, Car>();

    public int[] solution(int[] fees, String[] records) {

        for (String record : records) {
            String[] splitedRecord = record.split(" ");
            String time = splitedRecord[0];
            String carNumber = splitedRecord[1];
            String action = splitedRecord[2];
            
            if (!carMap.containsKey(carNumber)) {
                carMap.put(carNumber, new Car(carNumber));
            }
            Car car = carMap.get(carNumber);

            if ("IN".equals(action)) {
                car.parking(time); // 입차
            } else {
                car.exit(time); // 출차
            }
        }
        
        List<Car> cars = new ArrayList<>();
        for (String carNumber : carMap.keySet()) {
            cars.add(carMap.get(carNumber));
        }
        Collections.sort(cars); // 정렬
        
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.calcFee(fees);
            answer[i] = car.totalFee;
        }
        return answer;
    }
}

class Car implements Comparable<Car> {

    String carNumber;
    boolean isParking;
    LocalTime parkedAt;

    int totalTime;
    int totalFee;

    public Car(String carNumber) {
        this.carNumber = carNumber;
        this.isParking = false;
        this.totalTime = 0;
        this.totalFee = 0;
    }

    // 입차
    public void parking(String time) {
        isParking = true;
        parkedAt = LocalTime.parse(time);
    }

    // 출차
    public void exit(String time) {
        isParking = false;
        LocalTime exitAt = LocalTime.parse(time);
        int minutes = (int) Duration.between(parkedAt, exitAt).toMinutes();
        totalTime += minutes;
    }

    // 요금 계산
    public void calcFee(int[] fees) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];

        if (isParking) { // 출차가 안된 경우
            exit("23:59"); // 23:59 로 출차 처리
        }

        if (totalTime > 0) { // 주차를 했으면 기본요금 지불
            totalFee += basicFee;
        }
        
        if (totalTime > basicTime) { // 기본시간을 초과한 경우 추가요금 지불
            int fee = (int) (Math.ceil((double) (totalTime - basicTime) / unitTime) * unitPrice); // 올림처리
            totalFee += fee;
        }
    }

    @Override
    public int compareTo(Car o) { // 차량번호 오름차순
        return carNumber.compareTo(o.carNumber);
    }
}