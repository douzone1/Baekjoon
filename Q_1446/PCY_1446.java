import java.io.*;
import java.util.*;

class Node{
	int end, cost;
	
	public Node(int end, int cost) {
		this.end=end;
		this.cost = cost;
	}
}

public class Main {
	static int N, D, dist[] ;
	static List<Node> graph[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		dist = new int[10001]; // 최대 고속도로 길이는 10000
		graph = new List[10001];
		
		for(int i=0; i<graph.length; i++) {
			dist[i] = i; // 거리 정보 초기화
			graph[i] = new ArrayList<>(); 
		}
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end =Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[start].add(new Node(end, cost)); // 그래프 삽입
		}
		
		dijkstra(0);
		System.out.println(dist[D]);
	}
	
	
	public static void dijkstra(int start) {
		if(start > D ) return; // 종료조건 
		
		dist[start+1] = Math.min(dist[start+1], dist[start] + 1); // 다음 노드까지 최단거리
		
		// 지름길이 있다면 => 목적지에 도착하는 최단거리 (지름길 이용 or 이용X)
		for(int i=0; i<graph[start].size(); i++) {
			dist[graph[start].get(i).end] = Math.min(dist[graph[start].get(i).end], dist[start] + graph[start].get(i).cost);
		}
		dijkstra(start + 1);
	}
}
