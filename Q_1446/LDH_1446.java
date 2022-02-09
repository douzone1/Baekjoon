package BOJ_1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class LDH_1446 {
    static class Road {
        int start, end, distance;
        public Road (int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int initDistance = Integer.parseInt(st.nextToken());

        List<Road> list = new ArrayList<Road>();

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if (end > initDistance) continue;
            if (end - start <= distance) continue;
            list.add(new Road(start, end, distance));
        }

        Collections.sort(list, new Comparator<Road>(){
            public int compare(Road r1, Road r2) {
                if (r1.start == r2.start) return r1.end - r2.end;
                return r1.start - r2.start;
            }
        });

        int idx = 0, move = 0;
        int[] dist = new int[10001];

        for (int i=0; i<dist.length; i++) {
            dist[i] =0;
        }

        // 다익스트라 구현
        
        // 못풀었음... 주말에

        System.out.println(dist[initDistance]);
    }
}