import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int [] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = info[0]; int M = info[1];
		int [] trees = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		
		// 나무의 최소길이 0 ~ 최대길이 (tree 중 최대 길이) 값을 반으로 줄이면서 탐색(이진탐색)  
		long start = 0; long end = trees[N-1];
		long mid = 0;
		
		while(start<=end) {
			 mid = (start + end ) /2;
			long saw = 0;
			for(int item : trees){
				if(item > mid) saw += (item - mid);
			}
			if(saw >= M) start = mid + 1;
			else if(saw < M) end = mid -1;
		}
		
		System.out.println(end);
	}
}
