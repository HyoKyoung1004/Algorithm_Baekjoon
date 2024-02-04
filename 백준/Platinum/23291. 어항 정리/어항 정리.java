import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        int result=0;
        while(true) {
            result++;
            leastValue();
            int[][] arrT = rotateArr1(); //공중부양
            arrT = regulateFishCount(arrT); //물고기 수 조절
            int[] tmp = flatArr(arrT, arrT.length, arrT[0].length); //일렬로 놓기
            arrT = rotateArr2(tmp);
            arrT = regulateFishCount(arrT);
            tmp = flatArr(arrT, arrT.length, arrT[0].length);
            for(int i=0;i<N;i++){
                arr[i] = tmp[i];
            }

            Arrays.sort(tmp);
            if(tmp[N-1] -  tmp[0] <=K) break;
//            System.out.println(Arrays.toString(tmp));
//            System.out.println("===================================");
        }
        System.out.println(result);

    }

    //물고기의 수가 가장 적은 어항에 물고기를 한 마리 넣는다
    static void leastValue(){
        int minValue = arr[0];
        for(int i=1;i<N;i++){
            if(minValue >arr[i]) minValue=arr[i];
        }
        for(int i=0;i<N;i++){
            if(minValue == arr[i]) arr[i]++;
        }
//        System.out.println(Arrays.toString(arr));
    }

    static int[][] rotateArr1(){

//        System.out.println("공중부양1");

        int nowH=2; //공중부양 시킬 높이
        int nowW=1; //공중부양 시킬 너비
        int c = N-1; //현재 배열 너비
        int[][] arrT = new int[nowH][c];

        arrT[0][0] = arr[0];
        for(int i=0;i<N-nowW;i++){
            arrT[1][i] = arr[i+1];
        }

        c= c-nowW;
        while(c>=nowH){

            int[][] tmp = new int[nowW+1][c]; //너비가 회전하니까 높이가 되고 위로 올리니까+1
            //시계 회전8
            for(int j=0;j<nowW;j++){
                for(int i=0;i<nowH;i++){
                    tmp[j][nowH-i-1] = arrT[i][j];
                }
            }
            for(int i=0;i<c;i++){
                tmp[nowW][i] = arrT[nowH-1][i+nowW];
            }

            int tmpW = nowW;
            nowW = nowH; 
            nowH = tmpW+1; 
            c= c-nowW;
            arrT=tmp;

        }
        return arrT;
    }


    //물고기 수 조절
    static int[][] regulateFishCount(int[][] arrT ){

//        System.out.println("물고기 수 조절");
        int n = arrT.length;
        int m = arrT[0].length;
        int[][] countArr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                countArr[i][j] = arrT[i][j];
            }
        }

        //우하만 비교하면 전체 비교 가능
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arrT[i][j]==0) continue;

                //우측
                if(!(j+1==m || arrT[i][j+1]==0) ) {
                    int d = Math.abs(arrT[i][j] - arrT[i][j + 1]) / 5;
                    if (d > 0) {
                        if (arrT[i][j] > arrT[i][j + 1]) {
                            countArr[i][j] -= d;
                            countArr[i][j + 1] += d;
                        } else {
                            countArr[i][j] += d;
                            countArr[i][j + 1] -= d;
                        }
                    }
                }
                //하단
                if(!(i+1==n || arrT[i+1][j]==0)) {
                   int d = Math.abs(arrT[i][j] - arrT[i + 1][j]) / 5;
                    if (d > 0) {
                        if (arrT[i][j] > arrT[i + 1][j]) {
                            countArr[i][j] -= d;
                            countArr[i + 1][j] += d;
                        } else {
                            countArr[i][j] += d;
                            countArr[i + 1][j] -= d;
                        }
                    }
                }
            }
        }

        arrT = countArr;
        //System.out.println(Arrays.deepToString(arrT));

        return arrT;
    }

    //다시 어항을 바닥에 일렬로 놓아야 한다
    static int[] flatArr(int[][] arrT, int n, int m){
//        System.out.println("어항을 바닥에 일렬로 놓아야 한다");

        int[] tmp = new int[N];
        int k=0;
        for(int j=0;j<m;j++){
            for(int i=n-1;i>=0;i--){
                if(arrT[i][j]==0) continue;
                tmp[k] = arrT[i][j];
                k++;
            }
        }
//        System.out.println(Arrays.toString(tmp));
        return tmp;
    }



    static int[][] rotateArr2(int[] tmp){
//        System.out.println("공중부양2");

        int[][] arrOne = new int[2][N/2];

        for(int i=0;i<N/2;i++){
            arrOne[0][i] =  tmp[N/2-i-1];
            arrOne[1][i] = tmp[N/2+i];
        }
//        System.out.println(Arrays.deepToString(arrOne));


        //오른쪽으로 90도 회전을 두번함
        int[][] arrTmp1 = new int[N/4][2];
        for(int i=0;i<2;i++){
            for(int j=0; j<N/4;j++){
                arrTmp1[j][2-i-1] = arrOne[i][j];
            }
        }

        int[][] arrTmp2 = new int[2][N/4];
        for(int i=0;i<N/4;i++){
            for(int j=0; j<2;j++){
                arrTmp2[j][N/4-i-1] = arrTmp1[i][j];
            }
        }

        int[][] arrTwo = new int[4][N/4];

        for(int i=0; i<2 ;i++){
            for(int j=0; j<N/4;j++){
                arrTwo[i][j] = arrTmp2[i][j];
                arrTwo[2+i][j] = arrOne[i][N/4+j];
            }
        }
//        System.out.println(Arrays.deepToString(arrTwo));
        return arrTwo;

    }


}
