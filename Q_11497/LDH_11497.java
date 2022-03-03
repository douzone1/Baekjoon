package BOJ_11497;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] L = new int[N];
            st = new StringTokenizer(br.readLine());
            
            for(int i=0; i<N; i++) {
                L[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(L);

            // 홀-짝 배열 크기 차이 대비
            int slot = 0;
            if(N%2==0) {
                slot = N/2;
            } else {
                slot = N/2+1;
            }

            // 분할 계산
            int sub1[] = new int[N/2+1];
            int sub2[] = new int[slot];

            // 각 배열에 분할 값 입력
            int j=0;
            for(int i=0; i<sub1.length; i++) {
                if (N != 2 && N !=4) {
                    if (j>sub1.length+1) {
                        break;
                    }
                    sub1[i] = L[j];
                    j+=2;
                }
                if (N == 2) {
                    sub1[0] = L[0];
                }
                if (N == 4) {
                    sub1[0] = L[0];
                    sub1[1] = L[2];
                }

            }

            // 각 배열에 분할 값 입력
            j=1;
            for(int i=1; i<sub2.length; i++) {
                sub2[i-1] = L[j];
                j+=2;
            }
            
            // 본 배열의 중앙값이 될 max를 각 배열의 length-1 칸에 넣어줌
            sub1[sub1.length-1] = L[N-1];
            sub2[sub2.length-1] = L[N-1];

            int ans1 = 0, ans2 = 0;

            // // sub배열 출력값 테스트
            // System.out.println();

            // for (int item : sub1) {
            //     System.out.println(item);
            // }

            // System.out.println();

            // for (int item : sub2) {
            //     System.out.println(item);
            // }

            // 최소값 계산
            for (int i=sub1.length-1; i>0; i--) {
                if (sub1[i]-sub1[i-1] > ans1)
                ans1 = sub1[i]-sub1[i-1];
            }

            // 최소값 계산
            for (int i=sub2.length-1; i>0; i--) {
                if (sub2[i]-sub2[i-1] > ans2)
                ans2 = sub2[i]-sub2[i-1];
            }

            // 둘 중 큰 값을 최종 출력
            if (ans1>ans2) {
                System.out.println(ans1);
            } else {
                System.out.println(ans2);
            }
        }
    }
}
