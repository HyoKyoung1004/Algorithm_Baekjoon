import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb= new StringBuffer();

        int tc= Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++){

            int n = Integer.parseInt(br.readLine());
            int[] arrN = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arrN[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrN);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++){
                int tmp = Arrays.binarySearch(arrN, Integer.parseInt(st.nextToken()));
                if(tmp>=0) sb.append(1+"\n");
                else sb.append(0+"\n");
            }

        }
        System.out.println(sb);
    }
}
