import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Map.Entry;

public class Main_1157  {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String msg = br.readLine();
		
		sb.append(answer(msg.toUpperCase()));
		System.out.println(sb);
		br.close();
		
	}
	
	public static char answer(String m) {
		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		int MAX_VALUE = Integer.MIN_VALUE;
		int count = 0; char result=' ';
		
		for(char a : m.toCharArray()) {
			if(ht.containsKey(a)) {
				int tmp = ht.get(a);
				ht.replace(a, tmp+1);
			}else {
				ht.put(a,1);
			}
		}
		
		// 해시테이블 최대값 구하기
		for(Entry<Character, Integer> e : ht.entrySet()) {
			if(e.getValue() > MAX_VALUE) {
				MAX_VALUE = e.getValue();
			}
		}
		
		// 최대값과 동일한 문자 및 개수 구하기
		for(Entry<Character, Integer> e :ht.entrySet()) {
			if(MAX_VALUE == e.getValue()) {
				result = e.getKey();
				count++;
			}
		}
		// 1개이면 해당 문자 반환, 여러개이면 '?' 반환
		if(count > 1) return '?';
		else return result;
	}
	
}
