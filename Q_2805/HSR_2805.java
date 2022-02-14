package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HSR_2805 {
	public static void main(String[] args) throws IOException {
		//입력부 세팅
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0, height = 0, start = 0, end = 0;
		st = new StringTokenizer(br.readLine());
		int[] tree = new int[Integer.parseInt(st.nextToken())];
		int amount = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());		
		for (int i = 0; i < tree.length; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		//이분 탐색을 하기 위해 정렬
		Arrays.sort(tree);
		
		//나무의 최대높이 구해서 end로 설정
		end = tree[tree.length-1];		
		System.out.println( "amount = " + amount);		
		while(start <= end) {
			System.out.println("start = " + start + ", end = " + end);
			sum = 0;
			int mid = (start + end) /2;
			System.out.println("mid = " + mid);		
		
			for (int item : tree) {
				if(item > mid) {
					sum += item - mid;
				}
			}
			
			//sum이 amount보다 크면 나무를 최소량보다 많이가져가는지 확인해야함
			if(sum >= amount) {
				System.out.println("sum = " + sum);
				start = mid + 1;
			} else {	//sum이 amount보다 작으면  
				end = mid -1;
			}
		}
		System.out.println(end);

		
		
		
	
	}
	
}
