package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HSR_12904 {
	                                                                                  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		StringBuffer S = new StringBuffer(br.readLine());
		StringBuffer T = new StringBuffer(br.readLine());
				
		int result = 0;
		while(S.length() < T.length()) {	//문자열 크기가 같아질 때 까지
			if(T.charAt(T.length() - 1) == 'A') {	//역 방향으로 A이면 제거 
				T.deleteCharAt(T.length()-1);	//선택한 인덱스 위치 문자 삭제
			}
			else if(T.charAt(T.length() - 1) == 'B') {	//B이면 제거 후 뒤집기
				T.deleteCharAt(T.length()-1);	//선택한 인덱스 위치 문자 삭제
				T.reverse();	//문자열 뒤집기
			}
		}
		if(S.toString().equals(T.toString())) result = 1;
		else result = 0;
		System.out.println(result);
	}
}
