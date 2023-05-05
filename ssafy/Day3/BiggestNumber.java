package ssafy.Day3;

public class BiggestNumber {

	public String solution(String number, int k) {
        String answer = "";
        
        char[] numbers = number.toCharArray();
        int targetLength = numbers.length - k;
        
        int start = 0; 
        int end = numbers.length - (targetLength - 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < targetLength; i++) {
            int max = 0;
            for(int j = start; j < end + i; j++) {
                if(max < numbers[j] - '0') {
                    max = numbers[j] - '0';
                    start = j + 1;
                }
            }
            sb.append(max);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}
