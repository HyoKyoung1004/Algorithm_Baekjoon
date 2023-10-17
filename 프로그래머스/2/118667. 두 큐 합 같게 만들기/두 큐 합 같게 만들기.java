import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1=0, sum2=0;
        
        for(int i=0;i<queue1.length;i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1+= queue1[i];
            sum2 += queue2[i];
        }
        
        if( (sum1+sum2)%2==1)
            return -1;
        
        int count=0;
        while(sum1!=sum2 && !q1.isEmpty() && !q2.isEmpty() && count<= queue1.length*4){
            
            if(sum1 > sum2){
                int tmp1 = q1.poll();
                sum1-= tmp1;
                sum2+= tmp1;
                q2.add(tmp1);
            }else{
                int tmp2 = q2.poll();
                sum2-= tmp2;
                sum1+= tmp2;
                q1.add(tmp2);
            }
            count++;
        }
        
        if(q1.isEmpty() || q2.isEmpty() || sum1 != sum2){
            return -1;
        }

        return count;
    }
}