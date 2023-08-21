import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		int[] times = {300, 60, 10}; //각 버튼마다의 시간을 기록하는 배열
		int[] counts = new int[3]; //각 버튼을 누른 횟수를 기록
		
		//버튼시간이 큰 순서부터 전체 소요 시간에서 뺀다.
		for(int i = 0; i < times.length; i++) {
			if(T >= times[i]) {
				counts[i] = T / times[i]; //times[i]초 버튼으로 누르는 몫을 저장한다.
				T = T % times[i]; //times[i]초를 제한 나머지를 저장한다.
			}
		}
		
		if(T != 0) { //만약 T초를 맞출 수 없다면
			System.out.print(-1); //-1 출력 후 종료한다.
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : counts) {
			sb.append(i + " ");
		}
		
		System.out.println(sb);
	}

}
