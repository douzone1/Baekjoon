package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class HSR_11048 {
	
	static int N,M;
	static int[][] arrays;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		//BufferedReader로 속도증가
//		Scanner sc = new Scanner(System.in);
		
		int max = Integer.MIN_VALUE;
		//BufferedReader로 속도증가
//		N = sc.nextInt();
//		M = sc.nextInt();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arrays = new int[N][M];
		dp = new int[N][M];
		
		for (int i = 0; i < arrays.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arrays[i].length; j++) {
				arrays[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//BufferedReader로 속도증가
//		for (int i = 0; i < arrays.length; i++) {
//			for (int j = 0; j < arrays[i].length; j++) {
//				arrays[i][j] = sc.nextInt(); 
//			}
//		}	
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if(i==0 && j ==0) dp[i][j] = arrays[i][j];	//시작점 dp값 설정
				else if	(i == 0) dp[i][j] = dp[i][j-1] + arrays[i][j];	//i가0일때는 상단에서 받아올 값이 없으므로 왼쪽의 dp값 더하기
				else if (j == 0) dp[i][j] = dp[i-1][j] + arrays[i][j];	//j가0일때는 좌측에서 받아올 값이 없으므로 왼쪽의 dp값 더하기
				else {	
					//그 이외에는 좌상단 상단 좌측에서 최대값을 더해야 사탕을 가장많이 가져올수 있기 때문에 최대값max를 구하여
					//해당 위치의 arrays의 값과 구한 최대값max를 더해주면 사탕을 최대로 가질 수 있는 경우를 현재 위치에 더해줌
					max = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));	 
					dp[i][j] = max + arrays[i][j];
				} 				
			}
		}
		System.out.println(dp[N-1][M-1]);		
	}
}
