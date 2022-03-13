package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HSR_9663 {
    public static int N;
    public static int cnt=0;
    static int[] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	
    	for (int i = 1; i <= N; i++) {
    		map = new int[N+1];
			map[1]= i;	
			put(1);			
		}
    	System.out.println(cnt);
    
    }
	static void put(int row) {
		// TODO Auto-generated method stub
		if(row == N) {
//			for (int j = 1; j < N; j++) {
//				System.out.print(map[j] + " ");
//			}
//			System.out.println();
			cnt++;
		}else {
			for (int j = 1; j <= N; j++) {
				map[row+1] = j;
				if(isPossible(row+1)) {
					put(row+1);
				}
			}
		}		
	}
	private static boolean isPossible(int row) {
		// TODO Auto-generated method stub
			for (int i = 1; i < row; i++) {
				if(map[i] == map[row]) {
					return false; 
				}
				
				if(Math.abs(map[i] - map[row])==Math.abs(i - row)) {
					return false;
				}
			}
		return true;
	}
}
