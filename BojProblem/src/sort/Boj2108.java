package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2108 {
	//산술 평균
	static int arithmetic(int[] a) {
		int sum=0;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		
		return sum/a.length;
	}

	//정렬

	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());
			
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
