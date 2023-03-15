import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] arr= new int[30][30];

        for(int i=0;i<30;i++){
            arr[i][0] = 1;
            arr[i][1] = i;
            arr[i][i] = 1;
        }

        for(int i=2;i<30;i++){
            for(int j=2;j<i;j++){
                arr[i][j] = arr[i-1][j-1] +arr[i-1][j];
            }
        }

        StringBuffer sb= new StringBuffer();
        for(int i=0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(arr[m][n]+"\n");
        }
        System.out.println(sb);

    }
}
