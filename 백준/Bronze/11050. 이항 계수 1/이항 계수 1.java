import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] D;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        D =  new int[n+1][n+1];

        for(int i=0;i<=n;i++){

            D[i][0]=1;
            D[i][1]=i;
            D[i][i] =1;
        }

        //바텀 업 방식
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                D[i][j]= D[i-1][j-1]+D[i-1][j];
            }
        }
        System.out.println(D[n][k]);
    }



}
