import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        //int num = scan.nextInt();
        String[] result = new String[num];

        for (int i = 0; i < num; i++) {
            //scan = new Scanner(System.in);
            String str = br.readLine();
            Stack st = new Stack();
            try {
                for (int k = 0; k < str.length(); k++) {
                    char ch = str.charAt(k);
                    if (ch == '(')
                        st.push(ch + "");
                    else if (ch == ')')
                        st.pop();
                }
                if (st.isEmpty()) result[i] = "YES";
                else result[i] = "NO";
            } catch (Exception e) {
                result[i] = "NO";
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
