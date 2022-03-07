package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class HSR_19621 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int s, e, p;
		int[] dp;
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N];		
		
		Meeting[] m = new Meeting[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			m[i] = new Meeting(s, e, p);
		}
		Arrays.sort(m, new Comparator<Meeting>() {	//회의 시간 정렬
			@Override
			public int compare(Meeting o1, Meeting o2) {
				// TODO Auto-generated method stub
				if(o1.getS() > o2.getS()) {	return 1; }
				else if(o1.getS() < o2.getS()) { return -1; } 
				else return 0;				
			}		
		});
		
		dp[0] = m[0].getP();	//i번까지 참여하는 회의인원 합 담을 배열
		int result = 0;
		if (N == 1)	//1개만 있을경우 그대로 result에 입력
			result = dp[0];
		if (N >= 2) { //2개 있을경우 큰 쪽을 result에 입력 > Math.max() 함수로 큰수 입력
			dp[1] = m[1].getP();
			result = Math.max(dp[0], dp[1]);
		}
		for (int i = 2; i < N; i++) {	//3개 이상일때
			 System.out.println(Arrays.toString(dp));
			for (int j = i - 2; j >= 0; j--) {	//인접한 회의는 시작과 끝시간이 겹친다는 전제가 있었기 때문에 2번째 전 회의에 추가
				dp[i] = Math.max(dp[j] + m[i].getP(), dp[i]);
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
		
		
	}
}
class Meeting{
	private int s;
	private int e;
	private int p;
	
	public int getS() {
		return s;
	}

	public int getE() {
		return e;
	}

	public int getP() {
		return p;
	}

	public void setS(int s) {
		this.s = s;
	}

	public void setE(int e) {
		this.e = e;
	}

	public void setP(int p) {
		this.p = p;
	}

	Meeting(int s, int e, int p) {
		this.s = s;
		this.e = e;
		this.p = p;
 	}
}
