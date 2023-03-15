package SWM.Day8;

import java.io.*;

public class N1717 {
	
	private static int[] root; //i��° ���� ��Ʈ��� ��ȣ�� ����
	private static int[] rank; //Ʈ���� ���̸� ����

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]); //0���� n������ ���� ������ ������
		int m = Integer.parseInt(temp[1]); //���Ϸ� m������ ������ ������
		
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
		if(root[x] == x) { //��Ʈ����� ����: �ڱ� �ڽ��� ����Ų��.
			return x;
		}
		else {
			return root[x] = find(root[x]); //�θ� ��带 ã�� �Ž��� �ö󰡸鼭, ��Ʈ�� �Ű� �Ŵܴ�.
		}
	}
	
	public static void union(int x, int y) {
		x = find(x); //��Ʈ ����� ��ȣ�� ã�Ƽ� �Ҵ����ش�.
		y = find(y);
		
		if(x == y) { //�� ���� ��Ʈ��尡 ������(�̹� ���� Ʈ�� = ���� ����) ��ġ�� �ʴ´�.
			return;
		}
		
		if(rank[x] < rank[y]) {
			root[x] = y; //x�� ��Ʈ�� y�� �ȴ�.
		}
		else if(rank[x] >= rank[y]) {
			root[y] = x; //y�� ��Ʈ�� x�� �ȴ�.
		}
		
		if(rank[x] == rank[y]) {
			rank[x]++; //Ʈ���� ��ġ�� �ִ� ���̸� 1 ������Ų��.
		}
	}
	
	public static boolean isSameSet(int x, int y) {
		x = find(x); //��Ʈ ����� ��ȣ�� ã�Ƽ� �Ҵ����ش�.
		y = find(y);
		
		//�θ� ��尡 �����ϸ� ���� ���տ� �ִ� ���̴�
		return (x == y);
	}

}
