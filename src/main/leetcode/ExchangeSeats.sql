SELECT 
    a.id, IFNULL(b.student, a.student) as student
FROM seat a
LEFT OUTER JOIN (
    SELECT 
        CASE
            WHEN id % 2 = 1 THEN id + 1
            ELSE id - 1
        END AS id,
        student
    FROM seat
) b ON (a.id=b.id)
ORDER BY a.id
;
