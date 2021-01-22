package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1874 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br;
		StringBuilder sb;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			int stack_num = 1;	//stack에 push 되는 수
			sb = new StringBuilder();
			boolean cant = true;
			
			for(int i=1; i<=N;i++) {
				int number = Integer.parseInt(br.readLine());	//pop해야하는 number
				if(stack.isEmpty()) {
					stack.push(stack_num++);
					sb.append("+\n");
				}
	
				if(stack.peek() > number) {
					sb.delete(0, sb.length());
					sb.append("NO");
					cant = false;
				}
				
				while(stack.peek() != number && cant) {
					
					stack.push(stack_num++);
					sb.append("+\n");
				}
				
				if(stack.peek() == number && cant) {
					stack.pop();
					sb.append("-"+"\n");
				}
			}
			
			System.out.println(sb.toString());
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
