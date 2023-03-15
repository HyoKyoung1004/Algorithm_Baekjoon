import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] w;
    static int n;
    static int k;
    static int count;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        w = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        DFS(0, 0);

        if(k==0) count--;
        System.out.println(count);

    }

    private static void DFS(int i, int sum) {

        if( i== n && sum == k ) count++;

        if(i<n) {
            DFS(i + 1, sum + w[i]); //내 것을 추가하거나
            DFS(i + 1, sum); //추가하지 않거나,,,
        }
    }
}
