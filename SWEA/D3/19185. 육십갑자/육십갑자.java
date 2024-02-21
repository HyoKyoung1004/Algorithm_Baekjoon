import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=TC ;t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[] arrN = new String[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arrN[i] = st.nextToken();
            }
            String[] arrM = new String[M+1];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++){
                arrM[i] = st.nextToken();
            }
            sb.append("#"+t+" ");
            int Q = Integer.parseInt(br.readLine());
            for(int i=0;i<Q;i++){
                int Y = Integer.parseInt(br.readLine())-1;
                sb.append(arrN[Y%N]+arrM[Y%M]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }
}
