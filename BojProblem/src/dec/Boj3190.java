package dec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj3190 {
	private static Deque<Location> snake = new ArrayDeque<>();
	private static int snake_x=0, snake_y=0;	//�� ��ġ
	private static int apple[][];	//��� ��ġ
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
	
	//���� �̵�(�� �˾ƺ��� ���� ���) : ��,��,��,�� ��������, ���� X
	private static int dirX[] = {-1, 0, 1, 0};
	private static int dirY[] = {0, 1, 0, -1};
	
	public static void main(String[] args){
		BufferedReader br = null;
		StringTokenizer st;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());	//���� ũ��
			int K = Integer.parseInt(br.readLine());	//��� ����
			
			int snake_dir[] = {0, 1};	//�� ����
			apple = new int[N][N];	//��� ��ġ
			
			while(K-->0) {//��� ��ġ
				st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				apple[row-1][col-1] = 2;
			}

			int L = Integer.parseInt(br.readLine());	//���� ���� ��ȯ Ƚ��
			snake.add(new Location(0, 0)); 	//���� ù ����
			boolean isEnd = false;	//�浹 ��
			
			int r=0;
			int X[] = new int[L];
			char C[] = new char[L];
			while(L-->0) {
				st = new StringTokenizer(br.readLine());
				
				X[r] = Integer.parseInt(st.nextToken());	//�̵� Ƚ��
				C[r++] = st.nextToken().charAt(0);			//�̵� ����
			}
			r=0;
			
			//���� �̵�
			boolean x_dir = true;	//x�������� y��������
			boolean y_dir = false;
			
			while(true) {
				if(isEnd) break;
				
				//���� �̵�
				if(time == X[r]) {					
					int dir=snake_dir[0];
					snake_dir[0] = snake_dir[1];
					snake_dir[1] = dir;
					
					if(C[r]=='L') {//x������ �ٲ�� L�� -
						if(x_dir) {
							snake_dir[0] *= -1;
							snake_dir[1] *= -1;
						}
					}else if(C[r]=='D') {//y�࿡�� �ٲ�� R�� -
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
				
				//���̶� �浹 or ���̶� �浹
				if(snake_x >= N || snake_y >= N || snake_x < 0 || snake_y < 0) {
					isEnd = true;
					break;
				}
				else if(isBody(snake_x, snake_y)) {
					isEnd = true;
					break;
				}
				
				//��� ������
				if(apple[snake_x][snake_y] == 2) {
					snake.add(new Location(snake_x, snake_y));
					apple[snake_x][snake_y] = 0;
				}
				else {	//��� �ȸ�����(���� �ڸ���, �Ӹ� �̵�)
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
	
