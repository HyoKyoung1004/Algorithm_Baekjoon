import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());

        String numStr = br.readLine();
        char[] numCh = numStr.toCharArray();
        int result = 0;

        for(int i=0;i<numCh.length;i++){
            result+= numCh[i]-'0';
        }

        System.out.println(result);

    }
}
