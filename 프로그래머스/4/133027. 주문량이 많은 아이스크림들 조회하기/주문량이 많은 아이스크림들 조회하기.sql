-- 코드를 입력하세요

#7월의 아이스크림 총 주문량 + 상반기 아이스크림 총 주문량

select j.FLAVOR
from JULY j join FIRST_HALF h 
on j.FLAVOR = h.FLAVOR
group by j.FLAVOR
order by sum(j.TOTAL_ORDER)+ sum(h.TOTAL_ORDER)  desc
limit 3
