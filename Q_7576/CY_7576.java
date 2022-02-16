import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tuple {
	int a, b;

	Tuple(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

}

public class Main {
	static int N, M;
	static int[][] box;
	static int[][] visit; // 방문체크
	static int MAX = Integer.MIN_VALUE; // 최대 일수
	static ArrayList<Tuple> direction = new ArrayList<>();
	static ArrayList<Tuple> start = new ArrayList<Tuple>(); // 시작 위치 (익은 토마토가 있는 위치)
	static Queue<Tuple> q = new LinkedList<Tuple>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		box = new int[N][M];
		visit = new int[N][M];
		direction.add(new Tuple(-1, 0)); // 상
		direction.add(new Tuple(1, 0)); // 하
		direction.add(new Tuple(0, -1)); // 좌
		direction.add(new Tuple(0, 1)); // 우
		
		// input
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {

				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1)
					start.add(new Tuple(i, j));
			}
		}

		for (Tuple item : start) q.add(new Tuple(item.getA(), item.getB()));

		while (!q.isEmpty()) {
			Tuple tmp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = direction.get(i).getA() + tmp.getA();
				int ny = direction.get(i).getB() + tmp.getB();
			
				if(nx >=0 && ny >=0 && nx < N && ny <M) {
					if (box[nx][ny] == -1)
						continue;

					if (box[nx][ny] == 0 && visit[nx][ny] == 0) {
						visit[nx][ny] = 1;
						box[nx][ny] = box[tmp.getA()][tmp.getB()] + 1;
						q.add(new Tuple(nx, ny));
					}
				}
			}
		}
		
		// output
		for(int[] item: box) {
			for(int i : item) {
				if(i == 0) { // 안익은 토마토가 하나라도 있다면 -1 출력후 바로 종료
					System.out.println(-1);
					System.exit(0);
				}
				MAX = Math.max(MAX, i);
			}
		}
		System.out.println(MAX-1);
	}
}
