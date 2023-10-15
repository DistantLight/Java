
--1 ship.via указывает на id доставщика
SELECT customers.company_name, last_name, first_name
FROM customers
JOIN orders USING(customer_id)
JOIN employees USING(employee_id)
JOIN shippers ON orders.ship_via = shippers.shipper_id
WHERE customers.city = 'London' 
AND employees.city = 'London'
AND shippers.company_name = 'Speedy Express'

--2
SELECT product_name, units_in_stock, contact_name, phone
FROM products
JOIN categories USING(category_id)
JOIN suppliers USING(supplier_id)
WHERE discontinued = 0
AND (category_name = 'Beverages' OR category_name = 'Seafood')
AND units_in_stock < 20
ORDER BY units_in_stock

--3
SELECT contact_name, order_id
FROM customers
LEFT OUTER JOIN orders USING(customer_id)
WHERE order_id IS NULL

--4
SELECT contact_name, order_id
FROM orders
RIGHT OUTER JOIN customers USING(customer_id)
WHERE order_id IS NULL
