# select h.flavor
# from FIRST_HALF   h join (
# SELECT flavor, sum(total_order) as sum_order from july group by flavor) jsum
# on h.flavor =jsum.flavor
# order by total_order + sum_order desc
# limit 3

# SELECT a.FLAVOR
# FROM FIRST_HALF a JOIN JULY b
# ON a.FLAVOR = b.FLAVOR
# GROUP BY FLAVOR
# ORDER BY SUM(a.TOTAL_ORDER + b.TOTAL_ORDER) DESC
# LIMIT 3

SELECT a.FLAVOR
FROM FIRST_HALF a JOIN JULY b
ON a.FLAVOR = b.FLAVOR
GROUP BY a.FLAVOR
order by a.TOTAL_ORDER+ sum(b.TOTAL_ORDER) desc
limit 3