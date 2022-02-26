import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point{
	int x; int y;
	int count;
	boolean wall;
	Point(int x, int y, int count, boolean wall){
		this.x = x;
		this.y = y;
		this.count = count;
		this.wall = wall;
	}
}

public class Main {
	public static int N, M;
	public static int[][][] check;
	public static int[][] map;
	public static int[][] directions = {{0,1}, {0,-1}, {-1,0}, {1,0}}; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		N = input[0]; M = input[1];
		map = new int[N][M];
		check = new int[N][M][2]; // 0: 벽을 부수고 탐색하는 경우, 1: 벽을 부수지 않고 탐색하는 경우 
		for(int i=0; i<N; i++) {
			int[] info = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			for(int j=0; j<M; j++) {
				map[i][j] = info[j];
			}
		}
		bfs(0,0,1,false);
	}
	
//	벽이 아니면
//	부신 벽이 여태까지 없었으면 -> visited[?][?][0] 방문 처리 + queue에 넣음
//	벽을 한번 부신 적이 있으면 -> visited[?][?][1] 방문 처리 + queue에 넣음
//	벽이면
//	한번도 벽을 부신 적이 없으면 부수고 -> visited[?][?][1] 방문 처리 + queue에 넣음
	
	
	public static void bfs(int x, int y, int count, boolean wall) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x,y,count,wall));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.x == N-1 && now.y == M-1) {
				System.out.println(now.count);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = now.x + directions[i][0];
				int ny = now.y + directions[i][1];
				
				if(0<=nx && 0<=ny && nx<N && ny<M) {
					int nextCount = now.count + 1;
					if(map[nx][ny] == 0 && check[nx][ny][1] == 0 && !now.wall) {
						q.add(new Point(nx,ny,nextCount, false));
						check[nx][ny][1] = 1;
					}
					
					else if(map[nx][ny] == 0 && check[nx][ny][0] == 0 && now.wall) {
						q.add(new Point(nx,ny, nextCount, true));
						check[nx][ny][0] = 1;
					}
					
					else if(map[nx][ny] == 1 && !now.wall) {
						q.add(new Point(nx,ny, nextCount, true));
						check[nx][ny][0] = 1;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
