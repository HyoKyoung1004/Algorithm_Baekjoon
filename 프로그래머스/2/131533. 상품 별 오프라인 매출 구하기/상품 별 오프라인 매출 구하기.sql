-- 코드를 입력하세요
SELECT  p.PRODUCT_CODE, total*p.price SALES
from PRODUCT p join 
(select PRODUCT_ID, sum(SALES_AMOUNT) total
from OFFLINE_SALE 
group by PRODUCT_ID) o
on p.PRODUCT_ID= o.PRODUCT_ID
order by SALES desc, p.PRODUCT_CODE
