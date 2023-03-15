import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N, M, X, Y, K;
    static int[][] arr;
    static int dice[];
    static int[] now;
    static int[] order;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        M = scan.nextInt();
        X = scan.nextInt();
        Y = scan.nextInt();
        K = scan.nextInt();

        arr = new int[N][M];
        dice = new int[7];
        now = new int[]{1, 3, 4, 2, 5, 6};
        order = new int[K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            order[i] = scan.nextInt();
        }

        conductOrder();
        System.out.println(sb);

    }

    static void conductOrder() {


        for (int d = 0; d < K; d++) {

            int nextX = X + dx[order[d]];
            int nextY = Y + dy[order[d]];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;

            X = nextX;
            Y = nextY;

            swichDice(order[d]);
            sb.append(dice[now[0]] + "\n");

            if (arr[X][Y] == 0){
                arr[X][Y] = dice[now[5]];
            }
            else {
                dice[now[5]] = arr[X][Y];
                arr[X][Y]=0;
            }
        }
    }

    private static void swichDice(int direc) {

        int tmpDice[] = new int[0];
        if (direc == 1)  //동쪽,
            tmpDice = new int[]{now[1], now[5], now[0], now[3], now[4], now[2]};
        else if (direc == 2)  //서쪽
            tmpDice = new int[]{now[2], now[0], now[5], now[3], now[4], now[1]};
        else if (direc == 3)  //북쪽
            tmpDice = new int[]{now[3], now[1], now[2], now[5], now[0], now[4]};
        else if (direc == 4)  //남쪽
            tmpDice = new int[]{now[4], now[1], now[2], now[0], now[5], now[3]};

        now = tmpDice;
    }
}