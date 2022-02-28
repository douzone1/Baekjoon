package BOJ_2178;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
    static int[][] map;
    static int N,M;
    static int[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(visited[N-1][M-1]);
    }
    static void bfs(int x, int y) {
        Queue<Dot> queue = new LinkedList<>();
        visited[x][y] = 1;
        queue.offer(new Dot(x, y));
        while (!queue.isEmpty()) {
            Dot dot = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (visited[nx][ny] == 0 && map[nx][ny] == 1) {
                        queue.offer(new Dot(nx, ny));
                        visited[nx][ny] = visited[dot.x][dot.y] + 1;
                    }
                }
            }
        }
    }
}
class Dot {
    int x;
    int y;
    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
