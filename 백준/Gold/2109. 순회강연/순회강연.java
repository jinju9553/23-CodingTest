import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Lecture> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.pay == o2.pay) { 
				return o2.date - o1.date; 
			} 
			return o2.pay - o1.pay; 
		});
		
		String[] temp;
		int maxDate = 0;
		for(int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			
			int pay = Integer.parseInt(temp[0]);
			int date = Integer.parseInt(temp[1]);
			
			maxDate = Math.max(maxDate, date);
			
			pq.add(new Lecture(pay, date));
		}
		
		boolean[] checked = new boolean[maxDate + 1]; 
		
		int answer = 0;
		while(!pq.isEmpty()) {
			Lecture l = pq.poll();
			
			for(int day = l.date; day > 0; day--) {
				if(!checked[day]) {
					checked[day] = true;
					answer += l.pay;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}

class Lecture {
	int pay;
	int date;

	public Lecture(int pay, int date) {
		this.pay = pay;
		this.date = date;
	}
}