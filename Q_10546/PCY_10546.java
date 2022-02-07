import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Hashtable <String,Integer> ht = new Hashtable<String,Integer>();
		
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String name = br.readLine();
			if(ht.containsKey(name)) {
				ht.replace(name,  ht.get(name) + 1);
			}else {
				ht.put(name,1);
			}
		}
    
		for(int i=0; i<N-1; i++) {
			String target = br.readLine();
			if(ht.containsKey(target)) {
				ht.replace(target, ht.get(target) - 1);
			}
		}
		
		for(Entry<String,Integer> e : ht.entrySet()) {
			if(e.getValue() == 1) {
				sb.append(e.getKey());
				break;
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
