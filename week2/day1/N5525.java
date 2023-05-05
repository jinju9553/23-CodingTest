package week2.day1;

import java.io.*;

public class N5525 {

	public static void main(String args[]) throws IOException { 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

	    int p_num = Integer.parseInt(br.readLine());

	    String p = "";

	    for(int i = 0; i < (p_num * 2) + 1; i++){
	      if(i % 2 == 0) {
	        p += "I";
	      }
	      else {
	        p += "O";
	      }
	    }

	    int s_length = Integer.parseInt(br.readLine());
	    int p_length = p.length();

	    String s = br.readLine();

	    int answer = 0;
	    for(int i = 0; i <= s_length - p_length; i++){
	      if(s.charAt(i) == 'I'){
	        String subString = s.substring(i, i + p_length); //시간 소모 큼

	        if(subString.equals(p)){ //시간 소모 큼
	          answer++;
	        }
	      }
	    }
	    System.out.print(answer);
	  } 

}
