import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        long[] increase = new long[n];
        long[] decrease = new long[n];
        long inMax =0;
        long deMax=0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i==0) {
                increase[i]=1;
                decrease[i]=1;
            }else{

                if(arr[i] >= arr[i-1])
                    increase[i] = increase[i-1]+1;
                else increase[i] =1;

                if(arr[i]<=arr[i-1])
                    decrease[i]= decrease[i-1]+1;
                else decrease[i]=1;

            }
            inMax = Math.max(inMax,increase[i]);
            deMax = Math.max(deMax,decrease[i]);
        }

        System.out.println(Math.max(inMax,deMax));



    }
}
