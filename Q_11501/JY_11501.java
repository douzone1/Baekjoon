import java.util.*;
import java.io.*;

public class Main {		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		long ans[] = new long[testcase];
		for( int n = 0 ; n < testcase ; n++ ) {
			int days = Integer.parseInt(br.readLine());
			long stocks[] = new long[days];
			long max = 0;
      
      StringTokenizer st = new StringTokenizer(br.readLine());
			for( int i = 0 ; i < days ; i++ ) 
				stocks[i] = Integer.parseInt(br.readLine());
			
			for( int i = days-1 ; i >= 0 ; i-- ) {
				if(stocks[i] > max) {
					max = stocks[i];
				}else {
					ans[n] += (max - stocks[i]);
				}
			}		
		}
		for( long i : ans) {
			System.out.println(i);
		}
	}
}
