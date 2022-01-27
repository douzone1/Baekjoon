import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			int input = Integer.parseInt(br.readLine());
			
			if(input > 3) {
				int [] dp = new int[input+1];
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;
				
				for(int i=4; i<=input; i++) {
					dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
				}
				sb.append( dp[input] + "\n");	
			}
			else {
				if(input == 3) sb.append(4 + "\n");
				else sb.append(input + "\n");
			}
		}
		System.out.println(sb);
	}
}
