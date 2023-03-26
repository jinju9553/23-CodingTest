package DevCourse.Day8;

import java.util.*;
import java.awt.Point;

public class GamePath {

	private static boolean[][] visited;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int row = maps.length;
        int col = maps[0].length;
        
        visited = new boolean[row][col];
        
        answer = BFS(maps, 0, 0);
        
        return answer;
    }
    
    private static int BFS(int[][] maps, int startRow, int startCol) {
        Queue<Point> queue = new LinkedList<>();
        
        visited[startRow][startCol] = true;
        queue.add(new Point(startCol, startRow));
        
        int row = maps.length;
        int col = maps[0].length;
        
        int answer = 1;
        while(!queue.isEmpty()) {
            int width = queue.size();
            
            while(width-- > 0) {
                Point p = queue.poll();
            
                if(p.y == row - 1 && p.x == col - 1) {
                    return answer;
                }
            
                int nx = 0;
                int ny = 0;
                for(int i = 0; i < dx.length; i++) {
                    nx = p.x + dx[i];
                    ny = p.y + dy[i];

                    if(!checkBoundary(ny, nx, row, col)) {
                        continue;
                    }

                    if(!visited[ny][nx] && maps[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            answer += 1;
        }
        
        return -1;
    }
    
    private static boolean checkBoundary(int ny, int nx, int row, int col) {
        return (ny > -1 && nx > -1 && ny < row && nx < col);
    }
}
