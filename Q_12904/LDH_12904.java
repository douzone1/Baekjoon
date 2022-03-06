package BOJ_12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        StringBuilder sb = new StringBuilder(T);

        // 같은 길이가 될 때 까지 연산
        while (S.length() < sb.length()) {
            char c = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);   // 끝 문자 삭제

            if (c == 'B') { // 끝 문자 B일 시 reverse 실행
                sb.reverse();
            }
        }

        // 최종적으로 같은지
        if (S.equals(sb.toString())) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
