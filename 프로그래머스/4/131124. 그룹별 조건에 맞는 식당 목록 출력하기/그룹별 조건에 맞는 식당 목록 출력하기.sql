-- 테이블에서 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 SQL문을 작성해주세요.
-- 회원이름, 리뷰텍스트, 리뷰작성일 출력,
-- 리뷰작성일 오름차순, 리뷰텍스트 오름차순


-- 가장 리뷰를 많이 작성한 사람
select MEMBER_NAME, REVIEW_TEXT,  DATE_FORMAT(REVIEW_DATE,'%Y-%m-%d') DATE_FORMAT
from MEMBER_PROFILE m join REST_REVIEW r on m.member_id = r.member_id
where m.member_id in
(select member_id from rest_review
group by member_id
having count(member_id) = (
select count(MEMBER_ID) r
from REST_REVIEW 
group by MEMBER_ID
order by r desc
limit 1))
order by REVIEW_DATE, REVIEW_TEXT