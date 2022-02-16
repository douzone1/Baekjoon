package BOJ_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dot {
    int x, y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class LDH_7576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[M][N];

        Queue<Dot> q = new LinkedList<Dot>(); // 익은 토마토 넣을 큐 선언

        // 1 위치 사전입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int ripe = Integer.parseInt(st.nextToken());
                if (ripe == 1) {
                    q.add(new Dot(i, j));
                }
                tomato[i][j] = ripe;
            }
        }

        int day = 0;
        Queue<Dot> qRipe = new LinkedList<Dot>(); // 익은 토마토 넣을 큐 선언
        while (true) {
            if (q.isEmpty())
                break;
            while (!q.isEmpty()) {
                Dot dot = q.poll(); // BFS 큐 노드 뽑고
                if (dot.x < M - 1 && tomato[dot.x + 1][dot.y] == 0) { // 배열 초과 X 조건 && 노드의 x y값 CHECK
                    tomato[dot.x + 1][dot.y] = 1;
                    qRipe.add(new Dot(dot.x + 1, dot.y));
                }
                if (dot.y < N - 1 && tomato[dot.x][dot.y + 1] == 0) { // 이하 동문
                    tomato[dot.x][dot.y + 1] = 1;
                    qRipe.add(new Dot(dot.x, dot.y + 1));
                }
                if (dot.x > 0 && tomato[dot.x - 1][dot.y] == 0) { //
                    tomato[dot.x - 1][dot.y] = 1;
                    qRipe.add(new Dot(dot.x - 1, dot.y));
                }
                if (dot.y > 0 && tomato[dot.x][dot.y - 1] == 0) { //
                    tomato[dot.x][dot.y - 1] = 1;
                    qRipe.add(new Dot(dot.x, dot.y - 1));
                }
            }

            while (!qRipe.isEmpty()) {
                q.add(qRipe.poll()); // BFS 완료
            }

            day++;

            for (int[] i : tomato) {
                for (int j : i) {
                    if (j == 0) {
                        System.out.println(-1); // 처음부터 익은게 없다는 거니까 -1 출력
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(day - 1);

    }
}
