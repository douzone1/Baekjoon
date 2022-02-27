package dailyAlgorism;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HSR_2206 {
	
    private static int[] x = {1, 0, -1, 0};
    private static int[] y = {0, 1, 0, -1};
    
    private static int N;
    private static int M;
    private static int[][] map;    
    
    private static boolean[][][] isVisited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N + 1][M + 1];        
       
        isVisited = new boolean[N + 1][M + 1][2];

        scanner.nextLine();
        for (int i = 1; i <= N; i++) {
            String[] input = scanner.nextLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        bfs(1, 1);
    }

    private static void bfs(int px, int py) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(px, py, 1, 0));
        isVisited[px][py][0] = true;
        isVisited[px][py][1] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.px == N && p.py == M) {
                System.out.println(p.depth);
                return;
            }

			
            for (int i = 0; i < 4; i++) {
                int nx = p.px + x[i];
                int ny = p.py + y[i];

				// 주어진 N*M 사이즈를 벗어나지 않는지
                if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
                	if (map[nx][ny] == 1) { //방문한 위치가 벽일때
                        if (p.used == 0 && !isVisited[nx][ny][1]) { //벽을 부수지 않았고 방문하지 않은 배열이면
                            queue.add(new Point(nx, ny, p.depth + 1, 1));
                            isVisited[nx][ny][1] = true;
                        }
                    } else { // 방문한 위치가 벽이 아닌경우                       
                        if (!isVisited[nx][ny][p.used]) {	//방문 안했을때
                            queue.add(new Point(nx, ny, p.depth + 1, p.used));
                            isVisited[nx][ny][p.used] = true;
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }

    private static class Point {
        private int px;
        private int py;
        private int depth;
        private int used;

        Point(int x, int y, int depth, int used) {
            this.px = x;
            this.py = y;
            this.depth = depth;
            this.used = used;
        }
    }
}
