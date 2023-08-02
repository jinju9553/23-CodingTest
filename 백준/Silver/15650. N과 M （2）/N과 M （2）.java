import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());
		
		int[] items = new int[N];
		int[] bucket = new int[M];
		
		for(int i = 0; i < N; i++)
			items[i] = (i + 1);
		
		solution(items, bucket, M);
		System.out.println(sb);
	}

	public static void solution(int[] items, int[] bucket, int k) { 
		
		if (k == 0) { 
			for (int i = 0; i < bucket.length; i++)
				sb.append(bucket[i]).append(' ');
			sb.append('\n');
			return;
		}
		
		int lastIndex = bucket.length - k - 1;
		
		for (int i = 0; i < items.length; i++) 
		{
			if(bucket.length == k) { 
				bucket[0] = items[i];
				solution(items, bucket, k - 1);
			}
			else if (bucket[lastIndex] < items[i]) { 
				bucket[lastIndex + 1] = items[i]; 
				solution(items, bucket, k - 1);
			}
		}
	}
}