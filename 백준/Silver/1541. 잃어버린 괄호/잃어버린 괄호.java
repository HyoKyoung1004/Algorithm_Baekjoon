import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int result = 0;
        String tmp = "";
        boolean flag = false;

        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                tmp += arr[i];
            } else if (arr[i] == '+') {
                if (!flag) result += Integer.parseInt(tmp);
                else result -= Integer.parseInt(tmp);
                tmp = "";
            } else {
                if (!flag) result += Integer.parseInt(tmp);
                else result -= Integer.parseInt(tmp);
                flag = true;
                tmp = "";
            }
        }
        if (!flag) result += Integer.parseInt(tmp);
        else result -= Integer.parseInt(tmp);
        System.out.println(result);
    }
}