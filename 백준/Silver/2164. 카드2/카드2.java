import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {


        Queue q= new LinkedList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i=1;i<=num;i++){
            q.add(i);
        }
        //System.out.println(q);

        while(q.size()!=1){
            q.poll();
            Object obj = q.peek();
            q.poll();
            q.add(obj);
            //System.out.println(q);
        }
        br.close();
        System.out.println(q.peek());



    }
}
