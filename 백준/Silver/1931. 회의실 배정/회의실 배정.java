import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class compare implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        int[] a = (int[])o1;
        int[] b= (int[]) o2;
        if(a[1]==b[1])
            return a[0]-b[0];
        else
            return a[1] - b[1];
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        int[][] a = new int[n][2];
        StringTokenizer st;
        int min=0;
        int max=0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
            if(max<a[i][1]) max=a[i][1];

        }

        //끝나는 수가 빠른 것대로 정렬
        Arrays.sort(a, new compare());
       // System.out.println(Arrays.deepToString(a));


        int c=1;
        int e=a[0][1]; // 끝나는 것이 가장 빠른 것부터 시작한다.

        for(int i=1;i<n;i++){
            if(a[i][0]>=e){ //시작시간이 이전 회의의 끝나는 시간보다 크면
                e=a[i][1];
                c++;
            }
        }

        System.out.println(c);



    }
}


