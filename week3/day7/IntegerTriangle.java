package week3.day7;

public class IntegerTriangle {

	public int solution(int[][] triangle) {
        int answer = 0;
        
        int N = triangle.length;
        int[][] DP = new int[N][N];
        
        DP[0][0] = triangle[0][0];
        for(int i = 1; i < N; i++) {
            int maxCol = triangle[i].length;
            for(int j = 0; j <= i; j++) {
                int a = -1;
                if(checkCol(i - 1, j - 1, maxCol)) { //왼쪽 위
                    a = DP[i - 1][j - 1];
                }
                
                int b = -1;
                if(checkCol(i - 1, j, maxCol)) { //오른쪽 위
                    b = DP[i - 1][j];
                }
                
                DP[i][j] = triangle[i][j] + Math.max(a, b);
            }
        }
        
        for(int i = 0; i < N; i++) {
            answer = Math.max(DP[N - 1][i], answer);
        }
        
        return answer;
    }
    
    private static boolean checkCol(int row, int col, int maxCol) {
        return (row > -1 && col > - 1 && col < maxCol);
    }

}
