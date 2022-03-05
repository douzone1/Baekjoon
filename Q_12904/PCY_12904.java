import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		int i = T.length()-1;
		
		
		while(true) {
			
			if(T.charAt(i) == 'B') {
				StringBuffer sb = new StringBuffer(T);
				String tempT = sb.reverse().toString(); // 역순
				T = tempT.substring(1); // 'B' 제거
			}
			
			else {
				T = T.substring(0, T.length()-1); // 'A' 제거
			}
			
			if(T.equalsIgnoreCase(S)) {
				System.out.println(1);
				System.exit(0);
			}
			if(T.length() == S.length()) break;
			i--;
		}
		
		System.out.println(0);
	}
}
