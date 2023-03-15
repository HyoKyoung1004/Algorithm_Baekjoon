import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n =  scan.nextInt();
        int k = scan.nextInt();
        boolean[] arr = new boolean[n+1];
        int count=0;
        boolean complete=false;

        for(int i=2;i<=n;i++){

            if(arr[i] == false){

                for(int j=i;j<=n;j=j+i){
                    if(arr[j] ==true) continue;
                    arr[j] = true;
                    count++;
                    if(k==count){
                        System.out.println(j);
                        complete=true;
                        break;
                    }
                }
            }

            if(complete) break;

        }

    }
}