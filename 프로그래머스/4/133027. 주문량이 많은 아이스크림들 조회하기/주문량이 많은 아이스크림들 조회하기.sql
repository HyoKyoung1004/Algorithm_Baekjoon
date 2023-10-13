select h.flavor
from FIRST_HALF   h join (
SELECT flavor, sum(total_order) as sum_order from july group by flavor) jsum
on h.flavor =jsum.flavor
order by total_order + sum_order desc
limit 3

