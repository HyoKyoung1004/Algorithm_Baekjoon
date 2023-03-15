import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum=0;
        for(int i=0;i<m;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum+= arr[i];
        }

        int k= Integer.parseInt(br.readLine());

        if(m==1){
                System.out.println(1.0);

        }else{

            if(k==1) System.out.println(1.0);

            else{


                double result =0;
                for(int i=0;i<m;i++){
                    if(arr[i] <k) continue;
                    double tmp=1 ;
                    for(int j=0; j<k;j++){
                        tmp *= (double)(arr[i]-j)/(double)(sum-j);
                    }
                    result+= tmp;

                }
                System.out.println(result);

            }
        }
    }
}
