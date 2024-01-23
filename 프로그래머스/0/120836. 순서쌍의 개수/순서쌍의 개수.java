import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int last = (int)Math.sqrt(n);        
        
        for(int i=1;i<=last;i++){
            if(n%i==0)
                answer++;
          }
        answer *=2;
        if(last*last == n) answer--;
        return answer;
    }
}