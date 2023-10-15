
--1
SELECT product_name, units_in_stock
FROM products
WHERE units_in_stock < ALL (
	SELECT AVG(quantity)
	FROM order_details
	GROUP BY product_id 
);



--2
SELECT customer_id, SUM(freight) AS freight_sum
FROM orders
JOIN customers USING (customer_id)
WHERE freight >= ALL(
	SELECT AVG(freight)
	FROM orders					
)
AND shipped_date >= '1996-07-15'
AND shipped_date <= '1996-07-31'
GROUP BY customer_id
ORDER BY freight_sum;

--3
SELECT customer_id, ship_country, order_price
FROM orders
JOIN (SELECT order_id, 
	SUM(unit_price*quantity*(1-discount)) AS order_price
	FROM order_details
	GROUP BY order_id
) AS od
USING(order_id)
WHERE order_date >= '1997-09-01'
ORDER BY order_price DESC
LIMIT 3



--4
SELECT product_name
FROM products
WHERE product_id = ANY(
	SELECT product_id
	FROM order_details
	WHERE quantity = 10
)
