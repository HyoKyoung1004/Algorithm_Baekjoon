-- 코드를 입력하세요
SELECT count(*) USERS
from USER_INFO 
# where JOINED like "2021%" and AGE between 20 and 29
WHERE JOINED  BETWEEN '2021-01-01' AND '2021-12-31' and AGE between 20 and 29
