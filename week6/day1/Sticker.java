package week6.day1;

public class Sticker {

	public int solution(int sticker[]) {
        int answer = 0;

        int size = sticker.length;
        int[] DP = new int[size];
        
        if(size <= 1) {
            return sticker[0];
        }
        
        //ù ��° ��ƼĿ�� ����ϴ� ���
        DP[0] = sticker[0];
        DP[1] = DP[0]; //����: �ڵ����� �� ��° ��ƼĿ�� ����

        for(int i = 2; i < size - 1; i++) {
            DP[i] = Math.max(DP[i - 1], DP[i - 2] + sticker[i]);
        }
        
        int result1 = DP[size - 2];
        
        //������ ��ƼĿ�� ����ϴ� ���
        DP[0] = 0;
        DP[1] = sticker[1];
        
        for(int i = 2; i < size; i++) {
            DP[i] = Math.max(DP[i - 1], DP[i - 2] + sticker[i]);
        }
        
        int result2 = DP[size - 1];

        answer = Math.max(result1, result2);
        
        return answer;
    }

}
