import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num= Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] habArr= new int[num];

        st = new StringTokenizer(br.readLine());
        habArr[0] =  Integer.parseInt(st.nextToken());
        for(int i=1;i<num;i++){
            habArr[i]= habArr[i-1]+Integer.parseInt(st.nextToken());
        }

        //System.out.println(Arrays.toString(habArr));
        StringBuffer sb = new StringBuffer();
        for(int k=0;k<count;k++){
            st = new StringTokenizer(br.readLine());
            int i= Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            if(i==0) sb.append(habArr[j]+"\n");
            else sb.append(habArr[j]-habArr[i-1]+"\n");

        }

        System.out.println(sb);


    }
}
