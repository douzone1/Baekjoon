package quiz;

import java.util.Scanner;

public class HSR_2443 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		String star = "";
		for(int i = cnt - 1; i >= 0; i--){
			star = "";			
			for(int j = 1; j < cnt - i; j++) {
				star +=" ";				
			}			
			for(int j = 0; j < (i * 2) + 1; j++) {				
				star += "*";
			}			
			System.out.println(star);			
		}
	}
}
