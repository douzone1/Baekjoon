package BOJ_1182;

import java.util.Scanner;

public class Main {
    static int N, S, count = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
    
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, 0);

        if (S == 0) {
            System.out.println(--count);
        } else {
            System.out.println(count);
        }
        sc.close();
    }

    private static void dfs(int v, int sum) {
        if (v == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        dfs(v + 1, sum + arr[v]);
        dfs(v + 1, sum);
    }
}
