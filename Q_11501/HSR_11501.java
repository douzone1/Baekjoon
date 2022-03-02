package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HSR_11501 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N,M;		
		int max = 0;		
		int profit = 0;	//주식으로 얻은 이득
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> stock = new ArrayList<Integer>();
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			max = 0;
			stock.removeAll(stock);
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				stock.add(Integer.parseInt(st.nextToken()));
				System.out.print(stock.get(j) + " ");				
			}
			
			for (int k = M - 1; k >= 0; k--) {
				if(stock.get(k) > max) {
					max = stock.get(k);
				}
				else {
					profit += max - stock.get(k);
				}
			}			
			System.out.println("profit:" + profit);
			
			profit = 0;
			
		}
		
	}
}
