-- 코드를 입력하세요
SELECT USER_ID,NICKNAME, sum(PRICE) TOTAL_SALES
from USED_GOODS_BOARD b join USED_GOODS_USER u on b.WRITER_ID = u.USER_ID
where STATUS="DONE"
group by USER_ID
having TOTAL_SALES >=700000
order by TOTAL_SALES

