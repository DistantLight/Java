
DROP FUNCTION IF EXISTS get_avg_freight_by_country(text[]);
CREATE OR REPLACE FUNCTION get_avg_freight_by_country 
(VARIADIC countries text[], out country text, out avg_freiht float8)
RETURNS SETOF record AS $$
	SELECT ship_country, AVG(freight)
	FROM orders
	WHERE ship_country = ANY(countries)
	GROUP BY ship_country;
$$ LANGUAGE SQL;

SELECT * FROM get_avg_freight_by_country('Brazil', 'Germany');
SELECT * FROM get_avg_freight_by_country(VARIADIC ARRAY['Brazil', 'Germany']);
