import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int n = KMPMatch(s1,s2);
       if(n>0) System.out.println(1);
       else System.out.println(0);

    }

    private static int KMPMatch(String str, String pattern){

        int count=0;
        int[] skipTable = makeTable(pattern);
        int plen = pattern.length();

        int idx=0,i=0;
        while (i<str.length() && idx<plen){


            if(str.charAt(i) == pattern.charAt(idx)){
                if(idx== plen-1){
                    count++;
                    idx = skipTable[idx];
                    i++;
                }else {
                    idx++;i++;
                }
            }else{
                if(idx>0) {
                    idx = skipTable[idx-1];
                }else{
                    i++;
                }
            }
        }
        return count;
    }


    private static int[] makeTable(String pattern) {

        int length = pattern.length();
        int[] skipTable = new int[length];

        int i=1, idx=0;
        while(i<length){

            if(pattern.charAt(i) == pattern.charAt(idx)){
                skipTable[i++] = ++idx;
            }else{
                if(idx>0){
                    idx=skipTable[idx-1];
                }else{
                    i++;
                }
            }
        }
        return skipTable;
    }


}