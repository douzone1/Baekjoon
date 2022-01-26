import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class DH_10897 {

    public static void main(String args[]) throws Exception {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][4];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split(" ");
        }
        Score score = new Score();

        //정렬
        Arrays.sort(arr, score);

        //출력
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0]);
        }

    }
}

class Score implements Comparator<String[]> {
    
    @Override
    public int compare(String[] s1, String[] s2) {

        if (Integer.parseInt(s1[1]) == Integer.parseInt(s2[1])) {
            if (Integer.parseInt(s1[2]) == Integer.parseInt(s2[2])) {
                if (Integer.parseInt(s1[3]) == Integer.parseInt(s2[3])) {
                    
                    //4순위: 이름 오름차순
                    return s1[0].compareTo(s2[0]);
                }

                //3순위: 수학 점수 = 내림차순
                return Integer.compare(Integer.parseInt(s2[3]), Integer.parseInt(s1[3]));

            }
            //2순위: 영어 점수 = 오름차순
            return Integer.compare(Integer.parseInt(s1[2]), Integer.parseInt(s2[2]));
        }
        //1순위: 국어점수 = 내림차순
        return Integer.compare(Integer.parseInt(s2[1]), Integer.parseInt(s1[1]));
    }

    /*
    String name;
    String kor;
    String eng;
    String math;

    public int compare(Score s1, Score s2) {

        if (Integer.parseInt(s1.kor) == Integer.parseInt(s2.kor)) {
            if (Integer.parseInt(s1.eng) == Integer.parseInt(s2.eng)) {
                if (Integer.parseInt(s1.math) == Integer.parseInt(s2.math)) {
                    
                    //4순위: 이름 오름차순
                    return s1.name.compareTo(s2.name);
                }

                //3순위: 수학 점수 = 내림차순
                return Integer.compare(Integer.parseInt(s2.math), Integer.parseInt(s1.math));

            }
            //2순위: 영어 점수 = 오름차순
            return Integer.compare(Integer.parseInt(s1.eng), Integer.parseInt(s2.eng));
        }
        //1순위: 국어점수 = 내림차순
        return Integer.compare(Integer.parseInt(s2.kor), Integer.parseInt(s1.kor));
    }
    */
    /*
    int kor;
    int eng;
    int math;
    String name;
    
    public int compare(Score s1, Score s2) {

        if (s1.kor == s2.kor) {
            if (s1.eng == s2.eng) {
                if (s1.math == s2.math) {

                    //4순위: 이름 오름차순
                    return s1.name.compareTo(s2.name);
                }

                //3순위: 수학 점수 = 내림차순
                return Integer.compare(s2.math, s1.math);

            }
            //2순위: 영어 점수 = 오름차순
            return Integer.compare(s1.eng, s2.eng);
        }
        //1순위: 국어점수 = 내림차순
        return Integer.compare(s2.kor, s1.kor);
    }*/
}
