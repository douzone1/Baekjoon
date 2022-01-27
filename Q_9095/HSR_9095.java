package Douzone;

import java.util.Scanner;

public class HSR_9095 {
	public static void main(String[] args) {
//		정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
//
//		5-> 1+4 2+3 3+2 ={ 7 + 4 + 2 }  
//		6-> 1+5 2+4 3+3 ={ 13 + 7 + 4 } 
//		7-> 1+6 2+5 3+4 = { 24 + 13 + 7 }
//		8-> 1+7 2+6 3+5 = { 44 + 24 + 13 }
		
//		정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
//		첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
		//각 숫자별 중복이 중복없는 경우의 수  출력?
		
		
		int input = new Scanner(System.in).nextInt();
		
		int[] sum = new int[11];
		sum[1] = 1; // 1 = { 1 }  1개
		sum[2] = 2; // 2 = { 1+1, 2}   2개
		sum[3] = 4; // 3 = { 1+1+1, 1+2, 2+1, 3}    4개
		//sum[4] = 7
		//sum[5] = sum[2] + sum[3] + sum[4]
		for (int i = 0; i < input; i++) {
            int num = new Scanner(System.in).nextInt();
            for (int j = 4; j <= num; j++) {
                sum[j] = sum[j - 1] + sum[j - 2] + sum[j - 3];
            }
            System.out.println(sum[num]);
        }
    }
	
	
}
