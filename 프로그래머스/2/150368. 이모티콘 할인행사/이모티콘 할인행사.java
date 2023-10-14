import java.util.*;

class Solution {
    
    static int[] salePercent = {10,20,30,40};
    static int emoticonLength;
    static int[] saleResult, emoticon, userTotal;
    static int person, money;
    static int[][] user;
    public int[] solution(int[][] users, int[] emoticons) {
        
        emoticonLength = emoticons.length;
        //System.out.println(emoticonLength);
        
        saleResult = new int[emoticonLength];
        userTotal = new int[users.length];
        emoticon = emoticons;
        user= users;
        setEmoticonSalePercent(0);
        
        
        int[] answer = new int[2];
        answer[0] = person;
        answer[1]= money;
        
        return answer;
    }
    
    static void setEmoticonSalePercent(int count){
        
        if(count==emoticonLength){
            
           // System.out.println(Arrays.toString(saleResult));
            
            //각 유저마다 할인율이 넘는다면 구매하는 최종 가격을 계산
            for(int i=0;i<user.length;i++){
                int tmp = 0;
                for(int j=0;j<emoticonLength;j++){
                    if(saleResult[j]>=user[i][0]){//일정비율이상 할인하는 이모티콘
                        tmp += emoticon[j] *(100-saleResult[j]) /100;
                    }
                }
                userTotal[i]=tmp;
            }
          //  System.out.println(Arrays.toString(userTotal));
            
            //구매 최종가격이 정해진 가격을 넘으면 가입자 추가, 아니면 구매액 추가
            
            int newUser=0, newMoney=0;
            for(int i=0;i<user.length;i++){
                if(userTotal[i] >= user[i][1]){
                    newUser++;
                }else{
                    newMoney+= userTotal[i];
                }
                
            }            
            //가입자가 더 많으면 이 것을 반영, 같으면 구매액반영
            if(newUser > person){
                person = newUser;
                money= newMoney;
            }else if(newUser == person && money <newMoney)
                money= newMoney;

            return;
        }
        
        for(int i=0;i<4;i++){
            saleResult[count] = salePercent[i];
            setEmoticonSalePercent(count+1);
            
        }
    }
}