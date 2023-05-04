package ssafy.Day2;

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
                count += 1;
                deliverCap += cap;
                pickupCap += cap;
            }

            deliverCap -= deliveries[i]; 
            pickupCap -= pickups[i]; 
            answer += (i + 1) * 2 * count; 
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
