import java.io.*;
import java.util.*;

public class Main { //2164

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //카드의 개수를 읽어감
        
        Queue<Integer> q = new LinkedList<Integer>(); //연결리스트를 활용한 큐 구현 ==> 동적 
        
        for(int i = 1; i <= N; i++){
            q.add(i);
        }
        
        while(q.size() != 1){
            q.poll();
            int a = q.poll();
            q.add(a);
        }
        
        bw.write(q.poll() + "\n");

        bw.flush();
        br.close();
        bw.close();
	} //출처: https://parkhyeokjin.github.io/algorithm/2019/11/03/baekjoon-2164.html
}