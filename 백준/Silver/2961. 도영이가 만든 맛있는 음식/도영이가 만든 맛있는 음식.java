import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args)  throws  Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            arr[i][0] =s;
            arr[i][1]= b;
        }


        subsetTaste(0,1L,0L);
        System.out.println(min);
    }

    private static void subsetTaste(int cnt, long s,long b) {
        if(cnt == n){
           if(s==1 &&  b==0) return;
            if(min > Math.abs(s-b))
                min =Math.abs(s-b);
            return;
        }

        //재료 추가
        subsetTaste(cnt+1, s*arr[cnt][0], b+arr[cnt][1] );
        //재료 추가 안함
        subsetTaste(cnt+1, s, b );

    }
}