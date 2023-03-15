import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> b;

    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n+1];
        int[] dp= new int[n+1];
         b = new ArrayList<>();
        b.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){

            a[i] = Integer.parseInt(st.nextToken());


            if(b.get(b.size()-1)<a[i]) {  //이전 수열의 값보다 더 클 때는 이전에서 +1만 하면 된다.

                dp[i] = dp[b.size()-1] + 1;
                b.add(a[i]);

            }else {  //더 작은 경우 B에서 index를 찾아야 하는디

                int index = binarySearch(1,b.size()-1,a[i]);
                if(b.get(index) < a[i]){
                    dp[i] = index+1;
                    if(index+1 > b.size()-1)
                        b.add(a[i]);
                    else{
                        if(b.get(index+1) > a[i]) //기존의 값보다 더 작으면 교체
                        b.set(index+1,a[i]);
                    }
                }else{
                    dp[i] = index;
                    if(b.get(index) > a[i]) //기존의 값보다 더 작으면 교체
                        b.set(index,a[i]);
                }
            }

        }


        StringBuffer sb = new StringBuffer();
        int result = b.size()-1;
        sb.append(result+"\n");

        System.out.println(sb);

    }

    static  int binarySearch(int start, int end, int value) {

        int mid;
        while (start < end) {

            mid = (start + end) / 2;

            if (value > b.get(mid))
                start = mid + 1;
            else
                end = mid;
        }
        return start;

    }
}

