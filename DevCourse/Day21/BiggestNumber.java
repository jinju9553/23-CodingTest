package DevCourse.Day21;

import java.util.*;

public class BiggestNumber {

	public String solution(int[] numbers) {
        String answer = "";
        
        int size = numbers.length;
        String[] modifiedNumbers = new String[size];
        
        //1.배열의 수들을 네 자리 수로 변형하기
        int idx = 0;
        for(int n : numbers) {
            modifiedNumbers[idx] = String.valueOf(n);
            idx++;
        }
        
        //2.정렬하기(String을 비교)
        Arrays.sort(modifiedNumbers, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        if(modifiedNumbers[0].equals("0")) {
            answer = "0";
            return answer;
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s : modifiedNumbers) {
            sb.append(s);
        }
        
        answer = sb.toString();
        
        return answer;
    }

}
