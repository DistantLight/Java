
--1
SELECT employee_id, SUM(quantity * unit_price) AS amount
FROM orders
LEFT JOIN order_details USING(order_id)
GROUP BY ROLLUP (employee_id)
ORDER BY amount DESC

--2
SELECT employee_id, ship_country, SUM(quantity * unit_price) AS amount
FROM orders
LEFT JOIN order_details USING(order_id)
GROUP BY ROLLUP (employee_id, ship_country)
ORDER BY amount DESC

--3
SELECT employee_id, ship_country, SUM(quantity * unit_price) AS amount
FROM orders
LEFT JOIN order_details USING(order_id)
GROUP BY CUBE (employee_id, ship_country)
ORDER BY amount DESC
