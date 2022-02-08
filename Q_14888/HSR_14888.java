package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
  N개의 수로 이루어진 수열 A1, A2, ..., AN이 주어진다. 또, 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어져 있다.

우리는 수와 수 사이에 연산자를 하나씩 넣어서, 수식을 하나 만들 수 있다. 이때, 주어진 수의 순서를 바꾸면 안 된다.

예를 들어, 6개의 수로 이루어진 수열이 1, 2, 3, 4, 5, 6이고, 주어진 연산자가 덧셈(+) 2개, 뺄셈(-) 1개, 곱셈(×) 1개, 나눗셈(÷) 1개인 경우에는 총 60가지의 식을 만들 수 있다. 예를 들어, 아래와 같은 식을 만들 수 있다.

1+2+3-4×5÷6
1÷2+3+4-5×6
1+2÷3×4-5+6
1÷2×3-4+5+6
식의 계산은 연산자 우선 순위를 무시하고 앞에서부터 진행해야 한다. 또, 나눗셈은 정수 나눗셈으로 몫만 취한다. 음수를 양수로 나눌 때는 C++14의 기준을 따른다. 즉, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼 것과 같다. 이에 따라서, 위의 식 4개의 결과를 계산해보면 아래와 같다.

1+2+3-4×5÷6 = 1
1÷2+3+4-5×6 = 12
1+2÷3×4-5+6 = 5
1÷2×3-4+5+6 = 7
N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
*/ 

public class HSR_14888 {
		static int TIME; //TIME개의 숫자 입력
		static int[] num; // 0:덧셈, 1:뺄셈, 2:곱셉, 3:나눗셈
		static int[] opCnt;  
		static int MAX = Integer.MIN_VALUE;	// 최대값 저장
		static int MIN = Integer.MAX_VALUE; // 최솟값 저장
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//숫자 개수 입력
		String input;
		TIME = Integer.parseInt(br.readLine());		
		num = new int[TIME];		
		opCnt = new int[4];	
		
		//숫자 입력
		input = br.readLine();
		StringTokenizer inNum = new StringTokenizer(input);		
		for (int i = 0; i < TIME; i++) {			
			num[i] = Integer.parseInt(inNum.nextToken());			
		}
		
		//연산자 개수 입력
		input = br.readLine();
		StringTokenizer stOp = new StringTokenizer(input);
		for (int i = 0; i < 4; i++) {			
			opCnt[i] = Integer.parseInt(stOp.nextToken());
			
		}		
		dfs(num[0], 1);
		
		System.out.println(MAX);
		System.out.println(MIN);		
	}
	
	public static void dfs(int su, int index) { 
		
		if(index == TIME) { // index값이 숫자개수와 같아지면 리턴해준다
			MAX = Math.max(MAX, su); // 최종적인 결과 값이 su에 저장되므로 최댓값을 MAX에 저장
			MIN = Math.min(MIN, su); // 최종적인 결과 값이 su에 저장되므로 최솟값을 MIN에 저장
			
			return;
		}
		
		//연산자 4개 개수만큼 반복
		for (int i = 0; i < opCnt.length; i++) {
			
			// 
			if (opCnt[i] > 0) {
				opCnt[i]--;	
				
				if (i == 0) { // +가 나오면 su 에다 다음 번째 수를 더한 값, index +1의 값으로 dfs호출					
					dfs(su + num[index], index+1);

				}
				
				if (i == 1) { // -가 나오면 su 에다 다음 번째 수를 뺀 값, index +1의 값으로 dfs호출						
					dfs(su - num[index], index+1);					
				}
				
				if (i == 2) { // *가 나오면 su 에다 다음 번째 수를 곱한 값, index +1의 값으로 dfs호출		 				
					dfs(su * num[index], index+1);					
				}
				
				if (i == 3) { // /가 나오면 su 에다 다음 번째 수를 나눈 값, index +1의 값으로 dfs호출						
					dfs(su / num[index], index+1);					
				}				
				opCnt[i]++;	//최고 깊이까지 도달하여 돌아왔을때 연산자의 개수를 다시 원복하기 위해 사용한 만큼 돌려준다.			
			}
			
		}
		
	}
}
