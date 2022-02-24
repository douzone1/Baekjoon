import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x; int y;
	
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class Main {
	public static int N, M;
	public static int[][] map;
	public static int[][] check;
	public static int[][] check2;
	public static int[][] directions = {{0,1}, {0,-1}, {-1,0}, {1,0}}; 
	
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//  === 입력 ===
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int year = 0;
		boolean flag = false;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
		}
		
		/* ==== 탐색 =====
		 * bfs: 매년 빙산 상태를 구하는 탐색, check 배열로 방문 체크
		 * bfs2: 빙산이 몇덩어리인지 탐색, check2 배열로 방문 체크
		 * count: 덩어리 수
		 * year: 빙산이 두 덩어리 이상으로 분리되는 최초 시간(년)
		 * */
	
		while(!none()) { // 녹지않은 빙산이 있다면
			int count = 0;  
			check2 = new int[N][M];
			check = new int[N][M];
			
			for(int i=1; i<N; i++) {
				for(int j=1; j<M; j++) {
					if(map[i][j] > 0) bfs(i,j);
				}
			}
			year++;
			for(int a=1; a<N; a++) {
				for(int b=1; b<M; b++) {
					if(check2[a][b] == 0 && map[a][b] > 0) {
						bfs2(a,b);
						count++;
					}
				}
			}
			if(count > 1) {
				flag = true;
				break;
			}
		}
		
		if(flag) System.out.println(year);
		else System.out.println(0);
		
	}

	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x,y));
		check[x][y] = 1;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int i=0; i<4; i++) {
				int nx = now.x + directions[i][0];
				int ny = now.y + directions[i][1];
				
				if(0<=nx && 0<=ny && nx<N && ny<M) {
					if(check[nx][ny] == 0) {
						if(map[nx][ny] <= 0) {
							map[x][y] -=1;
							continue;
						}
						check[nx][ny] =1;
					}
				}
			}
		}
	}
	
	
	public static void bfs2(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now.x + directions[i][0];
				int ny = now.y + directions[i][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					if(check2[nx][ny] == 0 && map[nx][ny] > 0) {
						check2[nx][ny] =1;
						q.add(new Point(nx,ny));
					}
				}
			}
			
		}
	}
	
	public static boolean none() {
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				if(map[i][j] <= 0) continue;
				else return false;
			}
		}
		return true;
	}
}
