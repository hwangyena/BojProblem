package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj2751 {
	static int[] temp_buf;
	
	static void mergeSort(int[] a, int left, int right) {
		if(left < right) {
			int center = (left+right)/2;
			
			mergeSort(a, left, center);
			mergeSort(a, center+1, right);
			
			int temp_idx = left;
			int left_p = left;
			int right_p = center+1;
			
			while(left_p <= center && right_p <= right) {
				if(a[left_p] < a[right_p]) temp_buf[temp_idx++] = a[left_p++];
				else temp_buf[temp_idx++] = a[right_p++];
			}
			
			while(left_p <= center) temp_buf[temp_idx++] = a[left_p++]; 
			while(right_p <= right) temp_buf[temp_idx++] = a[right_p++];
			
			for(int i=left; i<=right; i++) {
				a[i] = temp_buf[i];
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int num = Integer.parseInt(bf.readLine());
			int array[] = new int[num];
			
			for(int i=0; i<num; i++) {
				array[i] = Integer.parseInt(bf.readLine());
			}

			temp_buf = new int[num];
			mergeSort(array, 0, num-1);
			
			for(int i=0; i<num; i++) {
				bw.write(Integer.toString(array[i])+"\n");
			}
			bw.flush();
			bw.close();
			bf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
