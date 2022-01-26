import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class CY_10897 {
	public static void main(String[] args) throws IOException {
		//input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String [][] infos = new String[N][4];
		for(int i=0; i<N; i++) {
			infos[i] = br.readLine().split(" ");
		}
		
		
		Arrays.sort(infos, new Comparator<String[]>() {
			public int compare(String [] o1, String[] o2) {
				/* 1순위 - 국어 내림차순
				   2순위  영어 오름차순
				   3순위 - 수학  내림차순
				   4순위 - 이름 오름차순 */
				
				if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
					if(Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
						if(Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])) {
							return o1[0].compareTo(o2[0]);
						}
						return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
					}
					return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
				}
				return (Integer.parseInt(o2[1]) - Integer.parseInt(o1[1])) ;
			}
		});


		//output
		for(int i=0; i<N; i++) {
			System.out.println(infos[i][0]);
		}
		
	}
}
