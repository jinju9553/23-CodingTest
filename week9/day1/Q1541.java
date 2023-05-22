package week9.day1;

import java.io.*;
import java.util.*;

public class Q1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String formula = br.readLine();
		
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<Character> operators = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(formula, "+-");
		while(st.hasMoreTokens()) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < formula.length(); i++) {
			char c = formula.charAt(i);
			if(c == '+' || c == '-') {
				operators.add(c);
			}
		}
		
		int result = 0;
		int numIdx = 0;
		int opeIdx = 0;
		
		//���� ����� �����ϸ�
		if(numbers.size() != operators.size()) {
			result += numbers.get(0);
			numIdx = 1;
		}
		
		//���� Ž���ϸ鼭 ó��
		int multiplier = 1;
		while(numIdx < numbers.size() || opeIdx < operators.size()) {			
			if(operators.get(opeIdx) == '-') {
				multiplier = -1;
			}
			
			result += (numbers.get(numIdx) * multiplier);
			
			numIdx++;
			opeIdx++;
		}
		
		System.out.print(result);
	}

}
