package BOJ_10546;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LDH_10546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        HashMap<String,Integer> map = new HashMap<>(T);

        String key= "";

        for (int i = 0; i < T; i++) {
            key = br.readLine();
            if(map.containsKey(key)) { // 동명이인 처리
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key,1); // 아니 이걸 왜 0이라고 했었나 ㅋㅋ
            }
        }

        for (int i=0;i<T-1;i++) {
            key = br.readLine();
            map.put(key, map.get(key) - 1); // 완주자 명단 제거
        }

        for(String k : map.keySet()) { // 출력
            if(map.get(k) != 0) {
            System.out.println(k);               
           }
         }

    }
}