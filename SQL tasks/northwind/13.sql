

DROP FUNCTION IF EXISTS numbers_filter(text[]);
CREATE OR REPLACE FUNCTION numbers_filter 
(operator_code int,VARIADIC numbers text[])
RETURNS SETOF text AS $$
DECLARE
	cur_val text;
BEGIN
	FOREACH cur_val IN ARRAY numbers
	LOOP
		IF (cur_val LIKE '___' || operator_code || '%' ) THEN
			RETURN NEXT cur_val;
		END IF;
	END LOOP;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM numbers_filter(903, '+7(903)1901235', '+7(926)8567589', '+7(903)1532476');
SELECT * FROM numbers_filter(903, VARIADIC ARRAY['+7(903)1901235', '+7(926)8567589', '+7(903)1532476']);
