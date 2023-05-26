package week9.day3;

import java.io.*;

public class Q9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String explosion = br.readLine();

		int size = input.length();
		int expLength = explosion.length();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < size; i++) {
			char curr = input.charAt(i);
			sb.append(curr);

			int sbLength = sb.length();
			int gap = sbLength - expLength;
			boolean isTwoCharSame = true;
			// ���̰� ũ�ų� ������ (��: "mirkovC4"�� "C4")
			if (sbLength >= expLength) { // �� ���ڿ��� ���빰�� ��
				for (int j = 0; j < expLength; j++) {
					char c1 = sb.charAt(gap + j);
					char c2 = explosion.charAt(j);
					if (c1 != c2) {
						isTwoCharSame = false;
						break;
					}
				}
				
				if (isTwoCharSame) {
					sb.delete(gap, sbLength);
				}
			}
		}

		if (sb.length() == 0) {
			System.out.print("FRULA");
		} else {
			System.out.print(sb);
		}
	}

}
