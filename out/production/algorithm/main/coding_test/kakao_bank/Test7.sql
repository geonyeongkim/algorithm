SELECT a.cnt, count(1)
FROM (
    SELECT HOST_ID, count(1) as cnt
    FROM PLACES
    GROUP BY HOST_ID
) a
GROUP BY a.cnt
ORDER BY a.cnt DESC
;