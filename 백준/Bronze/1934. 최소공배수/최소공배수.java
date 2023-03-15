import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb= new StringBuffer();
        StringTokenizer st;

        int t= Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){


            st = new StringTokenizer(br.readLine());
            int n1= Integer.parseInt(st.nextToken());
            int n2 =Integer.parseInt(st.nextToken());
            int gcdNum = 0;
            if(n1> n2) gcdNum= gcd(n1,n2);
            else gcdNum= gcd(n2,n1);

            int result = (n1*n2)/gcdNum;

            sb.append(result+"\n");
        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        int result = a%b;
        if(result==0) return b;
        else return a > b ? gcd(b,result) : gcd(a,result);
    }
}
