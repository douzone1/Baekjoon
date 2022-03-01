import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer =0;
		int N = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>A = new ArrayList<Integer>(N);
		ArrayList<Integer> B = new ArrayList<Integer>(N);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}		
		
		Collections.sort(A);
		Collections.sort(B, Collections.reverseOrder());
		
		for(int i=0; i<N; i++) {
			answer +=(A.get(i) * B.get(i));
		}
		
		System.out.println(answer);
	}
}
