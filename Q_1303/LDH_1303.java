package BOJ_1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, w = 0, b = 0;
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    static boolean[][] visit = new boolean[101][101], map = new boolean[101][101];

    static int DFS(int y, int x, boolean W){

        int count = 1;
        visit[x][y] = true;

        for(int a=0; a<4; a++){
            int nx = x+dx[a];
            int ny = y+dy[a];

            if(nx < 1 || ny < 1 || nx > m || ny > n || visit[nx][ny] || map[nx][ny] != W) continue;

            count += DFS(nx, ny, W);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++){
            char[] str = br.readLine().toCharArray();

            for(int j=1; j<=m; j++)
                map[i][j] = str[j-1] == 'W';
        }

        for(int i=1; i<=n; i++)
            for(int j=1; j<=m; j++)
                if(!visit[i][j]){
                    if(map[i][j])
                        w += Math.pow(DFS(i, j, map[i][j]), 2);
                    else
                        b += Math.pow(DFS(i, j, map[i][j]), 2);
                }

        System.out.println(w + " " + b);
    }
}
