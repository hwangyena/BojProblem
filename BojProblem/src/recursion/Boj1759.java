package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj1759 {
	static Deque<String> pwd_queue = new ArrayDeque<String>();

	static void que_check(char[] pwdd) {
		if(pwd_queue.isEmpty()) {
			pwd_queue.add(String.valueOf(pwdd));
		}

		int cons=0;	//����
		int vowel = 0;	//����

		if(!pwd_queue.peekLast().equals(String.valueOf(pwdd))) {
			for(int i=0;i<pwdd.length; i++) {
				switch(pwdd[i]) {
					case 'a': case 'e': case 'i': case 'o': case 'u': 	{	//����, ���� Ȯ��
						vowel+=1;
						break;
					}
					default : {
						cons+=1;
						break;
					}
				}
			}
			
			if(vowel > 0 && cons > 1) {
				pwd_queue.add(String.valueOf(pwdd));
			}
		}
	}
	
	static void password(int L, int C, char[] pwd, int n, int position, char[] pwdd) {//n: � ����? , position: ��ȣ �ڸ�
		//��й�ȣ ����
		pwdd[position] = pwd[n];
		
		if(position < L-1) {	//�ڷ� �̵�
			password(L, C, pwd, n+1, position+1, pwdd);		
		}
		
		que_check(pwdd);
	
		if(n < C-L+position) {

			password(L, C, pwd, n+1, position, pwdd);
		}
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());	//��ȣ
			int C = Integer.parseInt(st.nextToken());	//���ڵ� ����
			
			st = new StringTokenizer(br.readLine());
			char pwd[] = new char[C];
			for(int i=0; i<C; i++) {
				pwd[i] = st.nextToken().charAt(0);
			}
			Arrays.sort(pwd);	//������� ����
			
			char[] pwdd = new char[L]; //��й�ȣ ���� �迭
			
			password(L, C, pwd, 0, 0, pwdd);
			
			while(!pwd_queue.isEmpty()) {
				System.out.println(pwd_queue.poll());
			}

			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
