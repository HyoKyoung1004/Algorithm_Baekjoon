import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int s=1;
        int e=1;
        int sum=1;
        int count=0;
        int[] arr= new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = i;
        }

        while(s<=e ){
            if(n>sum){
                e++;
                sum+=arr[e];
            } else if (n < sum){
                sum -= arr[s];
                s++;

            }else{
                count++;
                sum -= arr[s];
                s++;
            }

        }

        System.out.println(count);

    }
}
