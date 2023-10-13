-- 코드를 입력하세요


# 자동차 종류 : 세단, SUV
# 2022.11.1 ~ 2022 11.30 대여 가능 ->  기록에 없어야 함
# 30일 대여 금액 50만원 이상 200만원 미만



#select * from CAR_RENTAL_COMPANY_CAR where CAR_TYPE in ('SUV', '세단');

# select * from CAR_RENTAL_COMPANY_CAR where CAR_TYPE in ('SUV', '세단') 
# and car_id not in
# (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
# where start_DATE between '2022-11-01' and '2022-11-30' 
# OR  end_Date between '2022-11-01' and '2022-11-30' 
# or (start_date < '2022-11-01' and end_Date > '2022-11-30' )
# )

select * from 
(
select CAR_ID, a.CAR_type, floor((daily_fee *(100 - DISCOUNT_RATE) /100)*30) as FEE
from (

select * from CAR_RENTAL_COMPANY_CAR where CAR_TYPE in ('SUV', '세단') 
and car_id not in
(select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where start_DATE between '2022-11-01' and '2022-11-30' 
OR  end_Date between '2022-11-01' and '2022-11-30' 
or (start_date < '2022-11-01' and end_Date > '2022-11-30' )
)
    
) a

join 
(select * from CAR_RENTAL_COMPANY_DISCOUNT_PLAN where DURATION_TYPE = '30일 이상') b

on a.car_type = b.car_type
    
) total
where fee >= 500000 and fee < 2000000
order by fee desc, car_type, car_id desc