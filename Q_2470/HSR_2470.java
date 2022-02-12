package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HSR_2470 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//투포인터를 이용할 시작점 끝점과 조건에 이용할 합
		int start=0, end=0, sum=0, min = Integer.MAX_VALUE, resultS = 0, resultE = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		System.out.print("용액 개수 입력 : ");
		Integer [] solution = new Integer [Integer.parseInt(br.readLine())];		
		System.out.print("용액 값 입력 : ");		
		StringTokenizer st = new StringTokenizer(br.readLine());		
		for (int i = 0; i < solution.length ; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}
		
		//투포인터 알고리즘을 이용하기 위해 오름차순으로 정렬
		Arrays.sort(solution);
		
		//정렬된 배열 출력
//		for(Integer item : solution	) {
//			System.out.println(item);
//		}
		
		//탐색할 배열의 마지막 번호 지정
		end = solution.length-1;
		
		//시작점과 종료점이 만나면 탐색 종료
		while(start < end) {
			//두용액의 합을 확인할 sum
			sum = solution[start] + solution[end];
			
			//sum이 0이면 원하는 값을 얻었으니 반복문 탈출			
			if(sum == 0) {
				resultS = solution[start];
				resultE = solution[end];
				break;
			}
			
			//만약 절댓값 sum이 min보다 작다면 min에다가 해당값을 넣고 시작점, 종료점 저장
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				resultS = solution[start];
				resultE = solution[end];
			}
			
			//sum의 값이 양수이면 0에 근접하기 위해 값을 줄여야 함
			if(sum > 0) {
				end--;
			}
			
			else {	//sum의 값이 음수이면 0에 근접하기 위해 값을 늘려야함 *0일 경우는 이미 걸러진다
				start ++;
			}			
		}
		System.out.println(resultS + " " + resultE);
	}
	
}
