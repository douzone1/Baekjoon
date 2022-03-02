package BOJ_11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            
            int[] arr = new int[M+1];
            int max = 0;
            long sum = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = M - 1; j >= 0; j--) 
                if (arr[j] > max)
                    max = arr[j];
                else
                    sum += (max - arr[j]);
            }
            System.out.println(sum);
        }
        br.close();
    }
}
