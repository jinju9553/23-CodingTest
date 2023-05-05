package week6.day2;

import java.util.*;

public class VisitedLength {

	private static int MAX_LENGTH = 5;
    private static int MIN_LENGTH = -5;
    private static int count = 0; //중복 방문 수를 기록
    private static Map<String, Integer> visited = new HashMap<>();
    
    public int solution(String dirs) {
        int answer = 0;
        
        int size = dirs.length();
        
        int x = 0; int y = 0;
        for(int i = 0; i < size; i++) {
            char dir = dirs.charAt(i);
                        
            char oppositeDir = ' ';
            int dx = 0; int dy = 0;
            switch(dir) { //dx, dy 결정
                case 'U': {
                    oppositeDir = 'D';
                    dy = 1;
                    break;
                }
                case 'L': {
                    oppositeDir = 'R';
                    dx = -1;
                    break;
                }
                case 'R': {
                    oppositeDir = 'L';
                    dx = 1;
                    break;
                }
                case 'D': {
                    oppositeDir = 'U';
                    dy = -1;
                    break;
                }
            }
            
            if(!isValidDirection(x + dx, y + dy)) {
                count += 1;
                continue;
            }
            
            visitRoute(x, y, dir);
               
            x = x + dx;
            y = y + dy;
            
            checkSameRoute(x, y, oppositeDir);
        }
        
        answer = size - count;
        
        return answer;
    }
    
    public static void visitRoute(int x, int y, char dir) {
        String key = x + "," + y + "," + dir;
        if(visited.containsKey(key)) {
            count += 1;
        }
        else {
            visited.put(key, 1);
        }
        
        return;
    }
    
    public static void checkSameRoute (int x, int y, char oppositeDir) {
        String key = x + "," + y + "," + oppositeDir;
        
        visited.put(key, 1);
        
        return;
    }
    
    public static boolean isValidDirection(int x, int y) {
        return (x >= MIN_LENGTH && y >= MIN_LENGTH 
                && x <= MAX_LENGTH && y <= MAX_LENGTH);
    }
}
