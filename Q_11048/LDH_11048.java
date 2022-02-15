package BOJ_11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class LDH_11048 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int dp[][] = new int[N+1][M+1]; // 대각선으로 합을 저장할 칸을 할당해주는게 for 처리가 편하더라

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + Integer.parseInt(st.nextToken()); // 생각해보니 dp[i+1][j+1]는 값이 안주어져있음. -인덱스로 계산해야함
            }
        } 
        System.out.println(dp[N][M]);
    }
}