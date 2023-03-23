package DevMatching.Day7;

import java.util.*;

public class N_Expression { //프로그래머스: N으로 표현

	private static final int MAX_N = 9; 
    
    public static void main(String[] args) {
    	
    	// 테스트 케이스 수정
    	int N = 5;
    	int number = 12;
    	//
    	
        int answer = -1;
        
        @SuppressWarnings("unchecked")
		Set<Integer> DP[] = new Set[MAX_N + 1]; //인덱스 1부터 8까지
        
        DP[1] = new HashSet<Integer>();
        DP[1].add(N); //기저 사례
        
        int sum = N;
        for(int i = 2; i < MAX_N; i++) { //사용된 N의 개수에 따라 iteration
            DP[i] = new HashSet<Integer>();
            Set<Integer> currentSet = DP[i];
            
            //1.N을 i개 사용하여 덧셈, 뺄셈, 곱셈, 나눗셈한 결과 저장
            for(int j = 1; j < i; j++) {
            	Set<Integer> prevSet1 = DP[i - j];
            	Set<Integer> prevSet2 = DP[j];
            	
            	for (int p1 : prevSet1) {
            		for(int p2 : prevSet2) {
            			currentSet.add(p1 + p2);
            			currentSet.add(p1 - p2);
            			currentSet.add(p1 * p2);
            			
            			if(p1 != 0 && p2 != 0) {
            				currentSet.add(p1 / p2);
            			}
            		}
            	}
            } 
            
            //2.N의 i자리짜리 수 저장
            sum = (sum * 10) + N;
            currentSet.add(sum);
        }
        
        for(int i = 1; i < MAX_N; i++) {
        	Set<Integer> currentSet = DP[i];
        	for(int n : currentSet) {
        		if(n == number) {
        			answer = i;
        			break;
        		}
        	}
        	
        	if(answer != -1) {
        		break;
        	}
        }
        
        System.out.print(answer);
    }

}
