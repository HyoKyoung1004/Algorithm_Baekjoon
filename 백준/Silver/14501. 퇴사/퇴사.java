import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][2];

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        long[] D = new long[n+2];
        D[n+1]=0;

        for(int i = n;i>=1;i--){
            int t = arr[i][0];
            int m = arr[i][1];
            if(i+t-1>n)
                D[i] = D[i+1];
            else{
                D[i] = Math.max(m+ D[i+t] ,D[i+1]);

            }
        }

        System.out.println(D[1]);

    }
}
