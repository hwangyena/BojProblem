package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966{	
	public static void main(String[] args) {
		BufferedReader bf= null;
		BufferedWriter bw=null;
		StringTokenizer st;
		Iterator<Integer> iter;
		
		try {
			bf = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int testCase = Integer.parseInt(bf.readLine());
			for(int i=0; i<testCase; i++) {
				Queue<Integer> queue = new LinkedList<Integer>();
				

				st = new StringTokenizer(bf.readLine(), " ");
				int N = Integer.parseInt(st.nextToken());	//������ ��
				int M = Integer.parseInt(st.nextToken());	//answer ������ �ε��� ��
				st = new StringTokenizer(bf.readLine(), " ");
		
				for(int j=0; j<N; j++) {
					queue.add(Integer.parseInt(st.nextToken()));	//������ �߿䵵
				}			
				int num_print=0;
				
				//queue �켱���� ����
				while(!queue.isEmpty()) {	
					iter = queue.iterator();
					int front = iter.next();
					boolean isbreak = true;
					
					while(iter.hasNext()) {
						if(front < iter.next()) {	//���� �̵��� ��
							int toBack = queue.poll();
							queue.add(toBack);
							isbreak = false;
							M = (M>0) ? M-1 : M+queue.size()-1; 
							break;
						}
					}
					if(isbreak) {			
						queue.poll();
						num_print+=1;
						if(M == 0) bw.write(num_print+"\n");
						if(--M==-1) break;
						
					}
				}
			}
			bw.flush();
			bw.close();
			bf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
