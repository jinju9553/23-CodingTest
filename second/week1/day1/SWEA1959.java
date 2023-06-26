package second.week1.day1;

import java.io.*;

public class SWEA1959 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] temp = br.readLine().split(" ");
            
			int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);

            int[] A = makeNewArray(N, br.readLine());
            int[] B = makeNewArray(M, br.readLine());
            
            int result = 0;
            if(A.length < B.length) {
            	result = calculateResult(A, B);
            }
            else {
            	result = calculateResult(B, A);
            }
            
            sb.append("#" + test_case + " ").append(result).append('\n');
		}
        
        System.out.print(sb);
	}
    
	public static int calculateResult(int[] smallerArr, int[] biggerArr) {
		int smaller = smallerArr.length;
		int bigger = biggerArr.length;
		int max = -1;
		
		int start = 0; 
        for(int i = 0; i <= bigger - smaller; i++) {
            int sum = 0;
            int range = start + smaller; //탐색할 범위의 끝
            
        	for(int j = start; j < range; j++) { //배열의 최대 길이를 넘는다면 탐색 중단
        		sum += (smallerArr[j - start] * biggerArr[j]);
            }
            max = Math.max(sum, max);
            start++;
        }
		
		return max;
	}
	
    public static int[] makeNewArray(int size, String numberString) {
        int[] arr = new int[size];
        String[] numbers = numberString.split(" ");
        
        for(int i = 0; i < size; i++) {
            int n = Integer.parseInt(numbers[i]);
            arr[i] = n;
        }
        
        return arr;
    }

}
