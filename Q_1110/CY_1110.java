import java.io.*;

public class Main_1110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N = br.readLine();
		String number = N;
		int count = 0;
		
		while(true) {
			int temp = 0; 
			// 각 자리수의 합
			for(char a : number.toCharArray()) {
				temp += Character.getNumericValue(a);
			}
			String strTemp = String.valueOf(temp); // 자릿수 합 문자열 변환 
			// 이전 문자열의 가장 끝 문자 + 자릿수 합의 끝 문자
			 number = Character.toString(number.charAt(number.length() -1)) + Character.toString(strTemp.charAt(strTemp.length()-1));
			
			if(Integer.parseInt(number) == Integer.parseInt(N)) {
				count++;
				break;
			}else{
				count++;
			}
		}
		sb.append(count);
		System.out.println(sb);
		br.close();
	}
}
