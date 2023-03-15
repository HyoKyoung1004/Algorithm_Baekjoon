import java.util.Scanner;

public class Main {

    static int[] teamA = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4}; //6개의 국가는 총 15개의 게임을 하게 됨.
    static int[] teamB = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};

    static int[][] input, make;
    static int ans;


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); //0승, 1:무, 2:패

        for (int tc = 1; tc <= 4; tc++) {

            input = new int[6][3];
            make = new int[6][3];

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    input[i][j] = scan.nextInt();
                }
            }

            ans = 0;
            game(0);
            System.out.print(ans + " ");
        }

    }

    private static boolean check() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (make[i][j] != input[i][j])
                    return false;
            }
        }
        return true;
    }

    //3의 15제곱
    private static void game(int gameIdx) {

        if (gameIdx == 15) {
            //자 여기까지 모든 경이긔 승패가 기록되었다!, input과 일치하는 가? 아니면 국가들의 승패를 바꾸러 돌아간다.

            //자 이젠 일치 여부를 보장!!
            if (check()) ans = 1;

            return;
        }

        int team1 = teamA[gameIdx];
        int team2 = teamB[gameIdx];

        if (input[team1][0] > make[team1][0] && input[team2][2] > make[team2][2]) {
            //이기는 경우, 1이 이기는 경우
            make[team1][0]++;
            make[team2][2]++;
            game(gameIdx + 1);
            make[team1][0]--; //다시 돌려놓는다!!!
            make[team2][2]--;
        }

        //비기는 경우
        if (input[team1][1] > make[team1][1] && input[team2][1] > make[team2][1]) {
            make[team1][1]++;
            make[team2][1]++;
            game(gameIdx + 1);
            make[team1][1]--;
            make[team2][1]--;
        }

        //지는 경우, 2가 이기는 경우
        if (input[team2][0] > make[team2][0] && input[team1][2] > make[team1][2]) {
            make[team1][2]++;
            make[team2][0]++;
            game(gameIdx + 1);
            make[team1][2]--;
            make[team2][0]--;
        }
    }

}