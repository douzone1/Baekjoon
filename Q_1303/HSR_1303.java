package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HSR_1303 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Integer> visitArr = new ArrayList<Integer>();
	static boolean[][] isVisited;
	static char[][] battlefield;
	static Queue q = new LinkedList<>();
	
	static int B = 0, W = 0, N, M, cnt = 0;
		public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[N][M];
		battlefield = new char[N][M];	//true = W false = B
	
		for (int i = 0; i < N; i++) {
			sb.setLength(0);
			sb.append(br.readLine());			
			for (int j = 0; j < M; j++) {
				battlefield[i][j] = sb.toString().charAt(j);
			}			
		}
		for (int i = 0; i < N; i++) {						
			for (int j = 0; j < M; j++) {
				if(!isVisited[i][j]) {
					cnt = 1;
					isVisited[i][j]= true;
					q.add(new int[] {i, j});
					
					bfs();
					
					if(battlefield[i][j] == 'W') {W += cnt * cnt;}
					else{B += cnt * cnt;}
					
				}
			}			
		}
		System.out.println(W + " " + B);
		
		
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			int[] pos = (int[])q.poll();
			int row = pos[0];
			int col = pos[1];
			
			for (int i = 0; i < dx.length; i++) {
				int nx = row + dx[i];
				int ny = col + dy[i];
				
				//배열 범위를 넘어가면 패스
				if(nx >= N || nx < 0 || ny >= M || ny < 0) {
					continue;
				}
				//이미 방문한 배열이면 패스
				if(isVisited[nx][ny]) {
					continue;
				}
				//인접한 배열의 값이 다르면 패스
				if (battlefield[nx][ny] != battlefield[row][col]) {
					continue;
				}
				
				cnt++;
				isVisited[nx][ny] = true;
				q.add(new int[] {nx, ny});
				
				
				
			}
		}
		
	}
}
