
--1
DROP VIEW IF EXISTS orders_customers_employees;
CREATE VIEW orders_customers_employees AS
SELECT order_date, required_date, 
shipped_date, ship_postal_code, 
company_name, contact_name, 
phone, last_name, first_name, title
FROM orders
JOIN customers USING(customer_id)
JOIN employees USING(employee_id);

SELECT *
FROM orders_customers_employees
WHERE order_date > '1997-01-01';

--2
ALTER VIEW orders_customers_employees RENAME TO o_c_e
CREATE OR REPLACE VIEW orders_customers_employees AS
SELECT order_date, required_date, 
shipped_date, ship_postal_code, 
company_name, contact_name, 
phone, last_name, first_name, title,
ship_country,  customers.postal_code, reports_to
FROM orders
JOIN customers USING(customer_id)
JOIN employees USING(employee_id);

SELECT *
FROM orders_customers_employees
ORDER BY ship_country;

DROP VIEW IF EXISTS o_c_e;

--3
CREATE VIEW active_products AS
SELECT *
FROM products
WHERE discontinued = 0
WITH LOCAL CHECK OPTION

