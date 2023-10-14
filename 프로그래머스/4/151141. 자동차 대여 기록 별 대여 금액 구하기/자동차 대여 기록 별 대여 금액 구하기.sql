-- 코드를 입력하세요


# 자동차 종류가 트럭 자동차의 대여기록
# 대역 기록별로 대여 금액
# 대여 기록 ID, 금액리스트 출력


select HISTORY_ID,

Case 
when days>=90 then floor(daily_fee *days* (100 - (select discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where CAR_TYPE = '트럭' and  DURATION_TYPE='90일 이상'))/100 )
when days>=30 then floor(daily_fee *days* (100 - (select discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where CAR_TYPE = '트럭' and  DURATION_TYPE='30일 이상'))/100 )
when days>=7 then floor(daily_fee *days* (100 - (select discount_rate from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where CAR_TYPE = '트럭' and  DURATION_TYPE='7일 이상'))/100 )
else daily_fee *days
end FEE

from (
select history_id, daily_fee, end_date, start_Date , DATEDIFF( end_date, start_date)+1 days from CAR_RENTAL_COMPANY_CAR car
join CAR_RENTAL_COMPANY_RENTAL_HISTORY history
on car.CAR_ID = history.CAR_ID
where CAR_TYPE ='트럭'
) a
order by fee desc, history_id desc

# select history_id, daily_fee, end_date, start_Date , to_days(end_date) - to_days(start_date)+1 days from CAR_RENTAL_COMPANY_CAR car
# join CAR_RENTAL_COMPANY_RENTAL_HISTORY history
# on car.CAR_ID = history.CAR_ID
# where CAR_TYPE ='트럭'