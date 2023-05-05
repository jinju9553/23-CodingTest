package week7.day2;

public class Delivery {

	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverCap = 0;
        int pickupCap = 0;
        
        for(int i = n - 1; i >= 0 ; i--) {
            if(isFinished(n, deliveries, pickups)) {
                break;
            }

            int count = 0; //창고에 들른 횟수
            while(deliverCap < deliveries[i] || pickupCap < pickups[i]) {
                count += 1; //i번째 집을 다녀간 횟수
                deliverCap += cap;
                pickupCap += cap;
            } //창고에 들러서 적재량만큼 리필(deliverCap)or비우는(pickupCap) 로직.

            deliverCap -= deliveries[i]; 
            pickupCap -= pickups[i]; 
            answer += (i + 1) * 2 * count; //이동 거리를 누적시킨다.
            //count가 0이라면 창고를 들르지 않고 오는 길에 배달&수거한 것이다. 
        }
        
        return answer;
    }
    
    public static boolean isFinished(int n, int[] deliveries, int[] pickups) {
        for(int i = 0; i < n; i++) {
            if(deliveries[i] != 0 || pickups[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
