package DevCourse.Day18;

import java.util.Arrays;

public class Immigration {

	public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        
        long start = times[0];
        long end = times[times.length - 1] * (long)n; //�� ĳ���ÿ� ���� 
        
        while(start <= end) {
            //�����÷ο� �߻� ����(1)
            long mid = start + ((end - start) / 2);
            
            long sum = 0;
            for(int t : times) {
                long numOfPeople = mid / t; //�����÷ο� �߻� ����(2)
                sum += numOfPeople;
            }

            if(sum >= n) { //lower bound�� ã���� ������ ������
                answer = Math.min(answer, mid);
                end = mid - 1;
            }
            else { //(sum < n)
                start = mid + 1;
            }
        }
        
        return answer;
    }

}
