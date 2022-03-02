import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			
			int N = Integer.parseInt(br.readLine());
			long[] prices = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			long maxValue = prices[N-1]; // 최대값 설정
			long result = 0;
			// 뒤에서 탐색해서 최대값 보다 작으면 주식을 팔고, 최대값보다 큰값이면 최대값을 변경
			for(int i=N-2; i>=0; i--) {
				if(maxValue < prices[i]) {
					maxValue = prices[i];
				}
				else {
					result += (maxValue - prices[i]);
				}
			}
			
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}
