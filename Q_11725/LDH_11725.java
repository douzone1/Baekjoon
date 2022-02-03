package BOJ_11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;

public class LDH_11725 {
    static int[] parents;
    static ArrayList<Integer>[] list;
    static int N, i, j, l, r;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
        parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
		
		visited = new boolean[N+1];
		for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
			list[l].add(r);
            list[r].add(l);
		}
		
		dfs(1);
		for(int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
	}

    private static void dfs(int v) {
        visited[v] = true;
        for (int i : list[v]) {
            if (!visited[i]) {
                parents[i] = v;
                dfs(i);
            }
        }
    }
}
