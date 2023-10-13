import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static long start;
	private static long end;
	private static long mul;
	
	private static long[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//1 <= N <= 1_000_000_000
		int N = Integer.parseInt(br.readLine());
		
		start = 1;
		end = N;
		mul = 1;
		
		numbers = new long[10];
        
		if(start == 0) start = 1; 
		while(start <= end) {
			while(start % 10 != 0 && start <= end) {
				calculatePlaces(start);
				start++; 
			}
			
			if(start > end) break;
            
			while(end % 10 != 9 && start <= end) {
				calculatePlaces(end);
				end--; 
			}
			
			long gap = (end / 10) - (start / 10) + 1;
			
			for(int i = 0; i < 10; i++) {
				numbers[i] += (gap * mul);
			}
            
			mul *= 10;
			start /= 10;
			end /= 10;
		}
		
		StringBuilder sb = new StringBuilder();
		for(long n : numbers) {
			sb.append(n).append(" ");
		}
		
		System.out.println(sb);
	}
	
	private static void calculatePlaces(long target) {
		for(long i = target; i > 0; i /= 10) {
			String s = Long.toString(i);
			int digit = s.charAt(s.length() - 1) - '0';
			
			numbers[digit] += mul;
		}
	}
}