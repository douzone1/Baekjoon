package BOJ_1110;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LDH_1110 {

    public static void main(String args[]) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());;
        int tmp = N;
        int count = 0;

        while (true) {
            N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
            count++;

            if(tmp==N) {
                break;
            }
        }

        System.out.println(count);

    }
}