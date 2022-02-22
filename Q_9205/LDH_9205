package BOJ_9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dot {
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        ArrayList<Dot> a; // 각 정점의 위치를 저장할 배열
        ArrayList<ArrayList<Integer>> graph;

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            a = new ArrayList<>();

            // 집, 편의점, 페스티벌 위치 정보 저장
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                a.add(new Dot(x, y));
            }

            graph = new ArrayList<>();
            for (int i = 0; i < N + 2; i++) {
                graph.add(new ArrayList<>());
            }

            // 맨해튼 거리 1000m 이하를 만족하는 두 정점을 찾고
            // 대칭 그래프 연결
            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (Manhattan(a.get(i), a.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            sb.append((BFS(graph, N) ? "happy" : "sad") + '\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static int Manhattan(Dot d1, Dot d2) {
        return Math.abs(d1.x - d2.x) + Math.abs(d1.y - d2.y);
    }

    public static boolean BFS(ArrayList<ArrayList<Integer>> graph, int N) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        boolean[] visited = new boolean[N + 2];
        visited[0] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == N + 1) {
                return true;
            }
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return false;
    }

}
