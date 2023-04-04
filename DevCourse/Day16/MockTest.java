package DevCourse.Day16;

import java.util.*;

public class MockTest {

	public int[] solution(int[] answers) {
        int[] score = new int[3];
        
        int[][] students = {{1, 2, 3, 4, 5},
                         {2, 1, 2, 3, 2, 4, 2, 5},
                         {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        int max = -1;
        for(int i = 0; i < students.length; i++) {
            int[] student = students[i];
            int length = student.length;
            int idx = 0;
            
            for(int ans : answers) {
                if(idx % length == 0) {
                    idx = idx % length;
                }
                
                if(student[idx] == ans) {
                    score[i]++;
                }
                idx++;
            }
            max = Math.max(score[i], max);
        }

        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < score.length; i++) {
            if(score[i] == max) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
