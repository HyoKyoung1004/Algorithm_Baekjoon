import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] zero = new long[n];
        long[] one = new long[n];

        one[0]=1;

        for(int i=1;i<n;i++){

            zero[i] = zero[i-1]+one[i-1];
            one[i] = zero[i-1];
        }

        System.out.println(zero[n-1]+one[n-1]);
    }
}
