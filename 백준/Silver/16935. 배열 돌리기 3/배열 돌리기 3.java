import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int r;
    static int[][] arr;

    public static void main(String[] args) throws Exception{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        //int[] result = new int[r];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<r;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num==1) one();
            else if(num==2) two();
            else if(num==3) three();
            else if(num==4) four();
            else if(num==5) five();
            else if(num==6) six();
        }
        printArr();
        //System.out.println(n+", "+m);

    }


    static void one(){

        for(int i=0; i< n/2;i++){
            int[] tmp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] =tmp;
        }
    }

    static void two(){

        for(int j=0;j<m/2;j++){
            int[] tmp = new int[n];
            for (int i=0;i<n;i++)
                tmp[i] = arr[i][j];

            for (int i=0;i<n;i++)
                arr[i][j] = arr[i][m-1-j];

            for (int i=0;i<n;i++)
                arr[i][m-1-j] = tmp[i];
        }
    }

    static void three(){
        int[][] tmp = new int[m][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               tmp[j][n-1-i] =arr[i][j];
            }
        }
        arr=tmp;
        int changeTmp=m;
        m = n;
        n=changeTmp;
    }

    static void four(){
        int[][] tmp = new int[m][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                tmp[m-1-j][i] =arr[i][j];
            }
        }

        arr=tmp;
        int changeTmp=m;
        m = n;
        n=changeTmp;
    }

    static void five(){
        int tmp;
        for(int i=0;i <n/2;i++){
            for(int j=0;j<m/2;j++){
                tmp= arr[n/2+i][j];
                arr[n/2+i][j] = arr[n/2+i][m/2+j];
                arr[n/2+i][m/2+j] =arr[i][m/2+j];
                arr[i][m/2+j] =arr[i][j];
                arr[i][j] = tmp;
            }
        }
    }

    static void six(){
        int tmp;
        for(int i=0;i <n/2;i++){
            for(int j=0;j<m/2;j++){
                tmp= arr[i][j];
                arr[i][j] = arr[i][m/2+j];
                arr[i][m/2+j] =arr[n/2+i][m/2+j];
                arr[n/2+i][m/2+j] = arr[n/2+i][j];
                arr[n/2+i][j] = tmp;
            }
        }
    }

    static void printArr(){
        for(int[] tmp :arr){
            for(int n :tmp)
                System.out.print(n+" ");
            System.out.println();
        }
    }
}