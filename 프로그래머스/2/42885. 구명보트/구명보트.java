import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        int small=0, large=people.length-1, result=0;
        
        while(large>small){
            if(people[large]+people[small] > limit){
                // System.out.println(people[large]);
                large--;
            }else{
                // System.out.println(people[large]+", "+people[small]);
                large--;
                small++;
                // System.out.println(people[large]+", "+people[small]); 
            }
            result++;
        }
        if(large==small) result++;
        
        int answer = 0;
        return result;
    }
}