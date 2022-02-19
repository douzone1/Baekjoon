import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HSR_2002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0, overtake = 0;
		String carNum = "";
		System.out.print("지나간 차의 수 : ");
		N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> car = new HashMap<>();
		for (int i = 1; i <= N; i++) {	
			car.put(br.readLine(), i );			
		}
		
		for (int i = 1; i <= N ; i++) {			
			carNum = br.readLine();	
			System.out.println("i = " + i + "  "+carNum + " " +car.get(carNum));
			if(car.get(carNum) > i) {
				System.out.println("추월차량 발견");
				overtake++;
			}
		}
		System.out.println("추월한 차의 수 : " + overtake);
		
		
//		//맵으로 들어오는 자동차 순서 확인
//		HashMap<Integer, String> car = new HashMap<>();
//		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>();
//		N = Integer.parseInt(br.readLine());
//		
//		for (int i = 0; i < N; i++) {	
//			linkedMap.put(i, br.readLine());			
//		}
//		for (Map.Entry<Integer, String> item : linkedMap.entrySet() ) {
//			System.out.println(item.getKey() + " : " + item.getValue());
//		}
//		
			
	}
}

//추월을 하면 순서가 뒤로 밀려난다.
//변경된 순서를 저장할 해쉬맵을 만들어야 한다?

//4
//ZG431SN 1
//ZG5080K 2
//ST123D 3
//ZG206A 4
//ZG206A 4 -> 1
//ZG431SN 1 -> 2
//ZG5080K 2 -> 3 
//ST123D 3 -> 4
// output = 1

//5
//ZG508OK	1
//PU305A	2	
//RI604B	3
//ZG206A	4
//ZG232ZF	5
//PU305A	2 -> 1
//ZG232ZF	5 -> 2 
//ZG206A	4 -> 3
//ZG508OK	1 -> 4
//RI604B	3 -> 5
// output =3