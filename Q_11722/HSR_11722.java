package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSR_11722 {
	static int[] A, D;
	static int N, leng;	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = new int[N];	
		D = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());			
		}
		seq();
		for (int i = 0; i < D.length; i++) {
			leng = Math.max(leng,D[i]);			
		}
		System.out.println(leng);		
	}		
	static void seq() {
		D[0] = 1;		
		for (int i = 1; i < A.length; i++) {
			D[i] = 1;
			for (int j = 0; j < i; j++) {
				if(A[i] < A[j] && D[j] + 1 >D[i]) {
					D[i] = D[j]+1;					
				}
				
			}
		}		
	}
}
