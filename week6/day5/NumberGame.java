package week6.day5;

import java.util.Arrays;

public class NumberGame {

	public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int key : A) {
            int result = binarySearch(B, key);
            if(result == -1){
                continue;
            }
            
            if(B[result] > key) {
                answer += 1;
            }
            
            B[result] = -1;
        }
        
        return answer;
    }
    
    public static int binarySearch(int[] B, int key) {
        int start = 0;
        int end = B.length - 1;
        
        int result = Integer.MAX_VALUE; //ÀÎµ¦½º ÀúÀå
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if(B[mid] > key) {
                result = Math.min(result, mid);
                end = mid - 1;
            }
            else { //B[mid] <= key
                start = mid + 1;
            }
        }
        
        if(result == Integer.MAX_VALUE) {
            return -1;
        }
        
        return result;
    }

}
