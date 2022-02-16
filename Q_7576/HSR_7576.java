package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class HSR_7576 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		int isUnripe= 0, ripeDay=0;
		int[][] tomato = null, day = null;
		int N,M;
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		//토마토상자 크기입력
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		Queue<Pair> qu = new LinkedList<>();
		tomato = new int[N][M];
		day = new int[N][M];
		
		//토마토 박스 안 설정
		for (int i = 0; i < tomato.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < tomato[i].length; j++) {				
				tomato[i][j] = Integer.parseInt(st.nextToken());
				day[i][j] = -1;		//방문 여부 확인을 위해 -1로 초기화
				//익은 토마토 시작점 세팅
				if( tomato[i][j] == 1) {	//이미 익은 토마토라면 day[i][j] 배열에 0을 넣어주고
					qu.offer(new Pair(i, j));
					day[i][j] = 0;
				}
				else if(tomato[i][j] == 0){	//아니라면 day[i][j] 배열에 -1을 넣어준다
					isUnripe++;
					
				}
			}			
		}
		
		while( !qu.isEmpty()) {
			Pair p = qu.poll();
			
			//선언해둔 x, y 좌표값 배열을 통해 기준점에서 상,하,좌,우를 탐색 
			for (int i = 0; i < 4; i++) {
				int nX = p.x + dx[i];
				int nY = p.y + dy[i];
				
				//지정한 배열크기를 넘었을땐 skip 
				if(nX <0 || nX >= N || nY < 0 || nY >= M) {
					continue;
				}
				
				//토마토가 없거나, 이미 방문했을때도 skip
				if(tomato[nX][nY] == -1  || day[nX][nY] != -1) {
					continue;
				}
				
				//익은 토마토를 큐에 넣어주고 안익은 토마토의 개수 -1
				qu.offer(new Pair(nX, nY)); isUnripe--;
				
				// 날짜를 더해준다
				day[nX][nY] = day[p.x][p.y] +1;
				// 해당 날짜가 최종 날짜인지 구분
				if(ripeDay < day[nX][nY]) {
					ripeDay = day[nX][nY];
				}
				
			}
		}
		
		// 만약 아직도 익지 않은 토마토가 있다면 -1 출력
		if(isUnripe > 0) {
			System.out.println(-1);
		}else {
			System.out.println(ripeDay);
		}
	}
	public static class Pair {
		int x, y;
		public Pair(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
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
		
	}
}
