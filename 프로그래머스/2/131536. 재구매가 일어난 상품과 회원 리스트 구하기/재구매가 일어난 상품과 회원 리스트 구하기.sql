-- 코드를 입력하세요
# select a.user_id, a.product_id
# from ONLINE_SALE a join ONLINE_SALE b
# where a.USER_ID =  b.user_id and a.PRODUCT_ID = b.PRODUCT_ID and a.SALES_DATE != b.SALES_DATE
# group by a.user_id, a.product_id


select user_id, product_id
from ONLINE_SALE
group by user_id, product_id
having count(*) >=2
order by user_id, product_id desc