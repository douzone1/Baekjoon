package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class HSR_17219 {
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, String> map = new HashMap<String, String>();
		StringTokenizer st;
		int info, time;
		st = new StringTokenizer(br.readLine());		
		info = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < info; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		for (int i = 0; i < time; i++) {
			String url =br.readLine();
			if(map.containsKey(url)) {
				System.out.println(map.get(url));
			}
		}
	}
}
