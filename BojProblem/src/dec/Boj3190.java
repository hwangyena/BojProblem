package dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj3190 {
	private static Deque<Location> snake = new ArrayDeque<>();
	private static int snake_x=0, snake_y=0;	//뱀 위치
	private static int apple[][];	//사과 위치
	private static int time = 0;
	private static StringBuilder sb = new StringBuilder();	
	
	private static class Location{
		int x; int y;
		Location(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	private static boolean isBody(int x, int y) {
		for(Location s : snake) {
			if(s.x == x && s.y == y) return true;
		}return false;
	}
	
	//방향 이동(더 알아보기 쉬운 방법) : 북,동,남,서 방향으로, 구현 X
	private static int dirX[] = {-1, 0, 1, 0};
	private static int dirY[] = {0, 1, 0, -1};
	
	public static void main(String[] args){
		BufferedReader br = null;
		StringTokenizer st;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());	//보드 크기
			int K = Integer.parseInt(br.readLine());	//사과 개수
			
			int snake_dir[] = {0, 1};	//뱀 방향
			apple = new int[N][N];	//사과 위치
			
			while(K-->0) {//사과 위치
				st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				apple[row-1][col-1] = 2;
			}

			int L = Integer.parseInt(br.readLine());	//뱀의 방향 변환 횟수
			snake.add(new Location(0, 0)); 	//뱀의 첫 방향
			boolean isEnd = false;	//충돌 시
			
			int r=0;
			int X[] = new int[L];
			char C[] = new char[L];
			while(L-->0) {
				st = new StringTokenizer(br.readLine());
				
				X[r] = Integer.parseInt(st.nextToken());	//이동 횟수
				C[r++] = st.nextToken().charAt(0);			//이동 방향
			}
			r=0;
			
			//방향 이동
			boolean x_dir = true;	//x방향인지 y방향인지
			boolean y_dir = false;
			
			while(true) {
				if(isEnd) break;
				
				//방향 이동
				if(time == X[r]) {					
					int dir=snake_dir[0];
					snake_dir[0] = snake_dir[1];
					snake_dir[1] = dir;
					
					if(C[r]=='L') {//x축으로 바뀌면 L에 -
						if(x_dir) {
							snake_dir[0] *= -1;
							snake_dir[1] *= -1;
						}
					}else if(C[r]=='D') {//y축에서 바뀌면 R에 -
						if(y_dir) {
							snake_dir[0] *= -1;
							snake_dir[1] *= -1;
						}
					}
					r = (++r >= X.length) ? 0 : r;
					
					if(x_dir) {
						y_dir = true;
						x_dir = false;
					}else if(y_dir) {
						y_dir = false;
						x_dir = true;
					}
				}

				
				if(time == X[r]) {
					r = (++r >= X.length) ? 0 : r;
				}
				time++;
				
				snake_x += snake_dir[0];
				snake_y += snake_dir[1];
				
				//벽이랑 충돌 or 몸이랑 충돌
				if(snake_x >= N || snake_y >= N || snake_x < 0 || snake_y < 0) {
					isEnd = true;
					break;
				}
				else if(isBody(snake_x, snake_y)) {
					isEnd = true;
					break;
				}
				
				//사과 먹으면
				if(apple[snake_x][snake_y] == 2) {
					snake.add(new Location(snake_x, snake_y));
					apple[snake_x][snake_y] = 0;
				}
				else {	//사과 안먹으면(꼬리 자르기, 머리 이동)
					snake.remove();
					snake.add(new Location(snake_x, snake_y));
				}
			}
			
			
			sb.append(time);
			System.out.println(sb.toString());
			
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
	
