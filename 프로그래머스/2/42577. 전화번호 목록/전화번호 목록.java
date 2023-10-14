import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        boolean answer = true;
        
        Arrays.sort(phone_book);
       // System.out.println(Arrays.toString(phone_book));
        
        int length = phone_book.length;
        for(int i=0;i<length-1;i++){
            
            int iLength = phone_book[i].length();
            int jLength = phone_book[i+1].length();
            
            if(iLength> jLength) continue;
            String tmpString =  phone_book[i+1].substring(0,iLength);
            if(phone_book[i].equals(tmpString)){
                    answer = false;
                    break;
                }
            
            
            
//             int iLength = phone_book[i].length();
            
//             for(int j=0;j<length;j++){
                
//                 int jLength = phone_book[j].length();

//                 if(i==j || iLength > jLength) continue;
                

//                 String tmpString =  phone_book[j].substring(0,iLength);

//                 //System.out.println(iLength+", "+jLength+","+phone_book[i]+", "+tmpString );

//                 if(phone_book[i].equals(tmpString)){
//                     answer = false;
//                     break;
//                 }
                
                
//             }
//             if(!answer) break;
        }
        
        
        return answer;
        
    }
}

