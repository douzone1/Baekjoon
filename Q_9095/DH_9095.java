package BOJ_9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DH_9095 {
    static int t, N;
    static int[] arr = new int[12];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        //tc 개수 입력
        t = Integer.parseInt(br.readLine());

        arr[0]= 0;
        arr[1]= 1;
        arr[2]= 2;
        arr[3]= 4;
        arr[4]= 7; 
        
        for(int i=0; i<t; i++) {
            inputTC();
            outputTC();
        }
    }

    static void inputTC() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=5;i<11;i++) {
            // 점화식
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3]; 
        }
        
    }

    static void outputTC() throws IOException {
        System.out.println(arr[N]);
    }
}