package BOJ_16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LDH_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int count = 1;
        // int blength = (int) (Math.log10(B) + 1);

        // long c = B % (long) Math.pow(10, blength - 1); // B의 1의자리

        while (A != B) {
            if (A > B) {
                count = -1;
                break;
            }

            if (B%2 == 0) { // 1 2 4 8 16 32 ... -> 1 2 4 8 6 2 4 8 6 ...
                B >>= 1;
            } else if (B%10 == 1) {
                B /= 10;
            } else {
                count = -1;
                break;
            }

            count++;
        }
        System.out.println(count); // 여기서 count+1하면 -1이 0이됨

    }
}
