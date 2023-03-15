import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String str = br.readLine();
            if(str==null) str="";
            if (str.equals(".")) break;

            Stack st = new Stack();


                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    //System.out.println(ch);
                    if (ch == '(') st.push(ch + "");
                    else if (ch == ')') {
                        if (!st.empty() && st.peek().equals("("))
                            st.pop();
                        else st.push(ch+"");
                    } else if (ch == '[') {
                        st.push(ch + "");
                    } else if (ch == ']') {
                        if (!st.empty() && st.peek().equals("[")) {
                            st.pop();
                        }else st.push(ch+"");
                    }

                }
                if (st.isEmpty()) bw.write("yes\n");
                else  bw.write("no\n");;
                st.clear();


        }

        br.close();
        bw.flush();
        bw.close();
    }
}
