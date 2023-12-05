import java.util.*;

class Solution {
    static char[] cards;
    static int size;
    static Map<String, Integer> map;
    static ArrayList<String> result;
    public String[] solution(String[] orders, int[] course) {
        
        result = new ArrayList<>();
        
        //1. 자 일단 orders의 문자열을 정렬해야함
        for(int i=0;i<orders.length;i++){
            char[] tmp =orders[i].toCharArray();
            Arrays.sort(tmp);
            orders[i] = new String(tmp);
        }
        
        //System.out.println(Arrays.toString(orders));
        
        
        //2. 각 문자들을 course길이에 맞게 잘라야지
        for(int i=0;i<course.length;i++){
            
            map = new HashMap<>();
            cards= new char[course[i]];
            size = course[i];
            
            for(int j=0;j<orders.length;j++){
                if(orders[j].length()< course[i]) continue;
                comb(orders[j].toCharArray(), 0, 0);
            }
            
            //3. map중에서 가장 많이 주문된 것을 선정함,
            // System.out.println(course[i]);
            // System.out.println(map);
            
            int max = 0;
            for(Integer value : map.values()){
                if(value>max) max=value;
            }
            
            if(max==1) continue;
            for(String key : map.keySet()){
                if(map.get(key) == max) result.add(key);
            }
            
        }
    
        Collections.sort(result);
        // System.out.println(result);
        String[] answer = new String[result.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    static void comb(char[] target, int now, int next){
        
        if(now == size){
            String tmp = new String(cards);
            map.put(tmp, map.getOrDefault(tmp,0)+1);
            return;
        }
        
        for(int i=next;i<target.length;i++){
            cards[now] = target[i];
            comb(target, now+1, i+1);
        }
        
    }
}