package week8.day3;

import java.io.*;
import java.util.*;

public class Q13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] cost = new long[N];
		long[] dist = new long[N - 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
		for(int i = 0; i < N - 1; i++) {
			dist[i] = Long.parseLong(st.nextToken()); 
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cost[i] = Long.parseLong(st.nextToken()); 
		}
		
		long sum = 0;
		long currCost = cost[0];
		sum += currCost * dist[0];
		for(int i = 1; i < N - 1; i++) {
			if(currCost > cost[i]) { //더 싼값에 주유할 수 있다면
				currCost = cost[i];
			}
			sum += currCost * dist[i];
		}
		
		System.out.print(sum);
	}

}
