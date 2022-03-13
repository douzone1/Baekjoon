package BOJ_9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static int[] map;
	public static int N;
	public static int count = 0;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
 
		DFS(0);
		System.out.println(count);
 
	}
 
	public static void DFS(int depth) {
		if (depth == N) { // 끝까지 생존 시 check
			count++;
			return;
		}
 
		for (int i = 0; i < N; i++) {
			map[depth] = i;
			if (mate(depth)) { // 8방향에 걸리지 않으면 true
				DFS(depth + 1);
			}
		}
 
	}
 
	public static boolean mate(int col) {
 
		for (int i = 0; i < col; i++) {
            // 같은 열이면 false
			if (map[col] == map[i]) {
				return false;
            // 대각선 경로에 존재하면 false
			} else if (Math.abs(col - i) == Math.abs(map[col] - map[i])) {
				return false;
			}
		}
		
		return true;
	}
}
