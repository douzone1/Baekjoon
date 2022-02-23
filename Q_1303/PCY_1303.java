import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
   int x;
   int y;
   
   Point(int x, int y){
      this.x = x;
      this.y = y;
   }
}

public class Main {
   public static int N, M, W, B, resultW, resultB ; // 가로, 세로, 흰색 병사, 파란색 병사, 흰색 위력, 파란색 위력
   public static int[][] check; // 방문체크
   public static ArrayList<ArrayList<Character>> map; // 그래프
   public static int[][] direction = {{0,-1},{0,1},{-1,0},{1,0}}; // 이동(상하좌우)
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken()); // 가로(column)
      M = Integer.parseInt(st.nextToken()); // 세로(row)
      map = new ArrayList<ArrayList<Character>>(M);
      check = new int[M][N];
      
      for(int i=0; i<M; i++) {
         map.add(new ArrayList<Character>());
      }
      
      for(int i=0; i<M; i++) {
         char[] road = new StringTokenizer(br.readLine()).nextToken().toCharArray();
         for(char c: road) {
            map.get(i).add(c);
         }
         
      }
      
      
      //  bfs탐색 :모든 위치 탐색(방문하지 않는 위치에서)
      for(int i=0; i<M; i++) {
         for(int j=0; j<N; j++) {
            if(check[i][j] == 0) {
               if(map.get(i).get(j) == 'W') {
                  W = bfs(i,j,0);
                  resultW +=  (int)Math.pow(W, 2);    // bfs가 끝나면 갯수^2 
               }
               else if(map.get(i).get(j) == 'B') {
                  B = bfs(i,j,0);
                  resultB +=  (int)Math.pow(B, 2);
               }
      
            }
            
         }
      }
      System.out.println(resultW + " " + resultB);
   }
   
   
   // 상하좌우 방향 이동하면서 같은 문자인 경우 방문처리와 갯수 증가
   public static int bfs(int x, int y, int count) {
      Queue<Point> q = new LinkedList<Point>();
      q.add(new Point(x,y)); // 시작위치 큐 삽입
      check[x][y] = 1;
      
      while(!q.isEmpty()) {
         Point now = q.poll();
         for(int i=0; i<4; i++) {
            int nx = now.x + direction[i][0];
            int ny = now.y + direction[i][1];
            
            if(nx>=0 && ny>=0 && nx<M && ny<N) {
               if(check[nx][ny] == 0 && map.get(nx).get(ny) == map.get(x).get(y)) {
                  check[nx][ny] = 1;
                  count++;
                  q.add(new Point(nx,ny));
               }
            }  
         }
      }
      return count+1;
   }
}
