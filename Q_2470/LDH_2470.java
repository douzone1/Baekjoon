/**
 * 투포인터 문제였음
 */
package BOJ_2470;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LDH_2470 {

    static int resL;
    static int resR;
    static int min = 2000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l=0;
        int r=arr.length-1;
        while (l<r) {
            int sum = arr[l] + arr[r];
            if(sum==0) { // 조기 탈출
                resL = arr[l];
                resR = arr[r];
                break;
            }
            if(min > Math.abs(sum)) { // 결정문 (0에 가까워짐을 판별)
				min = Math.abs(sum);
				resL = arr[l];
				resR = arr[r];
			}
            if(sum<0) { // 반복문
                l++;
            } else { // 반복문
                r--;
            }
        }

        System.out.println(resL+" "+resR);
    }
}