package dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1021 {
	//2번 연산
	private static int left_move(Deque<Integer> dec, int num) {
		int move=0;	//이동 횟수
		while(dec.peek() != num) {	
			move++;
			int temp = dec.poll();
			dec.add(temp);			
		}
		return move;
	}
	
	//3번 연산
	private static int right_move(Deque<Integer> dec, int num) {
		int move=0;	//이동 횟수
		while(dec.peek() != num) {
			move++;
			int temp = dec.pollLast();
			dec.addFirst(temp);
		}
		return move;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());	//큐의 크기
			int M = Integer.parseInt(st.nextToken());	//뽑아내려고 하는 수의 개수
			
			Deque<Integer> dec = new LinkedList<Integer>();
			Deque<Integer> dec_left = new LinkedList<Integer>();
			Deque<Integer> dec_right = new LinkedList<Integer>();
			
			for(int i=1; i<=N; i++) {
				dec.add(i);
			}
			int move = 0;		//2,3번 연산
			
			st = new StringTokenizer(br.readLine(), " ");

			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());	//다음에 뽑아 낼 숫자 위치
				
				for(;;) {
					//left, right dec 복사하기
					for(int j : dec) {
						dec_left.add(j);
						dec_right.add(j);
					}
					
					if(dec.peek() == num) {
						dec.poll(); //원소 뽑아내기
						dec_left.clear();
						dec_right.clear();
						break;
					}else {//dec이 변하지않고 연산을
						
						int left = left_move(dec_left, num);
						int right = right_move(dec_right, num);
						if(left < right) { //2번 실행
							move += left_move(dec, num);
						}else {//3번 실행
							move += right_move(dec, num);
						}
					}
					
					dec_left.clear();
					dec_right.clear();
				}
			}
			
			sb.append(move);
			System.out.println(sb.toString());
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
