import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        n= Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int result = getMaxSebsequence();
        if(result!=0) System.out.println(result);
        else System.out.println(getMaxElement());
    }

    static int getMaxSebsequence(){

        int tmp=0,max=0;
        for (int i=0;i<n;i++){
            tmp+=A[i];
            if(tmp>max) max=tmp;
            if(tmp<0) tmp=0;
        }
        return max;
    }

    //모두가 음수일 때
    static int getMaxElement(){

        int max=A[0];
        for(int i=1;i<n;i++){
            if(max<A[i])
                max=A[i];
        }
        return max;
    }


}
