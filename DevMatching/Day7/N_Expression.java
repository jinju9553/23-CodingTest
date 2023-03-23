package DevMatching.Day7;

import java.util.*;

public class N_Expression { //���α׷��ӽ�: N���� ǥ��

	private static final int MAX_N = 9; 
    
    public static void main(String[] args) {
    	
    	// �׽�Ʈ ���̽� ����
    	int N = 5;
    	int number = 12;
    	//
    	
        int answer = -1;
        
        @SuppressWarnings("unchecked")
		Set<Integer> DP[] = new Set[MAX_N + 1]; //�ε��� 1���� 8����
        
        DP[1] = new HashSet<Integer>();
        DP[1].add(N); //���� ���
        
        int sum = N;
        for(int i = 2; i < MAX_N; i++) { //���� N�� ������ ���� iteration
            DP[i] = new HashSet<Integer>();
            Set<Integer> currentSet = DP[i];
            
            //1.N�� i�� ����Ͽ� ����, ����, ����, �������� ��� ����
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
            
            //2.N�� i�ڸ�¥�� �� ����
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
