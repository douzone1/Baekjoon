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
	}
}
