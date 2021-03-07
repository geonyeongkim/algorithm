-- 같은 노선 버스간의 range를 테이블 만듬
WITH buses_with_range AS (
    SELECT
        b.id,
        b.origin,
        b.destination,
        replace(b.time, ':', '') AS time,
        COALESCE(
            (SELECT replace(a.time, ':', '')
                FROM buses a
                WHERE b.origin = a.origin AND b.destination = a.destination AND b.time > a.time
                ORDER BY a.time desc
                LIMIT 1), '0000') AS passenger_wait_time
    FROM buses b
)
SELECT bwr.id, count(p.id)
FROM buses_with_range bwr
LEFT OUTER JOIN passengers p ON (bwr.origin=p.origin AND bwr.destination=p.destination AND bwr.passenger_wait_time < replace(p.time, ':', '') AND bwr.time >= replace(p.time, ':', ''))
GROUP BY bwr.id
ORDER BY bwr.id
;