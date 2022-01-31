package quiz;

import java.util.Scanner;

public class HSR_1110 {
	public static void main(String [] args) {
		int num,copy_num,cnt=0;
		Scanner sc = new Scanner(System.in);
		
		num=sc.nextInt();
		copy_num=num;
		do 
		{				
			num=((num%10)*10)+(((num/10)+(num%10))%10);
			cnt++;
		}while(num!=copy_num);
		System.out.println(cnt);
	}
}