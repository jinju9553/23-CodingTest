package SWM.Day12;

public class Test {

	//1234, 1 (답이 7 되는 것 하나 (1+2+4))
	//12467, 4
	
	private static final int N = 3;
	private static int answer = 0;
 	private static int[] bucket;
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 4, 6, 7};
		
		System.out.print(solution(nums));
	}
	
	public static int solution(int[] nums) {
		bucket = new int[N];
		
		combination(nums, 0, 0);
		
		return answer;
	}
	
	public static void combination(int[] nums, int lastIndex, int k) {
		if(k == N) {
			int sum = 0;
			for(int n : bucket) {
				sum += n;
				System.out.print(n + "+");
			}
			
			System.out.println();
			
			if(isPrime(sum)) {
				answer++;
			}
			
			return;
		}
		
		for(int i = lastIndex; i < nums.length; i++) {
			bucket[k] = nums[i];
			combination(nums, i + 1, k + 1); 
		}
		
		return;
	}
	
	public static boolean isPrime(int num) {
		
		for(int i = 2; i * i <= num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
