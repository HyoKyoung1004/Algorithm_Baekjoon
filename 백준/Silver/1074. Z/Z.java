import java.util.Scanner;

public class Main {

    static long count=0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= scan.nextInt();
        int r = scan.nextInt();
        int c = scan.nextInt();
        count(n,r,c);
        System.out.println(count);
    }

    static void count(int n,int r,int c){

        if(n<0) return;

        int length = (int) Math.pow(2,n);
        long total = length * length;
        long one_four = total/4;
        long half_length = length/2;

        if(r<half_length && c>=half_length){  // 오른쪽 위
            count += one_four;
            c-= half_length;
        }else if(r>=half_length && c<half_length ){  //왼쪽 아래
            count += one_four *2;
            r-= half_length;
        }else if(r>= half_length && c>=half_length ){ //오른쪽 아래
            count += one_four *3;
            r-= half_length;
            c-= half_length;
        }
        count( n-1, r, c);

    }

}