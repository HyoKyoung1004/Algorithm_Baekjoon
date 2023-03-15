import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        //-99 -2 -1 4 98;;;;
        Arrays.sort(arr);
        int s=0;
        int e=num-1;

        int range=Math.abs(arr[s]+arr[e]);
        int resultS=arr[s];
        int resultE = arr[e];

        while(s<e){

            int cha = arr[s]+arr[e];
            if(Math.abs(cha)<range){
                range= Math.abs(cha);
                resultS=arr[s];
                resultE=arr[e];
            }

            if(cha<0){
                s++;
            } else if (cha>0) {
                e--;
            }else {
                resultS=arr[s];
                resultE=arr[e];
                break;
            }

        }
        if(resultS<resultE) System.out.println(resultS+" "+resultE);
        else System.out.println(resultE+" "+resultS);

    }
}
