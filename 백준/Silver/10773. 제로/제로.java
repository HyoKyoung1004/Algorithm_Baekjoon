import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();

        Stack st = new Stack();

        for (int i = 0; i < k; i++) {
            int num = scan.nextInt();
            if (num == 0) {
                st.pop();
            } else {
                st.push(num);
            }
            //System.out.println(st);
        }

        //System.out.println(st.size());
        int result = 0;
        if (st.isEmpty()) System.out.println(result);
        else {
            for (int i = 0; i < st.size(); i++) {
                result += (int) st.get(i);
            }
            System.out.println(result);
        }

    }
}
