import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String dna = br.readLine();
        int[] num = new int[4];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            num[i]= Integer.parseInt(st.nextToken());
        }

        int[] dnaChecker = new int[4];

        int result=0;
        //초기에 담아
        char[] substring= dna.substring(0,p).toCharArray();
        for(char c : substring){
                if(c=='A') dnaChecker[0]++;
                else if (c=='C') dnaChecker[1]++;
                else if(c=='G') dnaChecker[2]++;
                else if(c=='T') dnaChecker[3]++;
            }
        int i =0, j=i+p-1;

        while (j < dna.length()) {

            if ((dnaChecker[0] >= num[0]) && (dnaChecker[1] >= num[1]) && (dnaChecker[2] >= num[2]) && (dnaChecker[3] >= num[3]))
                result++;
            char c = dna.charAt(i);
            if (c == 'A') dnaChecker[0]--;
            else if (c == 'C') dnaChecker[1]--;
            else if (c == 'G') dnaChecker[2]--;
            else if (c == 'T') dnaChecker[3]--;

            i++;
            j++;
            if(j==dna.length()) break;

            c = dna.charAt(j);
            if (c == 'A') dnaChecker[0]++;
            else if (c == 'C') dnaChecker[1]++;
            else if (c == 'G') dnaChecker[2]++;
            else if (c == 'T') dnaChecker[3]++;


        }

        System.out.println(result);

    }
}
