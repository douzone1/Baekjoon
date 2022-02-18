package BOJ_2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LDH_2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,Integer> map = new HashMap<String,Integer>();

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for(int i=0;i<N;i++) {
            map.put(br.readLine(),i);
        }
        

        //car.out이 car.in 순서보다 빠르면 딱지
        for(int i=0;i<N;i++) {
            String car = br.readLine();
            for(String j : map.keySet()) {
                if (map.get(j) < map.get(car)) { // 12345 5432 1 반례. 결국 i j 대비 비교탐색 필요
                    count++;
                    break;
                }
            }
            map.remove(car);    // 이중 체크 방지
        }

        System.out.println(count);
    }
}
