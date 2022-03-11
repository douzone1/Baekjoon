import java.io.*;

public class JY_9663 {
	static int n, cnt = 0;
	static boolean[] col, opp, anti; //열, 대각선, 반대각선
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		col = new boolean[n];
		opp = new boolean[2*n-1]; //x-y [-n~n]
		anti = new boolean[2*n-1]; //x+y [0~2n]
		
		dfs(0);
		
		System.out.println(cnt);
	}
	
	public static void dfs(int row) {
		if(row == n) {cnt++; return;}
		
		for(int i=0; i<n; i++) { //열 탐색
			if(col[i]==true || opp[row-i+n-1]==true || anti[row+i]==true) continue;
			col[i] = true; opp[row-i+n-1] = true; anti[row+i] = true;
			dfs(row+1);
			col[i] = false; opp[row-i+n-1] = false; anti[row+i] = false; //backtracking
		}
	}
}
