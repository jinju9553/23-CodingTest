package second.week2.day3;

import java.util.*;
import java.io.*;

public class SWEA1215 {

	private static final int N = 8;
	private static char[][] matrix;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int len = Integer.parseInt(br.readLine());
			matrix = new char[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					matrix[i][j] = line.charAt(j);
				}
			}

			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					result += checkRowPalindrome(i, j, len);
					result += checkColPalindrome(i, j, len);
				}
			}

			sb.append("#" + test_case + " ").append(result).append("\n");
		}

		System.out.print(sb);
	}

	private static boolean isPalindrome(String str) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			stack.add(str.charAt(i));
		}

		for (int i = 0; i < str.length(); i++) {
			char a = stack.pop();
			char b = str.charAt(i);

			if (a != b) {
				return false;
			}
		}

		return true;
	}

	private static int checkRowPalindrome(int row, int col, int len) {
		StringBuilder sb = new StringBuilder();
		
		for (int j = col; j < col + len; j++) {
			if (col + len > matrix.length) {
				return 0;
			}

			sb.append(matrix[row][j]);
		}
		
		if(isPalindrome(sb.toString())) {
			System.out.println(sb.toString());
			return 1;
		}

		return 0;
	}
	
	private static int checkColPalindrome(int row, int col, int len) {
		StringBuilder sb = new StringBuilder();
		
		//2.세로 회문
		for (int i = row; i < row + len; i++) {
			if (row + len > matrix.length) {
				return 0;
			}

			sb.append(matrix[i][col]);
		}
		
		if(isPalindrome(sb.toString())) {
			System.out.println(sb.toString());
			return 1;
		}

		return 0;
	}
}
