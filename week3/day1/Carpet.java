package week3.day1;

import java.util.ArrayList;

public class Carpet { //카펫

	public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int sum = brown + yellow;
        ArrayList<int[]> result = calculateAllDenominators(sum);
        
        for(int i = 0; i < result.size(); i++) {
            int[] temp = result.get(i);
            
            boolean isCorrect = checkYellowTiles(temp[1], temp[0], yellow);
            if(isCorrect) {
                answer = temp;
            }
        }
        
        return answer;
    }
    
    public static boolean checkYellowTiles(int row, int col, int yellow) {
        int count = 0;
        
        for(int i = 1; i < row - 1; i++){
            for(int j = 1; j < col - 1; j++){
                count += 1;
            }
        }
        
        return (count == yellow);
    }
    
    public static ArrayList<int[]> calculateAllDenominators(int num) {
        ArrayList<int[]> denominator = new ArrayList<>();
        
        for(int i = 1; i <= Math.sqrt(num); i++) { 
            if(num % i == 0) {
                int[] temp = new int[2];
                temp[1] = i;
                temp[0] = num / i; //주의: 제곱수도 카운트 해야 함
                denominator.add(temp); 
            }
        }
        
        return denominator;
    }
}
