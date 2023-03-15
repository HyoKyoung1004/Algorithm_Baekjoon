import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static boolean[][] arr = new boolean[101][101];
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i=0;i<n;i++){

            int y = scan.nextInt();
            int x = scan.nextInt();
            int d = scan.nextInt();
            int g = scan.nextInt();

            ArrayList<Integer> al = new ArrayList<>();
            al.add(d);
            arr[x][y]=true;
            x = x+dx[d];
            y = y+dy[d];
            arr[x][y]=true;

            for(int k=0;k<g;k++){

                int size = al.size();
                for(int l = size-1;l>=0;l--){
                    int direc = al.get(l);
                    direc = direc==3 ?0 :direc+1;
                    al.add(direc);
                    x = x+dx[direc];
                    y = y+dy[direc];
                    arr[x][y]=true;
                }
            }

        }
        int count=0;
        for(int i=0;i<=99;i++){
            for(int j=0;j<=99;j++){
                if(arr[i][j] && arr[i+1][j] &&arr[i][j+1] && arr[i+1][j+1])
                    count++;
            }
        }
        System.out.println(count);

    }
}