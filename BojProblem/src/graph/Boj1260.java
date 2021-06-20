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
	private LinkedList<Integer> adj[];	//전체 리스트, 각 List의 head / 크기 : v
	static boolean[] visited;
	
	Graph(int v){
		this.V = v;
		this.adj = new LinkedList[v+1];	
		
		//인접리스트 초기화
		for(int i=1; i<=v; i++) {
			adj[i] = new LinkedList();
		}
	}

	//v와 w연결
	void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	//그래프 간선 정렬
	void sortG(int v) {
		for(int i=1; i<=v; i++)
			Collections.sort(adj[i]);
	}
	
	void DFS(int v) { //v: 시작 노드
		if(!visited[v]) {
			visited[v] = true;
			System.out.print(v + " ");
			
			//방문한 노드와 인접한 모든 노드를 가져옴
			Iterator<Integer> iter = adj[v].listIterator();
			while(iter.hasNext()) {
				int n = iter.next();
				//방문하지 않은 노드인 경우, 해당 노드를 시작노드로 다시 DFSUtil 호출
				if(!visited[n])
					DFS(n);
			}
		}
	}
	
	void BFS(int v) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[v] = true;
		queue.add(v);
		
		//큐 안에 값이 있을때 계속 실행
		while(queue.size()!=0) {
			//큐에서 값을 꺼내 값을 출력
			v = queue.poll();	
			System.out.print(v+" ");
			
			//방문한 노드(큐에서 꺼낸 값)과 인접한 모든 노드를 가져옴
			Iterator<Integer> iter = adj[v].listIterator();
			while(iter.hasNext()) {
				int n = iter.next();
				
				//방문하지 않은 노드면 방문표시 & 큐 삽입
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
			//N, M, V 입력
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			
			//그래프 선언
			Graph g = new Graph(N);

			//그래프 연결
			for(int i=0; i<M; i++) {
				StringTokenizer vw = new StringTokenizer(br.readLine(), " ");
				int v = Integer.parseInt(vw.nextToken());
				int w = Integer.parseInt(vw.nextToken());
				
				g.addEdge(v, w);
				
			}
			
			//정렬
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
