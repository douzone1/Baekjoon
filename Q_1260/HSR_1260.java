package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HSR_1260 {
	private static int N, M, V, num1, num2;
	static ArrayList<Integer>[] nodelist = null;
	static boolean[] visited = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		visited =new boolean[N+1];
		nodelist =  new ArrayList[N+1];
		
		for (int i = 0; i < M; i++) {
			nodelist[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			
			nodelist[num1].add(num2);
			nodelist[num2].add(num1);
		}
		for (int i = 0; i < nodelist.length; i++) {
			Collections.sort(nodelist[i]);
		}	

		dfs(V);
		
		Arrays.fill(visited, false);
        System.out.println();
        
        bfs(V);
		
	}
	private static void dfs(int V) {
		if(visited[V]) {
			return;
		}
		
		System.out.print(V + " ");
		visited[V] = true;
		for (int i = 0; i < nodelist[V].size(); i++) {
			int MIN = 1001;			
			//해당 노드가 가장 낮은 수인지 모두 방문하여 검증
			for (int j = 0; j < nodelist[V].size(); j++) {
				int cur = nodelist[V].get(j);
				
				if(!visited[cur]) {
					MIN = Math.min(MIN, cur);
				}
			}			
			if(MIN == 1001)break;
			dfs(MIN);			
		}	
	}
	
	 private static void bfs(int V) {
	        Queue<Integer> q = new LinkedList<>();

	        q.add(V);
	        visited[V] = true;

	        while(!q.isEmpty()) {
	            int node = q.poll();
	            System.out.print(node + " ");

	            // 해당 노드에 존재하는 노드 수만큼 반복
	            for (int i = 0; i < nodelist[node].size(); i++) {
	                int MIN = 1001;

	                // 해당 노드가 가장 낮은 수인지 모두 방문하여 검증
	                for (int j = 0; j < nodelist[node].size(); j++) {
	                    int cur = nodelist[node].get(j);

	                    if(!visited[cur]) {
	                        MIN = Math.min(MIN, cur);
	                    }

	                }

	                if(MIN == 1001) break;

	                q.add(MIN);
	                visited[MIN] = true;
	            }

	        }

	    }
}
