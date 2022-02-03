package dailyAlgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class HSR_11725 {
	public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int i, j;
        
        // 연결된 노드 리스트
        ArrayList<Integer>[] list = new ArrayList[n+1];
        
        // ArrayList 초기화        
        for(i=1; i<=n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        // 서로 연결된 노드를 a , b 순으로 입력하고 서로의 리스트에 값 추가
        for(i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        
        
        
        // 결과 값(부모값)
        // 예: parents[i] = j (i의 부모 : j)
        int[] parents = new int[n+1];
        
        // dfs
//        System.out.println("dfs(1,0)");
        dfs(list, parents, n, 1, 0);
        
        // 결과 출력
        for(j=2;j<=n; j++) System.out.println(parents[j]);
    }

    private static void dfs(ArrayList<Integer>[] list, int[] parents, int n, int start, int parent) {
        // TODO Auto-generated method stub
        parents[start] = parent;
//        System.out.println("parents["+ start +"]  = " + parents[start] + " parent = " + parent + " list["+ start + "] =" + list[start]);
        for(int item : list[start]) {  //list속 값들을 반복 list[ 
//        	System.out.println("item = " + item + " parents["+ start +"]  = " + parents[start] + " parent = " + parent);
//        	System.out.println("dfs("+ item + "," + start + ")");
        	
            if(item != parent) {
//            	System.out.println("dfs("+ item + "," + start + ")");
            	dfs(list, parents, n, item, start);
            	
            }
//            else System.out.println("if 탈출");
            
        }
    }
}
