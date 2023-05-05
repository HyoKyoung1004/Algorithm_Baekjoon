import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T,K;
    static char[][] arr, tmp;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        arr = new char[T+1][];

        for(int i=1;i<=T;i++) {
            arr[i] = br.readLine().toCharArray();
        }


        K = Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());


            if(n+1<=T && arr[n][2] != arr[n+1][6]){
                rightRotate(n+1, -direction);
            }

            if(n-1>0 && arr[n-1][2] != arr[n][6]){
                leftRotate(n-1, -direction);
            }

            rotation(n,direction); //나를 회전
            //System.out.println(Arrays.deepToString(arr));
        }

        int count=0;
        for(int i=1;i<=T;i++) {
            if(arr[i][0]=='1') count++;
        }
        System.out.println(count);




    }
    
    private static void rotation(int n, int direction) {

        if (direction == 1) { //시계
            char temp = arr[n][7];
            for(int i=7;i>0;i--)
                arr[n][i] = arr[n][i-1];
            arr[n][0] =temp;

        }else{
            char t = arr[n][0]; //반시계
            for(int i=0;i<7;i++)
                arr[n][i] = arr[n][i+1];
            arr[n][7]=t;
        }
        
    }
    
    public static void rightRotate(int n, int direction){

        //오른쪽
        if(n+1<=T && arr[n][2] != arr[n+1][6]){
            rightRotate(n+1, -direction);
        }
        rotation(n,direction);
    }

    public static void leftRotate(int n, int direction){
        //왼쪽
        if(n-1>0 && arr[n-1][2] != arr[n][6]){
            leftRotate(n-1, -direction);
        }
        rotation(n,direction);
    }
}
