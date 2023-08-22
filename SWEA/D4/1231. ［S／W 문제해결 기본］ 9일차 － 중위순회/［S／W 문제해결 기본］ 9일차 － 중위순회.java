import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static char[] arr;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1;tc<=10;tc++){

            N = Integer.parseInt(br.readLine());
            arr= new char[N+1];
            StringTokenizer st;
            for(int i=1;i<=N;i++){
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
            }
            sb.append("#"+tc+" ");
            inOrder(1);
            sb.append("\n");

        }
        System.out.println(sb);
    }
    static void inOrder(int n){
        if(n>N) return;
        inOrder(n*2);
        sb.append(arr[n]);
        inOrder(n*2+1);
    }
}
