package BOJ_2573;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
class IceBerg {
    int x;
    int y;
 
    IceBerg(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class LDH_2573 {
    static int[] dX = { -1, 0, 1, 0 };
    static int[] dY = { 0, 1, 0, -1 };
 
    static int N, M;
    static int[][] map;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        int ans = 0;
        int count = 0;
 
        // 2개 이상 분리시 종료 + 모든 원소가 0이면 0 출력
        while ((count = SeparateNum()) < 2) {
            if (count == 0) {
                ans = 0;
                break;
            }
 
            Melt();
            ans++;
        }
 
        System.out.println(ans);
        br.close();
    }
 
    // 나눠진거 몇개? -> DFS
    public static int SeparateNum() {
        boolean[][] visited = new boolean[N][M];
 
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
 
    public static void DFS(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
 
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dX[i];
            ny = y + dY[i];
 
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
 
            if (map[nx][ny] != 0 && !visited[nx][ny]) {
                DFS(nx, ny, visited);
            }
        }
    }
 
    // BFS
    public static void Melt() {
        Queue<IceBerg> q = new LinkedList<>();
 
        // 중복되어 삭제되는 문제(인접 바다)를 방지하기 위한 visited 배열
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    q.offer(new IceBerg(i, j));
                    visited[i][j] = true;
                }
            }
        }
 
        int dx, dy;
        while (!q.isEmpty()) {
            IceBerg ice = q.poll();
 
            int seaNum = 0; // 인접 바다 영역
 
            for (int i = 0; i < 4; i++) {
                dx = ice.x + dX[i];
                dy = ice.y + dY[i];
 
                if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
                    continue;
                }
 
                if (!visited[dx][dy] && map[dx][dy] == 0) {
                    seaNum++;
                }
            }
 
            if (map[ice.x][ice.y] - seaNum < 0) {
                map[ice.x][ice.y] = 0;
            } else {
                map[ice.x][ice.y] -= seaNum;
            }
        }
    }
}
