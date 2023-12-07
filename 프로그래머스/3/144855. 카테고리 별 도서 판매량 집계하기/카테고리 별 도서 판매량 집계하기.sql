-- 코드를 입력하세요
SELECT CATEGORY, sum(sales) as TOTAL_SALES
# sum(sales) as TOTAL_SALES
from BOOK b join BOOK_SALES s on b.book_id = s.book_id
where SALES_DATE between '2022-01-01' and '2022-01-31'
group by CATEGORY
order by CATEGORY