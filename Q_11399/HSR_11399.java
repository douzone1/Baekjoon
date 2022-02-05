package dailyAlgorism;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class HSR_11399 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		//대기인 순서와 인출시간을 입력할 맵 user 선언
		//해쉬 맵은 순서를 가지지 않음 하지만 key 값의 중복은 허용 x
		Map <Integer, Integer > user = new HashMap<>();
		
		//대기 인원과 각 인출시간 맵에 저장
		int man;
		int time, sum = 0, total= 0;
//		System.out.print("대기 인원 입력 : ");
		man = sc.nextInt();
		
		for (int i = 1; i <= man; i++) {
//			System.out.print("인출 시간 입력 : ");
			time =sc.nextInt();
			user.put(i, time);
		}
		
		//정렬을 위해 리스트 생성
		List<Entry<Integer, Integer>> list_entries = new ArrayList<Map.Entry<Integer,Integer>>(user.entrySet());
		
		//밸류가 낮은 순서로 오름차순
		Collections.sort(list_entries, new Comparator<Entry<Integer, Integer>>() {
			
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
				
			}
		});	

		//제어문을 통해 순서별 걸리는 시간과 사람들의 사용시간 총합 도출
		for (Map.Entry<Integer, Integer> tempEntry : list_entries) {
//			System.out.println("user1.key(" + tempEntry.getKey() + ") = " + tempEntry.getValue());
			
			//해당 순서의 사람의 걸리는 시간
//			System.out.print("sum =" + sum );			
			sum += tempEntry.getValue();
			total += sum;
			
			//걸리는 총 시간 축적
//			System.out.println(total);
		}
		System.out.println(total);
		
	}
}
