import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class StringCompatator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int returnNum = 0;
        if (o1.length() == o2.length()) {
            int result1 = 0;
            int result2 = 0;

            for (int i = 0; i < o1.length(); i++) {
                char c = o1.charAt(i);
                if (c >= '0' && c <= '9') {
                    result1 += c - '0';
                }
            }

            for (int i = 0; i < o2.length(); i++) {
                char c = o2.charAt(i);
                if (c >= '0' && c <= '9') {
                    result2 += c - '0';
                }
            }
//            System.out.println("같을 때:" + o1 + ", " + o2);
//            System.out.println(result1 + ", " + result2);
//            System.out.println();

            returnNum = result1 - result2;

            if (returnNum == 0) {
                returnNum = o1.compareTo(o2);
            }


        } else {
            returnNum = o1.length() - o2.length();
        }

        return returnNum;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String[] stArr = new String[num];
        for (int i = 0; i < num; i++) {
            stArr[i] = br.readLine();
        }

        //System.out.println(Arrays.toString(stArr));

        Arrays.sort(stArr, new StringCompatator());

        //System.out.println(Arrays.toString(stArr));

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stArr.length; i++) {
            sb.append(stArr[i] + "\n");
        }

        System.out.println(sb);


    }
}
