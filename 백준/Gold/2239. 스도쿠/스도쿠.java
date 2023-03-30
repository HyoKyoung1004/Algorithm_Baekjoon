import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int N = 9;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[N][N];

        //입력
        for(int i=0; i<N; i++) {
           String str = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        Sdoku();
    }

    private static void Sdoku() {
        int[] idx = findZeroIdx();

        if(idx[0] == -1) {
            print();
            System.exit(0);
        }

        for(int i=1; i<=9; i++) {
            if(isPosition(idx, i)) {
                map[idx[0]][idx[1]] = i;
                Sdoku();
                map[idx[0]][idx[1]] = 0;
            }
        }
    }

    private static int[] findZeroIdx() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static boolean isPosition(int[] idx, int num) {
        int r = idx[0];
        int c = idx[1];
        // 가로 || 세로 체크
        for(int i=0; i<N; i++) {
            if(map[r][i] == num || map[i][c] == num) return false;
        }
        //같은 블럭 체크
        int sr = (r/3)*3;
        int sc = (c/3)*3;

        for(int i=sr; i<sr+3; i++) {
            for(int j=sc; j<sc+3; j++) {
                if(map[i][j] == num) return false;
            }
        }
        return true;
    }

    private static void print() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}