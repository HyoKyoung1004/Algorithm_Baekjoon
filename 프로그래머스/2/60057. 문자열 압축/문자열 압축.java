class Solution {
    public int solution(String s) {
        
        int answer = s.length();
        for(int i=1;i<=s.length()/2;i++){ //문자열의 크기
            
            String result="";
            String re = "";
            int count=0;
            
            for(int k=0;k<s.length();k=k+i){
                String tmp ="";
                if(k+i > s.length())                    
                    tmp =  s.substring(k, s.length());
                else
                     tmp = s.substring(k, k+i);
                
                if(re.equals(tmp)){
                    count++;
                }else{
                    if(!re.equals("")) {
                        if(count==1)
                result+=re;
                        else result+= count+re;
                    }
                    re=tmp;
                    count=1;
                }
            }
            
            if(count==1){
                result+=re;
            }else{
                result+=count+re;
            }
            //System.out.println(result);
            int leng = result.length();
            if(answer>leng) answer = leng;
            
        }
        
        return answer;
        
        
    }
}
      