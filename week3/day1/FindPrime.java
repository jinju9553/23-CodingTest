package week3.day1;

import java.util.*;

public class FindPrime { //소수찾기
	
	private static int count = 0;
    private static int[] items;
    private static int[] bucket;
    private static boolean[] visited;
    
    private static Map<Integer, Integer> map = new HashMap<>();
    
    public static void main(String[] args) {
    	String numbers = "143";
    	
        int answer = 0;
        int length = numbers.length();
        
        char[] temp = numbers.toCharArray();
        
        items = new int[length];
        visited = new boolean[length];
        
        for(int i = 0; i < length; i++) {
            items[i] = temp[i] - '0';
        }
        
        for(int i = 1; i <= length; i++) {
        	bucket = new int[i];
            backTracking(i, 0);
        }
        
        answer = count;
        
        System.out.print(answer);
    }
    
    public static void backTracking(int N, int depth){
        if(depth == N) {
            int sum = 0;
            
            for(int n : bucket) {
                sum *= 10;
                sum += n;
            }
            
            if(isPrime(sum) && !map.containsKey(sum)){
                map.put(sum, 1);
                count++;
            }
            
            return;
        }
        
        //순열
        for(int i = 0; i < items.length; i++){
            if(!visited[i]){
               visited[i] = true;
               
               bucket[depth] = items[i];
               backTracking(N, depth + 1);
               
               visited[i] = false;
            }
        }
        
        return;
    }
    
    public static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        
        if(n == 2){
            return true;
        }
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }

}
