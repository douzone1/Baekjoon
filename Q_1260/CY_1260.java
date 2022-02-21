import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	public static int N, M ,V;
	public static int[][] graph;
	public static int []check;
	
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V= Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		check = new int[N+1];
		
		// 인접행렬
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			graph[a][b] = graph[b][a] = 1;
		}
		
		dfs(V); // dfs
		sb.append("\n");
		initCheck(); // 방문체크 초기화
		bfs(V); // bfs 
		System.out.println(sb);
	}
	
	public static void dfs(int start) {
		check[start] = 1;
		sb.append(start + " ");
		for(int i=0; i<graph[start].length; i++) {
			if(graph[start][i] == 1 && check[i] == 0) {
				check[i] = 1;
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = 1;
		while(q.size() > 0) {
			int vertix = q.poll();
			sb.append(vertix + " ");
			for(int i=0; i<graph[vertix].length; i++) {
				if(graph[vertix][i] == 1 && check[i] == 0) {
					check[i] = 1;
					q.add(i);
				}
			}
		}
	}
	
	public static void initCheck() {
		for(int i=0; i<check.length; i++) {
			check[i] = 0;
		}
	}
}
