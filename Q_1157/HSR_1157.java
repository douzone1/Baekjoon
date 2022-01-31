package quiz;

import java.util.Scanner;

public class HSR_1157 {	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String inpStr;
			int num,max=-1;
			int[] ALPHABET;
			char result='?';
			ALPHABET = new int[26];
			inpStr = sc.next();
			for (int i=0; i < inpStr.length(); i++) {
				num = (int)inpStr.charAt(i);
				if(num > 96) {
					num -=32;
				}
				ALPHABET[num-65] +=1;
			}
			
			for(int i=0; i<ALPHABET.length; i++) {
				if(ALPHABET[i]>max) {
					max=ALPHABET[i];
					result= (char)(i+65);
				}
				else if(ALPHABET[i]==max) {
					result = '?';
				}			
			}
			System.out.println(result);
			
			
		}
}

