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
                	//���� ���� �� ũ�� �ε����� ���� �����
                    l--;
                    leftSum += cookie[l];
                }
                else if(leftSum >= rightSum && r < size - 1) {
                	//������ ���� �� ũ�� �ε����� ���� �����
                    r++;
                    rightSum += cookie[r];
                }
                else { //�־��� ���� ������ ���̻� ���� ���� �� ���ٸ�
                    break;
                }
            }
        }
        
        return answer;
    }

}
