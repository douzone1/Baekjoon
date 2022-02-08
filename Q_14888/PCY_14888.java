import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N = 0;
	static int MIN = Integer.MAX_VALUE;
	static int MAX = Integer.MIN_VALUE;
	static int [] nums ;
	
	public static void DFS(int depth, int total, int plus, int minus, int multiply, int divide) {
		if(depth == N) {
			MIN = Math.min(MIN, total);
			MAX = Math.max(MAX, total);
			return;
		}
		
		if(plus > 0) DFS(depth+1, total+nums[depth], plus-1, minus, multiply, divide);
		if(minus > 0) DFS(depth+1, total-nums[depth], plus, minus-1, multiply, divide);
		if(multiply > 0) DFS(depth+1, total*nums[depth], plus, minus, multiply-1, divide);
		if(divide > 0) DFS(depth+1, total/nums[depth], plus, minus, multiply, divide-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		 N = Integer.parseInt(br.readLine());
		 nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int [] op = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		DFS(1,nums[0],op[0],op[1],op[2],op[3]);
		sb.append(MAX + "\n"); sb.append(MIN);
		
		System.out.println(sb);
		br.close();
		
	}
}
