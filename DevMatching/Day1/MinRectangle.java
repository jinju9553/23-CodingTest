package DevMatching.Day1;

public class MinRectangle { //최소직사각형

	public int solution(int[][] sizes) {
        int answer = 0;
        
        int wMax = Integer.MIN_VALUE;
        int hMax = Integer.MIN_VALUE;
        for(int i = 0; i < sizes.length; i++){
            int w = sizes[i][0];
            int h = sizes[i][1];
            
            if(w < h){
                int temp = w;
                w = h;
                h = temp;
            }
            
            if(w > wMax){
                wMax = w;
            }
            
            if(h > hMax){
                hMax = h;
            }
        }
        
        answer = wMax * hMax;
        
        return answer;
    }
	
}
