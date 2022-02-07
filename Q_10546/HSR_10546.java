package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HSR_10546  {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int time = Integer.parseInt(br.readLine());
		
		
		String name = "";
		//선수의 이름과 출발점 도착점을 통과한 횟수를 담을 맵 생성
		Map<String, Integer> man = new HashMap(); 
		for (int i = 0; i < (time*2) -1; i++) {
			name = br.readLine();
 
			if(man.containsKey(name)) {			//맵에 입력한 이름의 선수가 있으면 해당 키값(이름)의 밸류값을 1 더해준다.
				man.put(name, man.get(name) +1);
			}
			else {	//맵에 입력한 이름의 선수가 없으면 해당 키값(이름)의 밸류값을 1로 설정
				man.put(name, 1);
			}
		}
		
		//밸류값이 홀수일경우 완주를 못한걸로 판단되므로 출력
		for(Entry<String, Integer> ent : man.entrySet()) {
			if(ent.getValue()%2 != 0) {
				System.out.println(ent.getKey());
			}
		}		
	}
}
