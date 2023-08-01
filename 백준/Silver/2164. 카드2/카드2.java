import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i = 1; i <= N; i++){
            q.add(i);
        }
        
        while(q.size() != 1){
            q.poll();
            int a = q.poll();
            q.add(a);
        }
        
        System.out.println(q.poll() + "\n");
	}
}
