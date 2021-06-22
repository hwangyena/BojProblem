package search;

import java.io.*;
import java.util.*;

public class Boj2805 {	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			long M = Integer.parseInt(st.nextToken());
			
			int[] wood = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				wood[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(wood);
			
			long left = 0; long right = wood[N-1];
			long center=0;	long answer =0;
			
			while(left<=right) {
				long cut=0;	//나무 잘렸을 때 길이
				
				//나무 중간값 -> 절단기의 길이
				center = (left+right)/2;
				
				for(int i=0; i<N; i++) {
					if(wood[i]>center) cut+=wood[i]-center;
				}
				
				if(cut>=M) {
					//최댓값을 저장해주기 위함 -> 이걸 생각을 못해서 한참 걸렸다!!!
					if(answer < center) answer = center;
					left=center+1;
				}
				else {
					right=center-1;
				}
			}
			System.out.println(answer);
			
			bw.flush();
			bw.close();
			br.close();			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
