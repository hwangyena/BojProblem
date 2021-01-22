package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Boj2750 {

	public static void main(String[] args) {
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(bf.readLine());
			int array[] = new int[num];
			
			for(int i=0; i<num; i++) {
				array[i] = Integer.parseInt(bf.readLine());
			}
			
			Arrays.sort(array);
			
			for(int i=0; i<num; i++) {
				System.out.println(array[i]);
			}
			
			bf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
