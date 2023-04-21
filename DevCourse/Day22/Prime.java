package DevCourse.Day22;

public class Prime {

	public int solution(int[] nums) {
        int answer = 0;

        int size = nums.length;
        for(int i = 0; i < size; i++) {
            for(int j = i + 1; j < size; j++) {
                for(int k = j + 1; k < size; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if(isPrime(num)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    
    public static boolean isPrime(int num) {
        if(num < 2) {
            return false;
        }
        
        if(num == 2) {
            return true;
        }
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        
        return true;
    }

}
