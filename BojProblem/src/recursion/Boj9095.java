package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//DP(n) = DP(n-1) + DP(n-2) + DP(n-3)
public class Boj9095 {
	static StringBuilder sb = new StringBuilder();
	static 	int NUM=0;

	static void addTest(int n) {
		if(n==3) NUM+=4;
		else if(n==2) NUM+=2;
		else if(n==1) NUM+=1;
		
		if(n>3) {
			addTest(n-1);
			addTest(n-2);
			addTest(n-3);
		}
	}
	
	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			while(T-->0) {
				int n = Integer.parseInt(br.readLine());
				addTest(n);
				sb.append(NUM+"\n");
				NUM=0;
			}
			
			System.out.println(sb.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
