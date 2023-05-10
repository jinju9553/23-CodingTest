package week7.day5;

public class Joystick {

	public int solution(String name) {
        int answer = 0;
        
        char[] nameChar = name.toCharArray();
        int size = nameChar.length;
        
        for(char key : nameChar) {
            if(key == 'A') { continue; }
            
            int countFromA = Math.abs(key - 'A');
            int countFromZ = Math.abs('Z' - key) + 1;
            
            int min = Math.min(countFromA, countFromZ);
            
            answer += min;
        }
        
        int forwardCount = size - 1;
        int backwardCount = size - 1;
        for(int i = 0; i < size; i++) {
            int endOfA = i + 1;
            while(endOfA < size && nameChar[endOfA] == 'A') {
                endOfA += 1;
            }
            
            forwardCount = Math.min(i * 2 + (size - endOfA) , forwardCount);
            backwardCount = Math.min((size - endOfA) * 2 + i , backwardCount);
        }
        
        answer += Math.min(forwardCount, backwardCount);
        
        return answer;
    }
}
