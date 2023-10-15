
--1
CREATE TYPE salary_boundaries AS(
	max_salary numeric,
	min_salary numeric
);

DROP FUNCTION get_salary_boundaries_by_city(character varying);
create or replace function get_salary_boundaries_by_city(emp_city varchar) 
RETURNS SETOF salary_boundaries AS $$
	SELECT MIN(salary), MAX(salary)
  	FROM employees
	WHERE city = emp_city
$$ LANGUAGE sql;

SELECT * FROM get_salary_boundaries_by_city('London');

--2
CREATE TYPE title AS ENUM
('Private', 'Corporal', 'Sergeant');

SELECT enum_range(null::title);

ALTER TYPE title
ADD VALUE 'Major' AFTER 'Sergeant';

DROP TABLE IF EXISTS personnel;
CREATE TABLE personnel(
	person_id serial, 
	first_name text, 
	last_name text, 
	person_rank title 
)

INSERT INTO personnel
(first_name, last_name, person_rank)
VALUES
('Serg','Smirnov','Sergeant');

SELECT * FROM personnel;
