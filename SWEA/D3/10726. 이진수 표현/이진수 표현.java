import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        for(int tc=1;tc<=TC;tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int lastNbit = (1<<N)-1; 
            if( (M&lastNbit) == lastNbit) sb.append("#"+tc+" ON\n");
            else sb.append("#"+tc+" OFF\n");
        }
        System.out.println(sb);
    }
}
