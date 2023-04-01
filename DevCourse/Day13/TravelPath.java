package DevCourse.Day13;

import java.util.*;

public class TravelPath {

	private static final String departure = "ICN";
    private static boolean[] used;
    private static LinkedList<LinkedList<String>> allPaths;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        int size = tickets.length;
        
        used = new boolean[size];
        allPaths = new LinkedList<LinkedList<String>>();
        LinkedList<String> path = new LinkedList<String>();
        path.add(departure);
        
        DFS(tickets, departure, size, 0, path);
        
        //Collections.sort(allPaths);
        
        return answer;
    }
    
    private static void DFS(String[][] tickets, String start, int N, int depth, 
                            LinkedList<String> path) { 
        if(N == depth) {
            //�ϼ��� path �ϳ��� ����
            allPaths.add(path);
            return;
        }
        
        //��� Ƽ�� ������ ��ȸ
        for(int i = 0; i < tickets.length; i++) {
            String currDeparture = tickets[i][0];
            String currArrival = tickets[i][1];
            
            if(!used[i] && currDeparture.equals(start)) {
                used[i] = true;
                path.add(currArrival);
                
                DFS(tickets, currArrival, N, depth + 1, path);
                
                path.removeLast();
                used[i] = false;
            }
        }
        
        return;
    }

}
