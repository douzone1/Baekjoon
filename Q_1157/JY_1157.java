import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JY_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int word[] = new int[26];
        int max = 0;
        int ans = 0;
        String s = br.readLine().toUpperCase();

        for(int i=0; i<s.length(); i++)
            word[s.charAt(i)-'A']++;

        for(int i=0; i<26; i++){
            if(word[i] > max) {
                max = word[i];
                ans = (char)(i+'A');
            }
            else if(word[i] == max)
                ans = '?';
        }
        
        System.out.print(ans);
    }
}
