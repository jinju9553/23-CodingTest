package second.week3.day2;

import java.util.*;
import java.io.*;

public class SWEA1248 {
	
	private static final int NONE = 0;
	private static final int ROOT = 1;
	
	private static int size = 0;
	private static boolean[] visited;
	private static Node[] tree;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
            String[] temp = br.readLine().split(" ");
            
            int V = Integer.parseInt(temp[0]);
            int E = Integer.parseInt(temp[1]);
            
            int key1 = Integer.parseInt(temp[2]);
            int key2 = Integer.parseInt(temp[3]);
            
            size = 0;
            visited = new boolean[V + 1]; //0은 사용하지 않음
            tree = new Node[V + 1]; //0은 사용하지 않음
            for(int i = 1; i <= V; i++) {
            	tree[i] = new Node();
            }
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < E; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                
                if (tree[parent].leftChild == NONE) { //아직 leftChild가 없다면
                	tree[parent].leftChild = child; //child를 매달아준다.
                }
                else {
                	tree[parent].rightChild = child;
                }
                
                tree[child].parent = parent;
            }
            
            int commonParent = findParent(key1);
            commonParent = findParent(key2);
            
            getSize(commonParent);
            
            sb.append("#" + test_case + " ").append(commonParent + " " + size).append("\n");
		}
        
        System.out.print(sb);
	}
	
	public static void getSize(int node) {
		int left = tree[node].leftChild;
		int right = tree[node].rightChild;

		size++;
		
		if (left != 0) {
			getSize(left);
		}

		if (right != 0) {
			getSize(right);
		}
		
		return;
	}
	
	public static int findParent(int node) {
		int parent = tree[node].parent;
		int commonParent = 0;
		
		if(node != ROOT) {
			if(visited[parent]) {
				return parent;
			}
			
			visited[parent] = true;
			commonParent = findParent(parent);
		}
		
		return commonParent;
	}

}

class Node {
	int parent;
	int leftChild;
	int rightChild;
}