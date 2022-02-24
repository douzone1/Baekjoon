package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class IceBerg {
	int x;
	int y;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public IceBerg(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}

public class HSR_2573 {
	static int N,M;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] iceberg;
	
	static int[][] map;
	static Queue q = new LinkedList();
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st= new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		int cnt = 0;
		
		while((cnt = separateNum()) < 2) {	//빙하가 2개이상 분리 되었을때
			if (cnt == 0) {
				ans = 0;
				break;
			}
			
			bfs();
			ans++;
		}
		System.out.println(ans);
	}
	public static int separateNum() {
		boolean[][] isVisited = new boolean[N][M];;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0 && !isVisited[i][j]) {
					dfs(i, j, isVisited);
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
 
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
 
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
 
            if (map[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx, ny, visited);
            }
        }
    }
	
	public static void bfs() {
		Queue<IceBerg> q = new LinkedList<>();
		
		boolean[][] isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] !=0) {
					q.offer(new IceBerg(i, j));
					isVisited[i][j] = true;
				}
			}
		}
		
		int nx, ny;
		while(!q.isEmpty()) {
			IceBerg ice = q.poll();	//맵 전체를 검사해 IceBerg 객체를 큐를 통해 생성
			
			int seaNum = 0;	//빙하 상하좌우 사면에 있는 바다의 수를 담을 변수
			
			for (int i = 0; i < dx.length; i++) {
				nx = dx[i] + ice.getX();
				ny = dy[i] + ice.getY();
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
 
                if (!isVisited[nx][ny] && map[nx][ny] == 0) {
                    seaNum++;
                }
			}
			
			if(map[ice.getX()][ice.getY()] - seaNum < 0) {
				map[ice.getX()][ice.getY()] = 0;
			} else
				map[ice.getX()][ice.getY()] -= seaNum;
		}
	}
}
