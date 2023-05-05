package week1.day1;

import java.io.*;

public class N1924 { //40분 ~50분 걸림 
	
	public static String[] Week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	public static int MAX_MONTH = 12;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = (br.readLine()).split(" ");
		int targetMonth = Integer.parseInt(temp[0]);
		int targetDay = Integer.parseInt(temp[1]);
		
		int[] lastDays = new int[MAX_MONTH + 1];
		int[] firstDayOfTheWeek = new int [MAX_MONTH + 1];
		
		//1.각 달마다 마지막 날짜 계산
		for(int i = 1; i <= MAX_MONTH; i++) {
			if(i == 2) {
				lastDays[i] = 28;
			}
			else if(i == 4 || i == 6 || i == 9 || i == 11) {
				lastDays[i] = 30;
			}
			else { //1, 3, 5, 7, 8, 10, 12월
				lastDays[i] = 31;
			}
		}
		
		//2.해당 달의 첫번째 요일 결정 => 1월을 기준으로 계산
		firstDayOfTheWeek[1] = 1;
		for(int i = 2; i <= MAX_MONTH; i++) {
			firstDayOfTheWeek[i] = (firstDayOfTheWeek[i - 1] + lastDays[i - 1]) % 7;
		}
		
		//3.구하고자 하는 날짜에 맞는 요일 구하기 => 나머지 연산
		int targetDayOfTheWeek = firstDayOfTheWeek[targetMonth];
		int answer = ((targetDay % 7) + (targetDayOfTheWeek - 1) + 7) % 7;
		System.out.println(Week[answer]);
	}

}
