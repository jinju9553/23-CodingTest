package DevCourse.Day12;

import java.util.*;
import java.awt.*;

public class ItemFarming {

    public static final int BOUND = 50;
    public static int[][] matrix = new int[BOUND * 2 + 1][BOUND * 2 + 1];
    public static boolean[][] visited = new boolean[BOUND * 2 + 1][BOUND * 2 + 1];
    
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    
    public static int count = 0;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        //1.모든 사각형 표시
        checkRectangle(rectangle);

        //3.BFS 시작
        answer = BFS(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        //늘려놓았던 영역을 다시 줄여준다.
		answer = answer / 4;
        
        return answer;
    }
    
    public static int BFS(int startX, int startY, int targetX, int targetY) {
		Queue<Point> queue = new LinkedList<>();
		int answer = Integer.MAX_VALUE;
        int count = 0;

		queue.add(new Point(startX, startY));
		visited[startY][startX] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
            count += 1;
            
			if (p.x == targetX && p.y == targetY) {
				answer = Math.min(answer, count);
			}

			int nx = 0;
			int ny = 0;
			for (int i = 0; i < dx.length; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];

				if (checkBoundary(nx, ny)) {
					if (visited[ny][nx] == false && matrix[ny][nx] == 1) {
						visited[ny][nx] = true;
						queue.add(new Point(nx, ny));
					}
				}
			}
		}

		return answer;
	}
    
    public static boolean checkBoundary(int x, int y) {
        return (x > -1 && y > -1 && x <= BOUND * 2 && y <= BOUND * 2);
    }
    
    public static void checkRectangle(int[][] rectangle) {
        for(int i = 0; i < rectangle.length; i++) {
            int leftX = rectangle[i][0] * 2;
            int leftY = rectangle[i][1] * 2;
            int rightX = rectangle[i][2] * 2;
            int rightY = rectangle[i][3] * 2;
            
            checkLines(leftX, leftY, rightX, rightY);
        }
        
        //2.겹치는 영역 제거
        for(int i = 0; i < rectangle.length; i++) {
            int leftX = rectangle[i][0] * 2;
            int leftY = rectangle[i][1] * 2;
            int rightX = rectangle[i][2] * 2;
            int rightY = rectangle[i][3] * 2;
            
            checkBlank(leftX, leftY, rightX, rightY);
        }
    }
    
    public static void checkLines(int leftX, int leftY, int rightX, int rightY) {
        for(int i = leftY; i <= rightY; i++) {
            matrix[i][leftX] = 1; //row만 증가, col은 고정
        }
        
        for(int i = leftY; i <= rightY; i++) {
            matrix[i][rightX] = 1; //row만 증가, col은 고정
        }
        
        for(int i = leftX; i <= rightX; i++) {
            matrix[leftY][i] = 1; //col만 증가, row는 고정
        }
        
        for(int i = leftX; i <= rightX; i++) {
            matrix[rightY][i] = 1; //col만 증가, row는 고정
        }
    }
    
    public static void checkBlank(int leftX, int leftY, int rightX, int rightY) {
        //모든 Bound의 안쪽 범위만 비워준다.
        for(int i = leftY + 1; i < rightY; i++) { //1 초과 4 미만
            for(int j = leftX + 1; j < rightX; j++) { //1 초과 7 미만
                matrix[i][j] = 0; 
            }
        }
    }

}
