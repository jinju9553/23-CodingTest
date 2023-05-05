package week5.day1;

import java.util.*;
import java.awt.Point;

public class FillWithPuzzle { //*미해결 코드

	private static final int MAX_SIZE = 6; 
    private static boolean[][] visited;
    private static LinkedList<int[][]> blocks;
    
    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        
        int size = table.length;
        visited = new boolean[size][size];
        blocks = new LinkedList<>();
        
        //1.BFS로 모든 블록마다의 dx, dy를 생성한다.
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(table[i][j] == 1 && !visited[i][j]) {
                    int[][] d = BFS(table, i, j);   
                    blocks.add(d);
                }
            }
        }
        
        //2.DFS로 보드판에 블록을 하나씩 끼워본다.
        visited = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(game_board[i][j] == 0 && !visited[i][j]) {
                    //DFS(game_board, i, j);   
                }
            }
        }
        
        return answer;
    }
    
    public static void DFS(int[][] game_board, int startRow, int startCol) {
        visited[startRow][startCol] = true;
        
        //blocks에 맞춰서 퍼즐을 끼운다.
        for(int k = 0; k < blocks.size(); k++) {
            int[][] d = blocks.get(k);
            
            int nx = 0; int ny = 0;
            for(int i = 0; i < d.length; i++) {
                nx = startCol + d[i][0];
                ny = startRow + d[i][1];
                
                if(!checkBound(nx, ny, game_board.length)) {
                    continue;
                }
                
                if(!visited[ny][nx] && game_board[ny][nx] == 0) {
                    //계속 탐색
                }
            }
        }
    }
    
    public static int[][] BFS(int[][] table, int startRow, int startCol) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startCol, startRow));
        visited[startRow][startCol] = true;
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int[][] d = new int[MAX_SIZE][2];
        int dIdx = 0;
        d[dIdx][0] = 0;
        d[dIdx][1] = 0;
        dIdx++;
        
        while(!queue.isEmpty()){
            Point p = queue.poll();
            
            int nx = 0;
            int ny = 0;
            for(int i = 0; i < dx.length; i++) {
                for(int j = 0; j < dx.length; j++) {
                    nx = p.x + dx[i];
                    ny = p.y + dy[i];
                    
                    if(!checkBound(nx, ny, table.length)) {
                        continue;
                    }
                    
                    if(!visited[ny][nx] && table[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        
                        d[dIdx][0] = nx - startCol;
                        d[dIdx][1] = ny - startRow;
                        dIdx++;
                        
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            //while 끝
        }
        
        return d;
    }
    
    public static boolean checkBound(int x, int y, int size) {
        return (x > -1 && y > -1 && x < size && y < size);
    }
    
    public static void rotateBlock() {
        
    }

}
