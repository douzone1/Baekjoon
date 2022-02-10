import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> map = new HashMap<String, String>();
		
		int [] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // N, M
		
		for(int i=0; i<input[0]; i++) {
			String[] info = br.readLine().split(" "); // url, pwd
			
			map.put(info[0], info[1]);
		}
		
		for(int i=0; i<input[1]; i++) {
			String find = br.readLine();
			sb.append(map.get(find) + "\n");
		}
		
		System.out.println(sb);
		
		
	}
}
