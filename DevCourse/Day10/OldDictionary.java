package DevCourse.Day10;

import java.util.LinkedList;

public class OldDictionary {

	private static StringBuilder sb = new StringBuilder();
	private static boolean[] visited;
	private static LinkedList<Integer>[] graph; 
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//�׽�Ʈ ���̽�
		int num = 5;
		String[] words = {"gg", "kia", "lotte", "lg", "hanwha"};
		//
		
		int size = 'z' - 'a' + 1;

		graph = new LinkedList[size];
		visited = new boolean[size];
		for(int i = 0; i < size; i++) {
			graph[i] = new LinkedList<>();
		}
		
		//1.�־��� �ܾ ������ �׷��� ����
		for(int i = 1; i < num; i++) {
			String a = words[i - 1];
			String b = words[i];
			
			int length = Math.min(a.length(), b.length());
			//*Ȥ�� a, b�� ��� ���λ翡 ���� ���ؾ� �ϴ���??
			for(int j = 0; j < length; j++) {
				if(a.charAt(j) != b.charAt(j)) {
					int charA = a.charAt(j) - 'a';
					int charB = b.charAt(j) - 'a';
					
					graph[charA].add(charB);
					break;
				}
			}
		}
		
		//2.������ ���ĺ��� ���İ��� ����
		for(int i = 1; i < size; i++) {
			if(graph[i - 1].size() > 0) {
				continue;
			}
			graph[i - 1].add(i);
		}
		
		//3.��������
		for(int i = 0; i < size; i++) {
			if(!visited[i]) {
				DFS(i);
			}
		}
		
		System.out.print(sb);
	}
	
	private static void DFS(int start) {
		visited[start] = true;
		
		for(int v : graph[start]) {
			if(!visited[v]) {
				DFS(v);
			}
		}
	
		sb.append((char)('a' + start));
		return;
	}
}
