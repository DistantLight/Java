
--1
CREATE OR REPLACE FUNCTION
back_up_for_customers() RETURNS void AS $$
	DROP TABLE IF EXISTS back_up_for_customers;
	
	CREATE TABLE back_up_for_customers AS
	SELECT * FROM customers;
$$ LANGUAGE SQL;

SELECT back_up_for_customers();
SELECT * FROM back_up_for_customers;

--2
CREATE OR REPLACE FUNCTION
get_average_orders_freigt() RETURNS double precision AS $$
	SELECT AVG(freight)
	FROM orders
$$ LANGUAGE SQL

SELECT get_average_orders_freigt();

--3
DROP FUNCTION IF EXISTS get_random_number(integer,integer);
CREATE OR REPLACE FUNCTION
get_random_number(IN min_value int, IN max_value int) RETURNS double precision AS $$
	SELECT floor(random() * (max_value - min_value +1 )) + min_value
$$ LANGUAGE SQL;

SELECT get_random_number(1,10)

--4
DROP FUNCTION IF EXISTS get_max_and_min_employees_salary_by_city();
CREATE OR REPLACE FUNCTION
get_max_and_min_employees_salary_by_city(OUT min_value numeric, 
										 OUT max_value numeric, 
										 IN transmitted_city varchar) AS $$
	SELECT  MAX(salary), MIN(salary)
	FROM employees
	WHERE city = transmitted_city
$$ LANGUAGE SQL;

SELECT * FROM get_max_and_min_employees_salary_by_city('London');

--5
DROP FUNCTION IF EXISTS correct_salary(numeric,numeric);
CREATE OR REPLACE FUNCTION
correct_salary(IN salary_lvl numeric DEFAULT 70, 
			   IN salary_procent numeric DEFAULT 15)
			   RETURNS void AS $$
	UPDATE employees
	SET salary = salary * (1 + salary_procent)
	WHERE salary <= salary_lvl
$$ LANGUAGE SQL;

SELECT correct_salary();

--6 v1
DROP FUNCTION correct_salary(numeric,numeric);
CREATE OR REPLACE FUNCTION
correct_salary(IN salary_lvl numeric DEFAULT 70, 
			   IN salary_procent numeric DEFAULT 15)
			   RETURNS SETOF employees AS $$
DECLARE
	employee record;
BEGIN
	FOR employee IN SELECT * FROM employees
	LOOP
		IF employee.salary > salary_lvl THEN
			employee.salary = employee.salary * (1 + salary_procent);
			RETURN NEXT employee;
		END IF;
	END LOOP;
END
$$ LANGUAGE PLPGSQL;

SELECT * FROM correct_salary();

--6 v2
DROP FUNCTION IF EXISTS correct_salary(numeric,numeric);
CREATE OR REPLACE FUNCTION
correct_salary(IN salary_lvl numeric DEFAULT 10000, 
			   IN salary_procent numeric DEFAULT 15)
RETURNS SETOF employees AS $$
	UPDATE employees
	SET salary = salary * (1 + salary_procent)
	WHERE salary <= salary_lvl
	RETURNING *;
$$ LANGUAGE SQL;

SELECT * FROM correct_salary();


--7 
DROP FUNCTION IF EXISTS correct_salary(numeric,numeric);
CREATE OR REPLACE FUNCTION
correct_salary(IN salary_lvl numeric DEFAULT 1000000, 
			   IN salary_procent numeric DEFAULT 15)
RETURNS TABLE (last_name text, first_name text, title text, salary numeric) AS $$
	UPDATE employees
	SET salary = salary * (1 + salary_procent)
	WHERE salary <= salary_lvl
	RETURNING last_name, first_name, title, salary;
$$ LANGUAGE SQL;

SELECT * FROM correct_salary();

--8
DROP FUNCTION IF EXISTS get_orders_by_shipping(integer);
CREATE OR REPLACE FUNCTION
get_orders_by_shipping(IN delivery_method int) 
RETURNS SETOF orders AS $$
DECLARE
	max_val real;
	avg_val real;
	res real;
BEGIN
	SELECT MAX(freight)
	INTO max_val
	FROM orders
	WHERE ship_via = delivery_method;
	
	max_val = max_val * 0.7;
	
	SELECT AVG(freight)
	INTO avg_val
	FROM orders
	WHERE ship_via = delivery_method;	
	
	res = (max_val + avg_val) / 2;
	
	RETURN QUERY
	SELECT *
	FROM orders
	WHERE freight < res;		
END
$$ LANGUAGE PLPGSQL;

SELECT COUNT(*) FROM get_orders_by_shipping(1); 

--9

CREATE OR REPLACE FUNCTION
salary_check(IN salary_lvl numeric,
			 IN max_salary numeric DEFAULT 80,
			 IN min_salary numeric DEFAULT 30,
			 IN growth_rate numeric DEFAULT 0.2) 
RETURNS bool AS $$
BEGIN
	IF salary_lvl > min_salary THEN
		RETURN false;
	ELSEIF salary_lvl < min_salary THEN
		salary_lvl = salary_lvl * (1 + growth_rate);
	END IF;
	
	IF salary_lvl > max_salary THEN
		RETURN false;
	ELSE
		RETURN true;
	END IF;
END;
$$ LANGUAGE PLPGSQL;

SELECT salary_check(40,80,30,0.2);
SELECT salary_check(79,81,80,0.2);
SELECT salary_check(79,95,80,0.2);
