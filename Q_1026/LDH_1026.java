package BOJ_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());;
        }

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            B[i] = Integer.parseInt(st.nextToken());;
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        int i=0;
        int j=N-1;
        while(i<N) {
            sum += A[i] * B[j];
            i++;
            j--;
        }

        System.out.println(sum);

    }
}
