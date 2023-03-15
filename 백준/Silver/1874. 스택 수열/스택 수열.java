import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //첫줄에 n이 주어진다.
        int n = Integer.parseInt(br.readLine());
        int[] numList = new int[n];
        for (int i = 0; i < n; i++) {
            numList[i] = Integer.parseInt(br.readLine());
        }

        Stack st = new Stack();
        StringBuffer sb = new StringBuffer();
        StringBuffer sbNo = new StringBuffer();

        int i = 0;

        for (int k = 0; k < numList.length; k++) {

            //push하고, 마지막 push 꺼내기
            if (i < numList[k]) {
                while (i != numList[k]) {
                    st.push(++i);
                    sb.append("+\n");

                }
                if (i == numList[k]) {
                    st.pop();
                    sb.append("-\n");
                    continue;
                }

            }  //push안해도 될 때
            if ((int) st.peek() == numList[k] && !st.isEmpty()) {
                st.pop();
                sb.append("-\n");
                continue;

            } else if ((int) st.peek() > numList[k]) {
                //System.out.println("작아서 중단인데");
                sbNo.append("No");
                break;
            }

        }


        if (st.isEmpty()) System.out.println(sb);
        else System.out.println("NO");


    }
}
