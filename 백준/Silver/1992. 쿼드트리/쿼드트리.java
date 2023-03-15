import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i=0;i<N;i++){
            arr[i] = br.readLine().toCharArray();
        }
        querter(N,0,0);
        System.out.println(sb);


    }

    private static void querter(int n, int si, int sj){



        //모든 점이 같은 지 확인, 다르면 분할
        if(sameColor(n,si,sj)){
            sb.append(arr[si][sj]);

        }else {
            sb.append("(");
            int half =n/2;
            //1
            querter(half, si,sj);

            //2
            querter(half, si,sj+half);

            //3
            querter(half, si+half,sj);

            //4
            querter(half, si+half,sj+half);
            sb.append(")");
        }

    }

    static boolean sameColor(int n, int si, int sj){

        char chTmp = arr[si][sj];

        for(int i = si; i< si+n;i++){
            for(int j = sj;j<sj+n;j++){
                if(chTmp != arr[i][j]) return false;
            }
        }

        return true;


    }
}