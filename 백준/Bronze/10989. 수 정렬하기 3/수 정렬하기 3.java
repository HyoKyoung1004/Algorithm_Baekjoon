import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{


        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(br.readLine());

        int arr[] = new int[num];
        int[] tmp= new int[10001];

        for(int i=0;i<num;i++){
            arr[i]= Integer.parseInt(br.readLine());
            tmp[arr[i]]++;
        }
       // System.out.println(Arrays.toString(arr));
        int count=0;
        for(int i=1;i< tmp.length;i++){
            if(tmp[i]!=0){
                for(int j=0;j<tmp[i];j++){
                    arr[count]=i;
                    count++;
                }
            }
        }

       // System.out.println(Arrays.toString(arr));

        StringBuffer sb= new StringBuffer();

        for(int i=0;i<num;i++){
           sb.append(arr[i]+"\n");
        }
        System.out.println(sb);

    }
}
