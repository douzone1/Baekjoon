package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class ShortCut implements Comparable<ShortCut> {
	int start;
	int end;
	int distance;
	
	public ShortCut(int start, int end, int distance) {
		// TODO Auto-generated constructor stub
		this.start= start;
		this.end = end;
		this.distance = distance;
	}
	@Override
	public int compareTo(ShortCut o) {
		if (this.start < o.start) {
			return -1;
		}
		return 1;
	}
}

public class HSR_1446 {
	
	static int N;
	static int D;
	static int[] movedDistance;
	static ShortCut[] shortCuts;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		movedDistance = new int[ D + 1];
		shortCuts = new ShortCut[N];		
		//초기화
		Arrays.fill(movedDistance, Integer.MAX_VALUE);		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());		 
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			 
			shortCuts[i] = new ShortCut(start, end, dist);
		}		
		Arrays.sort(shortCuts);		
		int nowDistance = 0;
		int nowIndex = 0;
		movedDistance[0] = 0;
		
		while(nowDistance < D) {			
			while(nowIndex < N) {					
				if(shortCuts[nowIndex].start != nowDistance) {
					break;
				}				
				if(shortCuts[nowIndex].end <= D) {					
					int goShortCutDistance = movedDistance[nowDistance] + shortCuts[nowIndex].distance;				
					if (goShortCutDistance < movedDistance[shortCuts[nowIndex].end]) {
						movedDistance[shortCuts[nowIndex].end] = goShortCutDistance;
					}					
				}				
				nowIndex++;
			}				
			if(movedDistance[nowDistance] + 1 < movedDistance[nowDistance + 1]) {
				movedDistance[nowDistance + 1] = movedDistance[nowDistance] + 1;
			}						
			nowDistance++;
		}
		System.out.println(movedDistance[D]);		 		 
	}
	
}
