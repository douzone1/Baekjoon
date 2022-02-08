package BOJ_14888;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LDH_14888 {

    static int T;
    static int data[]; // 데이터 배열
    static int op[]; // 연산자 배열
    static int max = -1000000000;
    static int min = 1000000000;
    static int res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // TC 개수
        T = Integer.parseInt(br.readLine());

        int data[] = new int[T]; // 데이터 배열
        int op[] = new int[4]; // 연산자 배열

        // 데이터 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < data.length; i++) {

            data[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < op.length; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        
        dfs(data, op, data[0], 1);

        bw.write(max+"\n");
        bw.write(min+"");
        bw.flush();
        bw.close();
    }

    public static void dfs(int[] data, int[] op, int num, int depth) {

        // 재귀 마지막단
        if (depth == T) {
            max = Math.max(max, num);
            min = Math.min(max, num);
            return;
        }

        // 연산자 소비
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                dfs(data, op, calc(num, data[depth], i), ++depth);
                op[i]++;
            }
        }
    }

    // 계산
    public static int calc(int x, int y, int op) {
        switch (op) {
            case 0:
                res = x + y;
                return res;
            case 1:
                res = x - y;
                return res;
            case 2:
                res = x * y;
                return res;
            case 3:
                if (x < 0) {
                    res = -(-x / y);
                } else {
                    res = x / y;
                }
                return res;
        }
        return res;

    }

}