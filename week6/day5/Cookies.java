package week6.day5;

public class Cookies {

	public int solution(int[] cookie) {
        int answer = 0;
        int size = cookie.length;
        
        for(int m = 0; m < size - 1; m++) {
            int l = m;
            int r = m + 1;
            
            int leftSum = cookie[l];
            int rightSum = cookie[r];
            while(l > -1 && r < size) {
                if(leftSum == rightSum) {
                    answer = Math.max(leftSum, answer);
                }
                
                if(rightSum >= leftSum && l > 0) {
                	//왼쪽 합이 더 크고 인덱스가 범위 내라면
                    l--;
                    leftSum += cookie[l];
                }
                else if(leftSum >= rightSum && r < size - 1) {
                	//오른쪽 합이 더 크고 인덱스가 범위 내라면
                    r++;
                    rightSum += cookie[r];
                }
                else { //주어진 범위 내에서 더이상 합을 구할 수 없다면
                    break;
                }
            }
        }
        
        return answer;
    }

}
