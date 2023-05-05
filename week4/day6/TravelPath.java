package week4.day6;

import java.util.*;

public class TravelPath {

private static final String DEPARTURE = "ICN";
    
    private static boolean[] used;
    private static LinkedList<String> allPaths;
    
    public String[] solution(String[][] tickets) {
        String[] answer;
        
        int size = tickets.length;
        
        used = new boolean[size];
        allPaths = new LinkedList<>();
        
        String path = DEPARTURE + ",";
        
        DFS(tickets, DEPARTURE, size, 0, path);
        
        Collections.sort(allPaths);
        answer = (allPaths.get(0)).split(",");
        
        return answer;
    }
    
    private static void DFS(String[][] tickets, String start, int N, int depth, 
                            String path) { 
        if(N == depth) {
            //완성된 path 하나를 저장
            allPaths.add(path);
            return;
        }
        
        //모든 티켓 정보를 순회
        for(int i = 0; i < tickets.length; i++) {
            String currDeparture = tickets[i][0];
            String currArrival = tickets[i][1];
            
            if(!used[i] && currDeparture.equals(start)) {
                used[i] = true;
                DFS(tickets, currArrival, N, depth + 1, path + currArrival + ",");
                used[i] = false;
            }
        }
        
        return;
    }

}
