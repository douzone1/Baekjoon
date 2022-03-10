package BOJ_11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N + 1];
        int len[] = new int[N + 1];

        len[1] = 1;

        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= N; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && len[i] <= len[j]) {
                    len[i] = len[j] + 1;
                } else if (arr[i] == arr[j]) {
                    len[i] = len[j];
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++)
            ans = Math.max(len[i], ans);

        System.out.println(ans);

        br.close();
    }
}
