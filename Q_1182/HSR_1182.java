package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSR_1182 {	
	static int N;
	static int S;
	static int[] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		
		st = new StringTokenizer(br.readLine());		
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}	
		
		seq(arr, 0, 0);
		
		
		
		if(S == 0) {
			cnt--;			
		}
		System.out.println(cnt);
	}
	static void seq(int[] arr, int depth, int sum) {
		if(depth == N) {
			if(sum == S) { cnt++;}
			return;
		}
		seq(arr,depth +1, sum + arr[depth]);
		seq(arr,depth +1, sum);
		
	}
}
