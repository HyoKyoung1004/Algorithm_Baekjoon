
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int m = scan.nextInt();
        int n= scan.nextInt();

        int[] a = new int[n+1];
        for(int i=0;i<a.length;i++){
            a[i]= i;
        }
        a[1]=0;
       // System.out.println(Arrays.toString(a));

        double root = Math.sqrt(n);
        //System.out.println(root);
        for(int i=2;i<=root;i++){
            if(a[i]==0) continue;
            for(int j=i+1;j<a.length;j++){
                if(a[j] % a[i] ==0 ) a[j]=0;
            }
        }

        //System.out.println(Arrays.toString(a));
        StringBuffer sb= new StringBuffer();

        for(int i=m;i<a.length;i++){
            if(a[i] !=0)
                sb.append(a[i]+"\n");
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);
    }
}
