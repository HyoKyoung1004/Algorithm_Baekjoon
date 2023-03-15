import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();

        int[][] arr= new int[1001][1001];

        StringTokenizer st;
        for(int k=1;k<=N;k++){

            st= new StringTokenizer(br.readLine());
            int x =Integer.parseInt(st.nextToken());
            int y =Integer.parseInt(st.nextToken());
            int w =Integer.parseInt(st.nextToken());
            int h =Integer.parseInt(st.nextToken());

            for(int i=x;i<=x+w-1;i++){
                for(int j=y;j<=y+h-1;j++){
                    arr[i][j] = k;
                }
            }
        }

        for(int k=1;k<=N;k++){
            int count=0;
            for(int i=0;i<=1000;i++){
                for(int j=0;j<1000;j++){
                    if(arr[i][j]==k) count++;
                }
            }
            sb.append(count+"\n");

        }


        System.out.println(sb);




    }
}