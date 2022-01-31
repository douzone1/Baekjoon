package quiz;

import java.util.Scanner;

public class HSR_2442 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		String star = "";
		for(int i =1; i <= cnt; i++) {
			star = "";			
			
			for(int j = 0; j < cnt - i; j++) {
				star +=" ";				
			}			
			for(int j = 0; j < (i * 2) - 1; j++) {				
				star += "*";
			}			
			System.out.println(star);			
		}
	}
}
