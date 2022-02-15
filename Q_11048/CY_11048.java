import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] route;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		route = new int[N+1][M+1];
		
		// 인덱스 0부터 값을 채우게 되면 점화식을 사용할 때, 범위 밖으로 나가기 때문에 인덱스 1부터 값을 채움 
		for(int i=1; i<=N; i++) {
			st  = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				route[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				// 대각선으로 바로 가는 방향은 두 방향보다 먹을 수 있는 사탕이 적기때문에 제외함
        // 오른쪽, 아래쪽으로 가는 경로 중 먹을 수 있는 사탕의 갯수가 많은쪽으로 이동
				route[i][j] +=	Math.max(route[i][j-1], route[i-1][j]); 
			}
		}
		System.out.println(route[N][M]);
	}
}
