import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        answer = garo(p);
        return answer;
    }
    
    
    private static String garo(String s){
        
        // System.out.println("입력: "+s);
        
        //1.
        if(s.equals("")) return s;
        
        
        //2.
        int left=0, right=0;
        char[] sArr = s.toCharArray();
        String u="",v="";
        
        for(int i=0;i<sArr.length;i++){
            if(sArr[i]=='(') left++;
            else right++;
            if(left==right){
                u = s.substring(0, i+1); 
                v = s.substring(i+1);
                break;
            }
        }
        // System.out.println(u+", "+v);
        
        //3. 
        if(check(u)) {
            u+=garo(v);
            return u;
        }else{
            
            String tmp ="(";
            tmp += garo(v);
            tmp+=")";
            
            char[] uArr = u.toCharArray();
            if(uArr.length>2){
                for(int k=1;k<uArr.length-1;k++){
                    if(uArr[k] =='(') tmp +=")"; 
                    else tmp +="(";
                }
            } 
            return tmp;
        }
        
        
    }
    
    private static boolean check(String s){
        
        char[] sArr = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<sArr.length;i++){
            
            if(sArr[i]=='('){
                stack.add('(');
            }else{
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        
        return true;
        
    }
}