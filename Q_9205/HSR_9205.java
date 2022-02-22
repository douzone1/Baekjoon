package dailyAlgorism;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.Iterator;

//첫째 줄에 테스트 케이스의 개수 t가 주어진다. (t ≤ 50)
//
//각 테스트 케이스의 첫째 줄에는 맥주를 파는 편의점의 개수 n이 주어진다. (0 ≤ n ≤ 100).
//
//다음 n+2개 줄에는 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표가 주어진다. 각 좌표는 두 정수 x와 y로 이루어져 있다. (두 값 모두 미터, -32768 ≤ x, y ≤ 32767)
//
//송도는 직사각형 모양으로 생긴 도시이다. 두 좌표 사이의 거리는 x 좌표의 차이 + y 좌표의 차이 이다. (맨해튼 거리)
class Coordinate {
	private int x, y;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Coordinate(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	
}
public class HSR_9205 {
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int t, n;
		String result = "";
		t = Integer.parseInt(br.readLine());
		
		ArrayList<Coordinate> vertex;
		ArrayList<ArrayList<Integer>> graph;
		StringBuilder sb = new StringBuilder();
		while(t-- > 0) {
			n = Integer.parseInt(br.readLine());
			vertex = new ArrayList<>();
			//현위치 편의점 위치 공연장 위치를 저장할 클래스 생성및 x,y 좌표 설정				
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());				
				vertex.add(new Coordinate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			graph = new ArrayList<>();
			
			for (int i = 0; i < n + 2; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					//각 좌표의 직선거리의 합이 1000 이하일때 그래프 연결
					if(road(vertex.get(i), vertex.get(j)) <=1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			sb.append((bfs(graph, n) ? "happy" : "sad") + '\n');
			System.out.println("graph.get(0)" +graph.get(0));
			System.out.println("graph.get(1)" + graph.get(1));
			System.out.println("graph.get(2)" + graph.get(2));
			System.out.println("graph.get(3)" + graph.get(3));
			System.out.println("graph.get(4)" + graph.get(4));
			
		}
		
		
		bw.write(sb.toString());
        bw.flush();
		
	}
	//두 좌표의 거리를 계산하는 메소드
	public static int road(Coordinate c1, Coordinate c2) {
		return Math.abs(c1.getX() - c2.getX()) + Math.abs(c1.getY() - c2.getY()); 
	}
	//bfs
	public static boolean bfs(ArrayList<ArrayList<Integer>> graph, int n) {
		//링크드 큐 생성
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		
		boolean[] visited = new boolean[n + 2];
		//시작점은 true
		visited[0] = true;
		
		while ( !q.isEmpty()) {
			int now = q.poll();
			
			if(now == n + 1) {
				return true;
			}
			
			for (int next : graph.get(now) ) {
				if(!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
			
		}
		return false;
		
	}	
		
	
}
