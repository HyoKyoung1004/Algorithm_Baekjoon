import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        double last = Math.sqrt(n);        
        // System.out.println(last);
        
        for(int i=1;i<=n;i++){
            if(n%i==0){
                // System.out.println(i+", "+n/i);
                answer++;
            }
        
          }
        // answer *=2;
        // if(last*last == n) answer--;
        return answer;
    }
}