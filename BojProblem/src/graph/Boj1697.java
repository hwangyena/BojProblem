package graph;

import java.io.*;
import java.util.*;

public class Boj1697 {
	static int[] depth;
	
	static void Move(int N, int K) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		depth = new int[100001];
		queue.add(N);
		depth[N] = 0;	//첫 방문 지점
		
		while(!queue.isEmpty() && N !=K) {
			//현재 위치
			N = queue.poll();
			
			//방문 X -> depth가 없는 경우에만 depth 이전값과 비교!
			if(visited[N]!=true) {
				visited[N] = true;
				
				//0 미만
				if(N>0) {
					if(depth[N-1] == 0) depth[N-1] = depth[N]+1;
					queue.add(N-1); 
				}
				
				//100,000 초과
				if(N+1<=100000) {
					if(depth[N+1] == 0) depth[N+1] = depth[N]+1;
					queue.add(N+1); 
				}
				
				if(N*2<=100000) {
					if(depth[N*2] == 0) depth[N*2] = depth[N]+1;
					queue.add(N*2);					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int N, M;
					
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			Move(N,M);
			
			System.out.println(depth[M]);
			
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
