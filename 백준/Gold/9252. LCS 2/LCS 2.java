import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static char[] a;
    static char[] b;
    static long[][] D;
    static ArrayList<Character> list;
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb= new StringBuffer();
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        int al = a.length;
        int bl = b.length;

        D=  new long[al+1][bl+1];

        for(int i=1;i<=al;i++){
            for(int j=1;j<=bl;j++){
                if(a[i-1] == b[j-1])
                    D[i][j] = D[i-1][j-1]+1;
                else
                    D[i][j]= Math.max(D[i-1][j], D[i][j-1]);

            }
        }
        sb.append(D[al][bl]+"\n");

        list= new ArrayList<>();
        getText(al,bl);

        for(int i = list.size()-1; i>=0;i-- ){
            sb.append(list.get(i));
        }

        System.out.println(sb+"\n");
    }

    private static void getText(int al, int bl) {

        if(al==0 || bl==0)return;

        if(a[al-1] == b[bl-1]){
            list.add(a[al-1]);
            getText(al-1,bl-1);
        }else{
            if(D[al-1][bl] > D[al][bl-1])
                getText(al-1,bl);
            else getText(al,bl-1);
        }
    }
}
