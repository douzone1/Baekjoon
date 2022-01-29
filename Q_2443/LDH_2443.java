package BOJ_2443;

import java.util.Scanner;

public class LDH_2443 {
    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        invertedPyramid(N);
        
        sc.close();
    }

    private static void invertedPyramid(int N) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = (N - i + 1) * 2 - 1; j >= 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}
