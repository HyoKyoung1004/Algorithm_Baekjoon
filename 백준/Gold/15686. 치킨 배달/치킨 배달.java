import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[] result;
    static ArrayList<int[]> al;
    static int length;
    static long min = Long.MAX_VALUE;

    static int[][] distanceArr;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        al = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {

                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    al.add(new int[]{i, j});
                }

            }
        }

        length = al.size(); //치킨집의 갯수
        result = new boolean[length]; //치킨집 중 선택한 것을 표시할 배열

        combination(0, 0);

        System.out.println(min);


    }

    private static void combination(int cnt, int start) {

        if (cnt == M) {
           // System.out.println(Arrays.toString(result));
            distanceArr = new int[N + 1][N + 1];

            for (int i = 0; i < length; i++) {

                if (!result[i]) continue;
                calculation(al.get(i));
            }
          //  System.out.println(Arrays.deepToString(distanceArr));
            long distance = sumDisatance();
            if (distance < min)
                min = distance;

            return;
        }

        for (int i = start; i < length; i++) {
            result[i] = true;
            combination(cnt + 1, i + 1);
            result[i] = false;
        }


    }

    private static long sumDisatance() {
        long sum = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum += distanceArr[i][j];

            }
        }
        return sum;
    }

    private static void calculation(int[] is) {

        int x = is[0];
        int y = is[1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i][j] == 0 || arr[i][j] == 2) continue;

                int distance = Math.abs(x - i) + Math.abs(y - j);
                if (distanceArr[i][j] == 0) distanceArr[i][j] = distance;
                else distanceArr[i][j] = Math.min(distanceArr[i][j], distance);
            }
        }

        //System.out.println(Arrays.deepToString(distanceArr));
    }




}