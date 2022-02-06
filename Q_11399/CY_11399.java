import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int [] P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		
		Arrays.sort(P);
		
		int sum = 0;
		
		for(int i =1; i<N; i++) {
			P[i] = P[i-1] + P[i];
		}
		
		
		for(int item : P) {
			sum += item;
		}
		
		sb.append(sum);
		System.out.println(sb);
		br.close();
	}
}
