package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

class Graph{
	private int V;
	private LinkedList<Integer> adj[];	//��ü ����Ʈ, �� List�� head / ũ�� : v
	static boolean[] visited;
	
	Graph(int v){
		this.V = v;
		this.adj = new LinkedList[v+1];	
		
		//��������Ʈ �ʱ�ȭ
		for(int i=1; i<=v; i++) {
			adj[i] = new LinkedList();
		}
	}

	//v�� w����
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	//�׷��� ���� ����
	void sortG(int v) {
		for(int i=1; i<=v; i++)
			Collections.sort(adj[i]);
	}
	
	void DFS(int v) { //v: ���� ���
		if(!visited[v]) {
			visited[v] = true;
			System.out.print(v + " ");
			
			//�湮�� ���� ������ ��� ��带 ������
			Iterator<Integer> iter = adj[v].listIterator();
			while(iter.hasNext()) {
				int n = iter.next();
				//�湮���� ���� ����� ���, �ش� ��带 ���۳��� �ٽ� DFSUtil ȣ��
				if(!visited[n])
					DFS(n);
			}
		}
	}
	
	void BFS(int v) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[v] = true;
		queue.add(v);
		
		//ť �ȿ� ���� ������ ��� ����
		while(queue.size()!=0) {
			//ť���� ���� ���� ���� ���
			v = queue.poll();	
			System.out.print(v+" ");
			
			//�湮�� ���(ť���� ���� ��)�� ������ ��� ��带 ������
			Iterator<Integer> iter = adj[v].listIterator();
			while(iter.hasNext()) {
				int n = iter.next();
				
				//�湮���� ���� ���� �湮ǥ�� & ť ����
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
}

public class Boj1260 {
	public static void main(String[] args) {
		BufferedReader br;
		BufferedWriter bw;
		StringTokenizer st;
		int N,M,V;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
			//N, M, V �Է�
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			
			//�׷��� ����
			Graph g = new Graph(N);

			//�׷��� ����
			for(int i=0; i<M; i++) {
				StringTokenizer vw = new StringTokenizer(br.readLine(), " ");
				int v = Integer.parseInt(vw.nextToken());
				int w = Integer.parseInt(vw.nextToken());
				
				g.addEdge(v, w);
				
			}
			
			//����
			g.sortG(N);
			
			g.visited = new boolean[N+1];
			g.DFS(V);
			System.out.println();
			
			g.visited = new boolean[N+1];
			g.BFS(V);
			
			bw.flush();
			bw.close();			
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
