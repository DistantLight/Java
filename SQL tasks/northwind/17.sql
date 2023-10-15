
--1
BEGIN ISOLATION LEVEL REPEATABLE READ;

CREATE TABLE customers_with_purchases_less_than_2000 AS
SELECT * 
FROM customers
WHERE customer_id IN (
	SELECT customer_id
	FROM orders
	LEFT JOIN order_details USING (order_id)
	WHERE unit_price * quantity < 2000
);

DELETE FROM order_details
WHERE order_id IN (
	SELECT order_id
	FROM orders
	WHERE customer_id IN (
		SELECT customer_id
		FROM customers_with_purchases_less_than_2000
	)
);

DELETE FROM orders
WHERE customer_id IN (
	SELECT customer_id
	FROM customers_with_purchases_less_than_2000
);

DELETE FROM customers
WHERE customer_id IN (
	SELECT customer_id
	FROM customers_with_purchases_less_than_2000
);

COMMIT;

DROP TABLE IF EXISTS discontinued_products
--2
BEGIN;

CREATE TABLE discontinued_products AS
SELECT * 
FROM products
WHERE discontinued = 1;

SAVEPOINT after_archiving;

DELETE FROM products
WHERE product_id IN (
	SELECT product_id
	FROM discontinued_products
);

ROLLBACK TO after_archiving;

COMMIT;
