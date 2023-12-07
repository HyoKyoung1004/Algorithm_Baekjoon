-- 코드를 입력하세요
select info.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(REVIEW_SCORE),2) SCORE
from REST_INFO info join REST_REVIEW review on info.REST_ID = review.rest_id 
where ADDRESS like "서울%"
group by REST_ID
order by SCORE desc, FAVORITES desc