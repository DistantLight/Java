
--1
insert into customers(customer_id, contact_name, city, country, company_name)
values 
('AAAAA', 'Alfred Mann', NULL, 'USA', 'fake_company'),
('BBBBB', 'Alfred Mann', NULL, 'Austria','fake_company');

SELECT contact_name, city, country
FROM customers
ORDER BY contact_name,
(
	CASE
		WHEN city IS NULL THEN country
		ELSE city
	END
);

--2
SELECT product_name, unit_price,
	CASE
		WHEN unit_price >= 100 THEN 'too expensive'
		WHEN unit_price BETWEEN 50 AND 99 THEN 'average'
		ELSE 'low'
	END as price_estimation
FROM products
	
--3
SELECT contact_name, COALESCE(order_id::text, 'no order')
FROM customers
LEFT JOIN orders USING (customer_id)
WHERE order_id IS NULL

--4
SELECT CONCAT(last_name, first_name) AS name, 
COALESCE(NULLIF(title, 'Sales Representative'),'Sales Stuff') AS title
FROM employees
