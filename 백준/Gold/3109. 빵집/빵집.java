import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static char[][] arr;

    static int[] dx = {-1, 0, 1};
    static int[] dy = {1,1,1};
    static int count=0;
    static boolean result = false;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         r = Integer.parseInt(st.nextToken());
         c = Integer.parseInt(st.nextToken());

         arr= new char[r][c];
         for(int i=0;i<r;i++){
             arr[i] = br.readLine().toCharArray();
         }

         for(int i=0;i<r;i++){
             dfs(i,0);
         }

        System.out.println(count);
    }

    private static boolean  dfs(int x, int y) {

        if(y==c-1){
            if(arr[x][y] == '.'){
            arr[x][y] = '=';
            count++;
            //printArr();
            return true;
            }
            return false;
        }

        arr[x][y] = '=';

        for(int i=0;i<3;i++){

            int nextX = x + dx[i];
            int nextY = y+1;

            if(nextX>=0 && nextX<r && nextY<c && arr[nextX][nextY] =='.' ){
                boolean tmpResult =dfs(nextX,nextY);
                if(tmpResult) {
                    return true;
                }
//                else {
//                    arr[nextX][nextY] = '.';
//                }
            }


        }

        return  false;

    }

    static void printArr(){
        for(char[] chArr :arr){
            System.out.println(Arrays.toString(chArr));
        }
        System.out.println();
    }
}