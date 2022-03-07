import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int N;
    static int[][] meets;
    static ArrayList<Integer> people = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        meets = new int[N][3];

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            meets[i][0] = input[0];
            meets[i][1] = input[1];
            meets[i][2] = input[2];
        }

        // 회의 시작시간 기준 오름차순 정렬
        Arrays.sort(meets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });
        
        // 첫 회의 설정 완전 탐색
        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }
        System.out.println(Collections.max(people));
    }
    
    public static void dfs(int i, int current) {
        current += meets[i][2]; // 참여자 합

        if(meets[i][1] > meets[N-1][0]) people.add(current); // 종료조건: 가장 마지막 회의 시작시간 < 현재 회의 끝나느 시간

        for (int indx = 0; indx < N; indx++) {
            if (meets[indx][0] < meets[i][1]) // 회의 시간이 겹치는 경우 제외 
                continue;
            dfs(indx,current); 
        }
    }   
}
