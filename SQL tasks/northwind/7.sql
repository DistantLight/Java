
DROP TABLE IF EXISTS exam;

--1
CREATE TABLE exam (
	exam_id serial UNIQUE NOT NULL,
	exam_name varchar(32),
	exam_date date,

);

--2
ALTER TABLE exam
DROP CONSTRAINT exam_exam_id_key

--3
ALTER TABLE exam
ADD PRIMARY KEY (exam_id);

--4
DROP TABLE IF EXISTS person;
CREATE TABLE person(
	person_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	first_name varchar(32),
	last_name varchar(32)
)

--5
CREATE TABLE passport(
	passport_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	serial_number int NOT NULL,
	registration text,
	person_id int REFERENCES person(person_id)
)

--6
DROP TABLE IF EXISTS book;
CREATE TABLE book(
	book_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	book_name varchar(32)
);

ALTER TABLE book
ADD COLUMN weight decimal
CONSTRAINT CHK_book_weight CHECK (weight > 0 AND weight < 100)

--7
INSERT INTO book
(book_name, weight)
values
('замок', 3.2)

INSERT INTO book
(book_name, weight)
values
('процесс', 120)
 
 SELECT *
 FROM book

--8
CREATE TABLE student(
	student_id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	full_name varchar(128),
	course int DEFAULT 1
)

--9
INSERT INTO student
(full_name)
values
('Саня')

SELECT * 
FROM student

--10
ALTER TABLE student
ALTER COLUMN course
DROP DEFAULT

--11
ALTER TABLE products
ADD CONSTRAINT chk_unit_price CHECK (unit_price > 0)

--12
CREATE SEQUENCE IF NOT EXISTS products_product_id_seq
START WITH 78 OWNED BY products.product_id

ALTER TABLE products
ALTER COLUMN poduct_id SET DEFAULT nextval('products_product_id_seq');
