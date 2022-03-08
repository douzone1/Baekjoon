import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static int N, S;
	public static int[] arr;
	public static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) dfs(i, 0);
		System.out.println(count);
	}

	public static void dfs(int depth, int sum) {
		if (depth >= N) return; // 종료조건

		sum += arr[depth]; // 부분수열 합
		if (sum == S) count++; // 결과

		for (int k = 1; k < N; k++) dfs(depth + k, sum);

	}
}
