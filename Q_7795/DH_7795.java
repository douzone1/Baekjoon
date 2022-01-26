package BOJ_7795;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DH_7795 {
    static int t;
    static int n, m;
    static int[] arrN, arrM;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        //tc 개수 입력
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            inputTC();
            outputTC();
        }
    }

    static void inputTC() throws IOException {

        StringTokenizer st;

        // N, M 원소 갯수 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrN = new int[n + 1];
        arrM = new int[m + 1];

        // N 원소값 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        // M 원소값 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void outputTC() {
        
        // binarySearch 실행을 위한 정렬
        Arrays.sort(arrM, 1, m+1);
        
        // 초기화
        int result = 0;        

        // 모든 N 배열 원소에 대해 탐색, result = 각 최종 mid 값의 합
        for(int i=0;i<=n;i++) {
           result += binarySearch(arrM, 1, m, arrN[i]);
        }
        System.out.println(result);
    }

    static int binarySearch(int[] arr, int left, int right, int key) {

        // 이진 탐색
        int result = left - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < key) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}