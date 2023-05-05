package week6.day4;

public class Stations {

	public int solution(int n, int[] stations, int w) {
        int count = 0;

        int lowerBound = 1;
        int upperBound = n;
        for(int s : stations) {
            upperBound = s - w;
            if(lowerBound < upperBound) { //lower~upper사이에 전파가 닿지 않는다면
                count += calculate(lowerBound, upperBound - 1, w);
            }
            lowerBound = s + w + 1;
        }
        
        int size = stations.length;
        if(stations[size - 1] + w < n) { //맨 오른쪽에 남는 부분
            lowerBound = stations[size - 1] + w + 1;
            upperBound = n;
            count += calculate(lowerBound, upperBound, w);
        }

        return count;
    }
    
    public static int calculate(int lowerBound, int upperBound, int w) {
        int dist = upperBound - lowerBound + 1;
        int count = dist / (2 * w + 1);
        
        if(dist % (2 * w + 1) > 0){
            count += 1;
        }
        
        return count;
    }

}
