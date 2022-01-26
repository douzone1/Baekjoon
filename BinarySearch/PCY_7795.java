import java.io.*;
import java.util.*;

public class Main {
	public static int binarySearch(int start, int end, int target, int[] array) {
		while(start <= end) {
			int mid = (start + end) / 2;
			if( (target) > (array[mid])) {
				start = mid +1;
			}
			else {
				end = mid -1;
			}
		}
		return start;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		int T = Integer.parseInt(br.readLine());

		
		while(T-->0) {
			int [] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			
			int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray(); 
			int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			int result = 0;
			
			Arrays.sort(B);

			for(int i=0; i<A.length; i++) {
				result += binarySearch(0,B.length-1,A[i], B );
			}
			
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}

}
