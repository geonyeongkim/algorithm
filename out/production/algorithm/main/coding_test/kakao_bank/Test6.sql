SELECT a.hour, count(1)
FROM (
    SELECT ID, HOUR(CREATED_AT) AS hour
    FROM CARD_USAGES
    WHERE CATEGORY = 0
) a
WHERE a.hour >= 10 AND a.hour <= 15
GROUP BY a.hour
ORDER BY a.hour
;