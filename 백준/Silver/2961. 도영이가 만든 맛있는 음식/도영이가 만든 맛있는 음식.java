import java.io.*;

public class Main {

	private static int minDiff = Integer.MAX_VALUE;
	private static int N;

	private static int[][] ingredients;
	private static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		ingredients = new int[N][2];
		selected = new boolean[N];

		String[] temp;
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			ingredients[i][0] = Integer.parseInt(temp[0]);
			ingredients[i][1] = Integer.parseInt(temp[1]);
		}

		DFS(0, 1, 0);

		System.out.println(minDiff);
	}

	public static void DFS(int depth, int sour, int bitter) {
		if (depth == N) {
			if(isAllFalse()) { // 공집합은 만들지 않는다.
				return;
			}

			minDiff = Math.min(minDiff, Math.abs(sour - bitter));
			
			return;
		} 
		
		int s = ingredients[depth][0];
		int b = ingredients[depth][1];
		
		selected[depth] = true;
		DFS(depth + 1, sour * s, bitter + b);

		selected[depth] = false;
		DFS(depth + 1, sour, bitter);

		return;
	}

	private static boolean isAllFalse() {
		for(boolean b : selected) {
			if(b == true)
				return false;
		}
		return true;
	}

}
