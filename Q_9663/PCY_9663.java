import java.util.Scanner;

public class Q_9663 {
  static int N;
  static boolean visit[][];
  static int answer = 0;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    visit = new boolean[N][N];

    dfs(0);
    System.out.println(answer);
  }
  
  public static void dfs(int x) {
    if (x == N) {
      answer++;
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!check(x, i))
        continue;
      visit[x][i] = true;
      dfs(x + 1);
      visit[x][i] = false;
    }
  }


  public static boolean check(int x, int y){
    for (int i = 0; i < N; i++) {
      if (i <= x && visit[i][y]) // 열
        return false;

      if (x + i < N && y + i < N && visit[x + i][y + i]) // 오른쪽 아래 대각선
        return false;
      if (x - i >= 0 && y - i >= 0 && visit[x - i][y - i]) // 왼쪽 위  대각선
        return false;

      if (x - i >= 0 && y + i < N && visit[x - i][y + i]) // 왼쪾 아래 대각선
        return false;

      if (x + i < N && y - i >= 0 && visit[x + i][y - i]) //오른쪾 위 대각선
        return false;
    }
    return true;
  }
}
