package week7.day1;

import java.util.*;

public class DualPriorityQueue {
	public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(
            Comparator.reverseOrder());
        
        for(String operation : operations) {
            String[] temp = operation.split(" ");
            
            String operator = temp[0];
            int operand = Integer.parseInt(temp[1]);
            
            if(operator.equals("I")) {
                minPq.add(operand);
                maxPq.add(operand);
            }
            else if(operator.equals("D")) {
                if(minPq.isEmpty()) {
                    continue;
                }
                
                if(operand > 0) { //최댓값 삭제
                    int key = maxPq.poll();
                    minPq.remove(key);
                }
                else { //최솟값 삭제
                    int key = minPq.poll();
                    maxPq.remove(key);
                }
            }
        }
        
        if(minPq.isEmpty()) {
            return answer;
        }
        
        answer[0] = maxPq.poll();
        answer[1] = minPq.poll();
        
        return answer;
    }
}
