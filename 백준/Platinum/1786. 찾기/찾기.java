import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

      // System.out.println(Arrays.toString(makeTable(s2)));

        System.out.println(KMPMatch(s1,s2));
        System.out.println(sb);


    }

    private static int KMPMatch(String str, String pattern){

        int count=0;
        int[] skipTable = makeTable(pattern);
        int plen = pattern.length();

        int idx=0,i=0;
        while (i<str.length() && idx<plen){

            //System.out.println(i+": "+idx);

            if(str.charAt(i) == pattern.charAt(idx)){
                if(idx== plen-1){
                    count++;
                    sb.append((i-plen+2)+" ");
                    idx = skipTable[idx]; //다음 문자부터는 skip테이블 이용해서 다음 문잦부터 처리
                    i++;
                }else {
                    idx++;i++;
                }
            }else{
                if(idx>0) { //다르다, 그러면 이전까지 봤던 skiptable의 마지막 그 다음부터 보기
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