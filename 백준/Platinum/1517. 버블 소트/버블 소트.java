import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static long swapNum=0;
    static long[] sorted;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        long arr[] = new long[num];

        for(int i=0;i<num;i++){
            arr[i] = Integer.parseInt(str[i]);
        }


        //병합정렬 수행하기
        sorted = new long[num];
        mergeSort(arr,0,num-1);

        //System.out.println(Arrays.toString(arr));
        System.out.println(swapNum);

        sorted=null;

    }

    static void mergeSort(long[] arr, int left, int right ){

       int i= left; //포인터 1
       int middle = (left+right)/2;
       int j=middle+1; //포인터2
        int k=left;//추가 배열으 자리

        if(left<right) { //요소수가 1개보다 크다면
            mergeSort(arr, left, middle);
            mergeSort(arr,middle+1,right);

           // System.out.println(arr[i]+", "+arr[right]);
            while(i<=middle && j<=right){

                //System.out.println("ㄷㄺ");
                if(arr[i]>arr[j]){
                    sorted[k]=arr[j];
                    j++;
                    swapNum+= (middle-i+1);
                    //System.out.println("더하는 수: "+(middle-left+1)+", "+swapNum);
                }else{
                    sorted[k]=arr[i];
                    i++;
                }
                k++;
            }
            while(i<=middle){
                sorted[k]=arr[i];
                i++;
                k++;
            }
            while(j<=right){
                sorted[k]=arr[j];
                j++;
                k++;
            }

            for(int t= left;t<=right;t++){
                arr[t]=sorted[t];
            }

        }


    }

}