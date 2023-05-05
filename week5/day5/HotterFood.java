package week5.day5;

import java.util.PriorityQueue;

public class HotterFood {

	public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int num : scoville) {
            pq.add(num);
        }

        while(pq.peek() < K) {   
            if(pq.size() <= 1) {
                answer = -1;
                break;
            }
            
            int food1 = pq.poll();
            int food2 = pq.poll();
            int newFood = food1 + (food2 * 2);
            
            pq.add(newFood);
            
            answer += 1;
        }
        
        return answer;
    }

}
