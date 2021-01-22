package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Boj15828 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			
			int size = Integer.parseInt(br.readLine());
			Deque<Integer> que = new LinkedList<Integer>();
			int num;
			
			while(true){
				num = Integer.parseInt(br.readLine());
				if(num == -1) break;
				
				//라우터가 패킷 하나 처리
				if(num==0) {
					que.poll();
					continue;
				}
				if(que.size() >= size) continue;
				
				que.add(num);
			};
			if(que.isEmpty()) sb.append("empty");
			while(!que.isEmpty()) {
				sb.append(que.poll()+" ");
			}
			
			System.out.println(sb.toString());
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
