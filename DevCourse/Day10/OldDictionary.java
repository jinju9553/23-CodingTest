package DevCourse.Day10;

import java.util.LinkedList;

public class OldDictionary {

	private static StringBuilder sb = new StringBuilder();
	private static boolean[] visited;
	private static LinkedList<Integer>[] graph; 
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//테스트 케이스
		int num = 5;
		String[] words = {"gg", "kia", "lotte", "lg", "hanwha"};
		//
		
		int size = 'z' - 'a' + 1;

		graph = new LinkedList[size];
		visited = new boolean[size];
		for(int i = 0; i < size; i++) {
			graph[i] = new LinkedList<>();
		}
		
		//1.주어진 단어를 가지고 그래프 생성
		for(int i = 1; i < num; i++) {
			String a = words[i - 1];
			String b = words[i];
			
			int length = Math.min(a.length(), b.length());
			//*혹시 a, b의 모든 접두사에 대해 비교해야 하는지??
			for(int j = 0; j < length; j++) {
				if(a.charAt(j) != b.charAt(j)) {
					int charA = a.charAt(j) - 'a';
					int charB = b.charAt(j) - 'a';
					
					graph[charA].add(charB);
					break;
				}
			}
		}
		
		//2.나머지 알파벳의 선후관계 생성
		for(int i = 1; i < size; i++) {
			if(graph[i - 1].size() > 0) {
				continue;
			}
			graph[i - 1].add(i);
		}
		
		//3.위상정렬
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
