import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        long count=0;
        long maxCount=count;
        long maxNumber=0;

        for(int i=num;i>=1;i--){
           int a=num;
           int b=i;
           int c=a-b;
           while(c>=0){
               count++;
               a=b;
               b=c;
               c=a-b;
           }
           if(maxCount <count){
               maxCount=count;
               maxNumber=i;
           }
           count=0;
        }


        StringBuffer sb= new StringBuffer();
        sb.append(maxCount+2+"\n");
        sb.append(num+" ");
        sb.append(maxNumber+" ");
        long a= num;
        long b = maxNumber;
        long c= a-b;
        while(c>=0){
            sb.append(c+" ");
            a=b;
            b=c;
            c=a-b;
        }

        System.out.println(sb.delete(sb.length()-1,sb.length()));


    }
}
