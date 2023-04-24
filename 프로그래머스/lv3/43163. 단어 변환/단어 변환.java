import java.util.*;
class Solution {
    static boolean[] visit;
    
    public int solution(String begin, String target, String[] words) {
        
        visit =new boolean[words.length];
        int answer  = bfs(begin, target,words );
        return answer;
    }
    
   static int bfs(String begin, String target, String[] words){
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        int count=0;
        int len= begin.length();
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0;s<size;s++){
                String now = q.poll();
                if(now.equals(target)){
                    return count;
                }
                for(int i=0;i<words.length;i++){
                    if(visit[i]) continue;
                    int tmp=0;
                    for(int j=0;j<len;j++){
                        if(now.charAt(j)== words[i].charAt(j)) tmp++;
                    }
                    if(tmp== len-1){
                        q.add(words[i]);
                        visit[i]=true;
                    }
                } //하나씩 확인
            }//size만큼
            count++;
        }//큐가 비어있지 않으면
         return 0;
    }
}