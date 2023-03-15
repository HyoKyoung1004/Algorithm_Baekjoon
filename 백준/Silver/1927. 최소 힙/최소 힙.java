import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        //PriorityQueue<Integer> pq = new PriorityQueue<>(new MaxHeapOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){

            int tmp =  Integer.parseInt(br.readLine());
            if(tmp ==0 ){
                if(pq.isEmpty())
                    sb.append(0+"\n");
                else sb.append(pq.poll()+"\n");
            }else
                pq.offer(tmp);

        }


        System.out.println(sb);

    }

}


