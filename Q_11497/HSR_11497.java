package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HSR_11497 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		int start, end;
		int level = 0;
		int max;
		int[] tree = null;
		int[] arr = null;
		while(T-- >0) {
			max = Integer.MIN_VALUE;
			start = 0;			
			N = Integer.parseInt(br.readLine());
			end = N-1;
			st = new StringTokenizer(br.readLine());
			tree = new int[N];
			arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken()); 
			}
			
			Arrays.sort(tree);
			for (int i = 1; i <= N; i++) {				
				if((start <= end) && (i % 2 != 0)) {
					arr[start] = tree[i-1];
					start++;
				}
				else if((start <= end) && (i % 2 == 0)) {
					arr[end] = tree[i-1];
					end--;
				}				 
			}			
			for (int i = 0; i < arr.length -1; i++) {
				if(max < Math.abs(arr[i] - arr[i+1])){					
					max = Math.abs(arr[i] - arr[i+1]);					
				}				
				if(i == arr.length -1) {
					if(max < Math.abs(arr[0] - arr[arr.length -1])){						
						max = Math.abs(arr[0] - arr[arr.length -1]);												
					}					
				}				
			}			
			System.out.println(max);
			
		}		
	}
}
