package dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Boj2161 {
	public static void main(String[] args) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			Deque<Integer> deq = new ArrayDeque<>();
			int N = Integer.parseInt(br.readLine());
			boolean is_throw = true;
			for(int i=1; i<=N; i++) deq.add(i);
			
			while(!deq.isEmpty()) {
				if(is_throw) { //������ ī��
					sb.append(deq.poll()+ " ");
					is_throw = false;
				}
				else {	//�ڷ� �����ϴ� ī��
					is_throw = true;
					int toBack = deq.poll();
					deq.add(toBack);
				}
			}
			System.out.println(sb.toString());
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
