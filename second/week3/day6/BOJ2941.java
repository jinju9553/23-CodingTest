package second.week3.day6;

import java.io.*;

public class BOJ2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		String[] keys = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i = 0; i < keys.length; i++) {
			if(input.contains(keys[i])) {
				input = input.replace(keys[i], "*");
			}
		}
		System.out.println(input.length());
	}

}
