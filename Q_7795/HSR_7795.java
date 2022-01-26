package Douzone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HSR_7795 {
	public static void main(String[] args)  throws IOException {
		//심해에는 두 종류의 생명체 A와 B가 존재한다. A는 B를 먹는다. A는 자기보다 크기가 작은 먹이만 먹을 수 있다.
		//예를 들어, A의 크기가 {8, 1, 7, 3, 1}이고, B의 크기가 {3, 6, 1}인 경우에 A가 B를 먹을 수 있는 쌍의 개수는 7가지가 있다.
		//8-3, 8-6, 8-1, 7-3, 7-6, 7-1, 3-1.
		
		//시간 초과로 Scanner보다 빠른 BufferedReader사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//정수배열에 값 넣기 위해 토큰 생성 및 정수배열 생성
		StringTokenizer st;		
		int[] arrA, arrB;
		
		//반복 수행횟수 입력
		int time = Integer.parseInt(br.readLine());
		
		while(time-- > 0) {
			
			int cnt = 0;
			
			//각 배열 크기 선언
			st = new StringTokenizer(br.readLine());
			arrA  = new int[Integer.parseInt(st.nextToken())];
			arrB  = new int[Integer.parseInt(st.nextToken())];
			
			//형변환 하여 값 삽입
			st = new StringTokenizer(br.readLine());
			for(int i=0; i < arrA.length; i ++) {
				arrA[i]= Integer.parseInt(st.nextToken());				
			}			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i < arrB.length; i ++) {
				arrB[i]= Integer.parseInt(st.nextToken());				
			}
			//Arrays 클래스를 통해 오름차순 정렬
			Arrays.sort(arrB);
			
			//arrA의 배열개수 만큼 이진탐색을 이용하여 더 낮은 숫자가 몇개인지 확인
			for(int i = 0; i < arrA.length; i++) {				
				cnt += binarySearch(arrB ,arrA[i], 0 , arrB.length - 1);				
			}
			System.out.println(cnt);		
		}				
	}
	
	//이진탐색 메소드
	static int binarySearch(int[] arrB, int key, int low, int high) {
		//중앙값 생성
		int mid;		 
		
		//시작위치가 종료위치보다 같거나 낮을때 계속 실행
		while(low <= high) {
			//시작위치와 종료위치의 절반을 중앙으로 설정
			mid = (low + high) / 2;
			
			//key값이 arrB[mid] 시작위치와 종료위치 중앙의 배열의 값보다 크면 시작위치 mid + 1 (정렬되어있는 값이라 해당 위치 아래의 값은 전부 낮음)
			if(key > arrB[mid])
				low = mid + 1;
			//key값이 arrB[mid] 시작위치와 종료위치 중앙의 배열의 값보다 작거나 같으면 종료위치  (정렬되어있는 값이라 해당 위치 아래의 값은 전부 높음)  
			else
				high = mid -1;
		}
		//결국 시작위치low의 값은 key값 보다 작고 다음 상위 위치의 값보단 작은 위치값  나옴
		return low;
	}	
}
