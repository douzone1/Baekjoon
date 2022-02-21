package BOJ_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	
	static int[][] graph;
	static boolean[] visited = new boolean[1001];	
	static int V, E;
	
	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new int[V+1][E+1];
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			graph[node1][node2] = 1;
			graph[node2][node1] = 1;
		}
		
		dfs(V);
		sb.append("\n");
		Arrays.fill(visited, false);		
		
		bfs(V);
		System.out.println(st);
		sb.setLength(0);					
		Arrays.fill(visited, false);		
		
	}
	
	private static void dfs(int v) {		
		
		visited[v] = true;
		sb.append(v).append(" ");
		
		//recursive
		for (int i = 1; i <= V; i++) {
			if(graph[v][i] == 1 && !visited[i]) { 
				dfs(i);
			}
		}
	}

	static void bfs(int v) {

		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			
			v = q.poll();
			sb.append(v).append(" ");
			
			for (int i = 1; i <= V; i++) {
				if(graph[v][i] == 1 && !visited[i]) {
					q.add(i);			
					visited[i] = true;
				}
			}
		}
		q.clear();
	}
}