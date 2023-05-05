package week6.day3;

public class UsableRectangle {

	public long solution(int w, int h) {
        long answer = 1;
        
        long width = (long) w;
        long height = (long) h;
        
        long totalNumber = width * height;
        long bigger = Math.max(width, height);
        long smaller = Math.min(width, height);
        
        answer = totalNumber - (width + height - gcd(bigger, smaller));
        
        return answer;
    }
    
    public static long gcd(long a, long b) {
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

}
