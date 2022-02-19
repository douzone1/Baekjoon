import java.io.*;
import java.util.Collections;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, String> map = new HashMap<Integer, String>(); // 들어온 순서 - 차량
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		String[] output = new String[N]; // 나오는 차량

		for(int i=0; i<N; i++) {
			map.put(i, br.readLine());
		}
		
		for(int i=0; i<N; i++) {
			output[i] = br.readLine();
		}
		
		for(int i=0; i<N; i++) {		
			int expect = Collections.min(map.keySet()); // 들어온 순서 중 가장 작은 값을 기대차량
			int target = getKey(map, output[i]); // 터널에서 나간 차량
			 
			if(expect < target) { // 차량 추월
				answer += 1;
			}
			map.remove(target); // 차량 제거
		}
		System.out.println(answer);
		
	}
	
  // value에 해당하는 key 찾기
	public static <K, V> K getKey(HashMap<K, V> map, V value) {
		for(K key : map.keySet()) {
			if(value.equals(map.get(key))) {
				return key;
			}
		}
		return null;
	}
}
