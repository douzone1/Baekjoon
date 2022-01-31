import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JY_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int origin, cycle = 0;

        origin = n;
        do{
            n=((n%10)*10)+(((n/10)+(n%10))%10);
            cycle++;
        }while(origin != n);

        System.out.print(cycle);
    }
}
