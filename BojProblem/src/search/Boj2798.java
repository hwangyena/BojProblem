package search;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2798 {
	static int choice[] = new int[3];
	static int sum=0;
	
	//select_num : 지금 선택할 카드 번호
	//choice_start : 카드 선택할 수 있는 번호
	static void cardChoice(int[] card, int select_num, int M, int choice_start ) {
		//지금까지 고른 카드 sum 확인
		if(select_num==3) {
//			System.out.printf("card : %d %d %d\n", choice[0], choice[1], choice[2]);
			int all_sum = 0;
			for(int i=0; i<3; i++) all_sum += choice[i];
			
			if(all_sum<=M && sum<all_sum) {
				sum = all_sum;	//최댓값으로 변경
			}
			return;
		}
		
		//카드 선택하기
		for(int i=choice_start; i<card.length; i++) {
			choice[select_num] = card[i];
			
			cardChoice(card, select_num+1, M, i+1);
		}
	}
	
	
	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int card[] = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				card[i] = Integer.parseInt(st.nextToken());
			}

			cardChoice(card, 0, M, 0);
			System.out.println(sum);
			
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
