import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T,start;
    static char[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        arr = new char[T][];
        for(int i=0;i<T;i++){
            arr[i] = br.readLine().toCharArray();
        }

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken())-1;
            int direction = Integer.parseInt(st.nextToken());
            chooseDirection(start, true,direction);
            chooseDirection(start, false,direction);
            rotate(start,direction);
//            System.out.println(Arrays.deepToString(arr));
        }

        int result = 0;
        for(int i=0;i<T;i++){
            if(arr[i][0]=='1') result++;
        }
        System.out.println(result);
    }

    static void chooseDirection(int now,  boolean isRight, int direc){

        if(isRight){ //오른쪽을 확인
            if(now!=T-1 &&arr[now][2] != arr[now+1][6]){
                chooseDirection(now+1, true, direc*-1);
            }
            if(now!=start) rotate(now,direc);
        }

        else{ //왼쪽을 확인

            if(now !=0 && arr[now][6] != arr[now-1][2]) {
                chooseDirection(now - 1, false, direc * -1);
            }
            if(now!=start) rotate(now,direc);
        }

    }

    private static void rotate(int now, int direc) {

        if(direc==1){ //시계회전
            char last = arr[now][7];
            for(int i=7;i>0;i--)
                arr[now][i] = arr[now][i-1];
            arr[now][0]=last;
        }else{
            char first = arr[now][0];
            for(int i=0;i<7;i++)
                arr[now][i] = arr[now][i+1];
            arr[now][7] = first;
        }
//        System.out.println(now+", "+direc+": "+ Arrays.toString(arr[now]));
    }

}
