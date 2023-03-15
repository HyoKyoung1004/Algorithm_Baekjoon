import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num =Integer.parseInt(br.readLine());

        String[] numStr = br.readLine().split(" ");
        int[] score = new int[num];
        int max = score[0]= Integer.parseInt(numStr[0]);
        for(int i=0;i<num;i++){
            score[i] = Integer.parseInt(numStr[i]);
            if(max < score[i])
                max=score[i];
        }

       // System.out.println(max);
        double result=0;
        for(int i=0;i<num;i++){
            result += score[i]/(double)max*100;
            //System.out.println( score[i]/(double)max*100);
        }
        System.out.println(result/num);

    }
}
