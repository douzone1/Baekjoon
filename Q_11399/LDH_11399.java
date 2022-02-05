package BOJ_11399;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LDH_11399 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());;
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[T];
        int[] arrSum = new int[T];

        for (int i=0; i<T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());;
        }

        Arrays.sort(arr);

        int sum=0;
        for (int i=0;i<arr.length;i++) {
            sum += arr[i];
            arrSum[i] = sum;
        }

        int ans=0;
        for (int i=0;i<arrSum.length; i++) {
            ans += arrSum[i];
        }

        System.out.println(ans);

    }
}
