import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        int[] D = new int[n+1];
        D[1]= 0;

        for(int i=2;i<=n;i++){
            D[i] = D[i-1]+1;
            if(i%2==0  &&D[i] > D[i/2]+1 ) D[i] = D[i/2]+1;
            if(i%3==0 && D[i] > D[i/3]+1) D[i] = D[i/3]+1;
        }

        System.out.println(D[n]);

    }
}
