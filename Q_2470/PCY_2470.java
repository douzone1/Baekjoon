import java.io.*;
import java.util.Arrays;

public class Main {
	public static int MIN = Integer.MAX_VALUE;
	public static int result1 =0 ,result2 = 0;
	
	public static int TwoPointer(int N,  int [] array) {
		int start = 0; int end = N-1;
		
		while(start<end) { // 종료조건: start와 end가 교차될 때
			int sum = array[start] + array[end];
			
			if(Math.abs(sum) < MIN) {
				MIN = Math.abs(sum);
				result1 = array[start];
				result2 = array[end];
			}
			
			if(sum >0) end--; // sum이 0보다 크면 array[start] < array[end] 이므로 end의 위치를 줄여야 0에 가까워짐
			else start++;
			
		}
		
		return array[start];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] values = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray(); // 오름차순 정렬
		
		TwoPointer(N, values);
		
		System.out.print(result1 + " " + result2);
		br.close();
		
	}
}
