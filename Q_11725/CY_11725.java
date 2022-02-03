import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	public static int NODE = 0;
	public static int [] parents;
	
	public static void dfs(int v, LinkedList<Integer>[] graph, boolean[] visited) {
		visited[v] = true;
		
		Iterator<Integer> iter = graph[v].listIterator();
		while(iter.hasNext()) {
			int w = iter.next();
			if(!visited[w]) {
				parents[w] = v;
				dfs(w, graph, visited);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		NODE = Integer.parseInt(br.readLine()); // 노드개수
		parents = new int[NODE+1];
		boolean[] visit = new boolean[NODE+1]; // 방문처리
		
		// 그래프 입력
		LinkedList<Integer>[] tree =  new LinkedList[NODE+1]; 
		
		for(int i=0; i<NODE+1; i++) {
			tree[i] = new LinkedList<Integer>();
		}
		
		for(int i=0; i<NODE-1; i++) {
			int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			tree[arr[0]].add(arr[1]);
			tree[arr[1]].add(arr[0]);
		}
		
		// DFS처리
		dfs(1, tree, visit);
		
		for(int i=2; i<NODE+1; i++) {
			sb.append(parents[i] + "\n");
		}
		
		System.out.println(sb);
		br.close();
		
	}
}
