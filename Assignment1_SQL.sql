-- 1. Find duplicate records

SELECT email, COUNT(*) AS duplicate_count
FROM users
GROUP BY email
HAVING COUNT(*) > 1;


-- 2. Find the last inserted row

SELECT *
FROM users
ORDER BY id DESC
LIMIT 1;


-- 3. Join two tables

SELECT
    u.id,
    u.name,
    o.id AS order_id,
    o.amount
FROM users u
INNER JOIN orders o
    ON u.id = o.user_id;