import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
			int[] array = new int[N];
			int even=0; int odd=N-1; int level = 0;
			
			for(int i=0; i<N; i++) {
				if(i%2 == 0) {
					array[even] = input[i];
					even++;
				}else {
					array[odd] = input[i];
					odd--;
				}
			}
			for(int i=0; i<N-1; i++) {
				level = Math.max(Math.abs(array[i] - array[i+1]), level);
			}
			sb.append(level + "\n");
			
		}
		System.out.println(sb);
	}
}
