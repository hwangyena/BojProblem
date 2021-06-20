package graph;

import java.io.*;
import java.util.*;

//������� �׷��� Ŭ����
// 1: ������ �������̿� ������ ������ ���
// 0: ������ ���� ��� 0

public class Boj2178 {
	static boolean visited[][];
	static int maze_move[][];
	
	static void BFS(int[][] maze, int N, int M) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int move_x[] = {-1,0,1,0};	int move_y[]= {0,-1,0,1};
		maze_move = new int[N+1][M+1];
		
		//maze_move �ʱ�ȭ
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=M; j++) {
				maze_move[i][j] = 0;
			}
		}
		
		visited[1][1] = true;	//�湮O (1,1)���� ����
		//(x,y) �������!!
		queue.add(1);
		queue.add(1);
		
		while(!queue.isEmpty()) {
			//ť���� �������� Ȯ��
			int q_x = queue.poll();
			int q_y = queue.poll();
			
			//���� ����� ��,��,��,��
			for(int i=0; i<4; i++) {
				int x = q_x+move_x[i];
				int y = q_y+move_y[i];
				
				if(x<1 || y<1 || x>N || y>M) continue;
			
				//�湮���� ���� ���
				if(!visited[x][y] && maze[x-1][y-1]==1) {
					visited[x][y] = true;
					maze_move[x][y] = maze_move[q_x][q_y]+1;
										
					queue.add(x);
					queue.add(y);
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
			N = Integer.parseInt(st.nextToken()); //x��ġ
			M = Integer.parseInt(st.nextToken()); //y��ġ
			
			//�׷��� ���� & �ʱ�ȭ
			int[][] g = new int[N+1][M+1];
 			
			for(int i=0; i<N; i++) {
				String[] maze = br.readLine().split("");
				
				for(int j=0; j<M; j++) {
					g[i][j] = Integer.parseInt(maze[j]);
				}
			}
			
			//BFS -> �ִܰŸ�!
			visited = new boolean[N+1][M+1];
			
			BFS(g, N, M);
			
//			for(int i=0; i<=N; i++) {
//				for(int j=0; j<=M; j++) {
//					System.out.printf("%3d ",maze_move[i][j]);
//				}System.out.println();
//			}
			
			System.out.println(maze_move[N][M]+1);
			
			
			bw.flush();
			bw.close();
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
