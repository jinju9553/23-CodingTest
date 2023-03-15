package SWM.Day8;

import java.io.*;

public class N1717 {
	
	private static int[] root; //i번째 값의 루트노드 번호를 저장
	private static int[] rank; //트리의 높이를 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]); //0부터 n까지의 수로 집합이 구성됨
		int m = Integer.parseInt(temp[1]); //이하로 m가지의 연산이 제공됨
		
		root = new int[n + 1];
		rank = new int[n + 1];
		for(int i = 0; i <= n; i++) {
			root[i] = i;
			rank[i] = 0;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			temp = br.readLine().split(" ");
			
			int operation = Integer.parseInt(temp[0]);
			int a = Integer.parseInt(temp[1]);
			int b = Integer.parseInt(temp[2]);
			
			if(operation == 0) {
				union(a, b);
			}
			else if(operation == 1) {
				boolean result = isSameSet(a, b);
				
				if(result) {
					sb.append("YES").append('\n');
				}
				else {
					sb.append("NO").append('\n');
				}
			}
			else {
				continue;
			}
		}
		
		System.out.print(sb);
	}
	
	public static int find(int x) {
		if(root[x] == x) { //루트노드의 조건: 자기 자신을 가리킨다.
			return x;
		}
		else {
			return root[x] = find(root[x]); //부모 노드를 찾아 거슬러 올라가면서, 루트를 옮겨 매단다.
		}
	}
	
	public static void union(int x, int y) {
		x = find(x); //루트 노드의 번호를 찾아서 할당해준다.
		y = find(y);
		
		if(x == y) { //두 값의 루트노드가 같으면(이미 같은 트리 = 같은 집합) 합치지 않는다.
			return;
		}
		
		if(rank[x] < rank[y]) {
			root[x] = y; //x의 루트는 y가 된다.
		}
		else if(rank[x] >= rank[y]) {
			root[y] = x; //y의 루트는 x가 된다.
		}
		
		if(rank[x] == rank[y]) {
			rank[x]++; //트리를 합치고 최대 높이를 1 증가시킨다.
		}
	}
	
	public static boolean isSameSet(int x, int y) {
		x = find(x); //루트 노드의 번호를 찾아서 할당해준다.
		y = find(y);
		
		//부모 노드가 동일하면 같은 집합에 있는 것이다
		return (x == y);
	}

}
