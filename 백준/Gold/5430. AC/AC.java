import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        sb= new StringBuilder();
        for(int t=0;t<T;t++){
            char[] p = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            String str = br.readLine();
            String[] tmp = str.substring(1,str.length()-1).split(",");
            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(tmp[i]);
            }
//            System.out.println(Arrays.toString(arr));
            solve(p, N, arr);
        }
        System.out.println(sb);
    }

    private static void solve(char[] p, int n, int[] arr) {

        boolean reverse=false, error=false;
        int start=0, end=n-1;

        for(int i=0; i<p.length;i++){
            if(p[i]=='R'){
                reverse = !reverse;
            }else{
                if(start>end || arr.length==0) {
                    error = true;
                    break;
                }else if(!reverse)
                    start++;
                else if(reverse) end--;
            }
        }

        if(error) sb.append("error\n");
        else{
            sb.append("[");
            if(reverse){
                for(int i=end;i>=start;i--){
                    if(i==start) sb.append(arr[i]);
                    else sb.append(arr[i]+",");
                }
            }else{
                for(int i=start;i<=end;i++){
                    if(i==end) sb.append(arr[i]);
                    else sb.append(arr[i]+",");
                 }
            }
            sb.append("]\n");
        }
    }
}
