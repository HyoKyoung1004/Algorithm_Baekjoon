import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class AbsSorting implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {

        int tmp1 = Math.abs(o1);
        int tmp2 = Math.abs(o2);
        if (tmp1 == tmp2 )
            return o1-o2;
        else return tmp1-tmp2;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(new AbsSorting());
        StringBuffer sb= new StringBuffer();

        for(int i=0;i<n;i++){

            int x = Integer.parseInt(br.readLine());

            if(x==0){
                if(q.isEmpty()) sb.append(0+"\n");
                else  sb.append(q.poll()+"\n");
            }else{
                q.offer(x);
            }

        }
        System.out.println(sb);

    }
}


