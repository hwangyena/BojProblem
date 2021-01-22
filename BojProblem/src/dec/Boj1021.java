package dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1021 {
	//2�� ����
	private static int left_move(Deque<Integer> dec, int num) {
		int move=0;	//�̵� Ƚ��
		while(dec.peek() != num) {	
			move++;
			int temp = dec.poll();
			dec.add(temp);			
		}
		return move;
	}
	
	//3�� ����
	private static int right_move(Deque<Integer> dec, int num) {
		int move=0;	//�̵� Ƚ��
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
			
			int N = Integer.parseInt(st.nextToken());	//ť�� ũ��
			int M = Integer.parseInt(st.nextToken());	//�̾Ƴ����� �ϴ� ���� ����
			
			Deque<Integer> dec = new LinkedList<Integer>();
			Deque<Integer> dec_left = new LinkedList<Integer>();
			Deque<Integer> dec_right = new LinkedList<Integer>();
			
			for(int i=1; i<=N; i++) {
				dec.add(i);
			}
			int move = 0;		//2,3�� ����
			
			st = new StringTokenizer(br.readLine(), " ");

			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());	//������ �̾� �� ���� ��ġ
				
				for(;;) {
					//left, right dec �����ϱ�
					for(int j : dec) {
						dec_left.add(j);
						dec_right.add(j);
					}
					
					if(dec.peek() == num) {
						dec.poll(); //���� �̾Ƴ���
						dec_left.clear();
						dec_right.clear();
						break;
					}else {//dec�� �������ʰ� ������
						
						int left = left_move(dec_left, num);
						int right = right_move(dec_right, num);
						if(left < right) { //2�� ����
							move += left_move(dec, num);
						}else {//3�� ����
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
