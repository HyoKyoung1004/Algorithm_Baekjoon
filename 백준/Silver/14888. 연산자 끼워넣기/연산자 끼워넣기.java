import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int [] oper;
    static int[] resultSet;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        oper = new int[4];
        for(int i=0;i<4;i++){
            oper[i] =Integer.parseInt(st.nextToken());;
        }

        //----------------input end;

        resultSet = new int[N-1];
        search(0);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    private static void search(int cnt) {

        if(cnt ==N-1){
            //System.out.println(Arrays.toString(resultSet));

            calResult();
            return;
        }

        for(int k=0;k<4;k++){

            for(int i=0;i<oper[k];i++){
                oper[k]--;
                resultSet[cnt] = k;
                search(cnt+1);
                oper[k]++;
            }

        }

    }

    private static void calResult() {

        int total=arr[0];

        for(int i=0;i<N-1;i++){
            if(resultSet[i]==0) total = total + arr[i+1];
            else if(resultSet[i]==1) total = total - arr[i+1];
            else if(resultSet[i]==2) total = total * arr[i+1];
            else total = total / arr[i+1];
        }

        if(total>MAX) MAX = total;
        if(total<MIN) MIN = total;
    }
}