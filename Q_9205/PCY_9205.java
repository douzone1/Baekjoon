import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x; int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		ArrayList<Point> position; // 집, 편의점, 페스티벌 위치 저장 
		
		
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			position = new ArrayList<Point>();
			
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				position.add(new Point(x,y));
			}

			graph = new ArrayList<ArrayList<Integer>>();
			
			for(int i=0; i<N+2; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (Manhatten(position.get(i), position.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }
            
           	sb.append(bfs() ? "happy" : "sad");
           	System.out.println(sb);
           	
		}
	}
	
	public static int Manhatten(Point a, Point b ) {
		return Math.abs(a.x - b.x) + Math.abs(a.y-b.y);
	}
	
	public static boolean bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		
		int[] visit = new int[N+2];
		visit[0] = 1;
		
		while(!q.isEmpty()) {
			int current = q.poll();
		
			if(current == N+1) return true; // 페스티벌 도달 시 true 반환
			
			for(int next : graph.get(current)) {
				if(visit[next] == 0) {
					visit[next] = 1;
					q.offer(next);
				}
			}
		}
		return false;  // 미도달 시 false 반환
	}
}
