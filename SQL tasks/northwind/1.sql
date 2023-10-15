
SELECT * --1
FROM customers;

--2
SELECT contact_name, city
FROM customers;

--3
SELECT order_id, shipped_date-order_date AS difference
FROM orders;

--4
SELECT DISTINCT city
FROM customers;

--5
SELECT DISTINCT country, city
FROM customers;

--6
SELECT COUNT(*)
FROM customers;

--7
SELECT COUNT(DISTINCT country)
FROM customers;
