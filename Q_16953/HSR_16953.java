package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSR_16953 {
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		long A, B;
		int cnt = 1;
		A = Long.parseLong(st.nextToken()); 
		B = Long.parseLong(st.nextToken());
		String strB = null;
		
		int strL = 0;
		
		while(B != A) {
			strB = Long.toString(B);
			strL = Long.toString(B).length();
			
			
			// if 1 B의 1의자리 숫자가 2보다 클때 홀수이면 절대 만들 수 없음.
			if(B % 2 !=0) {
				if (B<A) break;	// B가 A보다 작으면  도출 불가 1의 자리에 왔을때 짝수지만 도출값이 해당 짝수보다 클경우가 생김
				if(strB.charAt(strL-1) > 50) { break;}	// if 1-1 B의 1자리 숫자가 홀수일때 1이 아니면 못찾으니 break;
				else {	// B의 1의 자리가 1일때
					System.out.print(B + " cut 1> ");
					strB = strB.substring(0, strL-1);
					B = Long.parseLong(strB);
					System.out.print( " B = " +  B);
					cnt++;	
					System.out.println(" cnt = " + cnt);
				}
			}
			else {	//if 2 B의 1의자리 숫자가 짝수면 / 2
				System.out.print( B+" / 2  = " + B/2 + "\t"	);
				B = B / 2;
				cnt++;
				System.out.println(" cnt = " + cnt);
			}			
		}
		if (B == A) {
			System.out.println(cnt);
		}		
		else System.out.println("-1");		
	}
	
}


