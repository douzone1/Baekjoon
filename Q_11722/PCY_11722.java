import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] dp = new int[n+1];
		
		int result = 0;
		for(int i=0; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(map[j] > map[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
