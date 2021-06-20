package recursion;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2630 {
	static int blue = 0;
	static int white = 0;
	
	static void which_color(int color) {	//� ��������
		if(color==1) {
			blue++;
		}
		else {
			white++;
		}
	}
	static void make_rect(int[][] a, int N, int x, int y) {	//x: x���� ��ǥ, y: y���� ��ǥ
		boolean is_rect = true;
		int color = a[0+x][0+y];
		
		if(N==1) {  //��� 1��
			which_color(color);
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(color != a[i+x][j+y]) {
					is_rect = false;
					break;
				}
			}
		}
		
		if(is_rect) {
			which_color(color);
			return;
		}
		else {			
			make_rect(a, N/2, x, y); 	//1
			make_rect(a, N/2, x, y+N/2);	//2
			make_rect(a, N/2, x+N/2, y);	//3
			make_rect(a, N/2,x+N/2, y+N/2);	//4
		}
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			int N = Integer.parseInt(br.readLine());
			int[][] paper = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					paper[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			make_rect(paper, N, 0, 0);
			
			System.out.println(white);
			System.out.println(blue);
			
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
