
create or replace function should_increase_salary(
	cur_salary numeric,
	max_salary numeric DEFAULT 80, 
	min_salary numeric DEFAULT 30,
	increase_rate numeric DEFAULT 0.2
	) returns bool AS $$
declare
	new_salary numeric;
begin
	if (min_salary>max_salary) then
		raise exception 'invalid salary: Min is (%), Max is %', min_salary, max_salary;
	elseif (min_salary<0 or max_salary<0) then
		raise exception 'invalid salary < 0: ';
	elseif (increase_rate<0.05) then
		raise exception 'invalid rate : %', increase_rate;
	end if;
	
	if cur_salary >= max_salary or cur_salary >= min_salary then 		
		return false;
	end if;
	
	if cur_salary < min_salary then
		new_salary = cur_salary + (cur_salary * increase_rate);
	end if;
	
	if new_salary > max_salary then
		return false;
	else
		return true;
	end if;	
end;
$$ language plpgsql;

select should_increase_salary(3.1,1.2,2.4,4.2);
select should_increase_salary(3,4,-1,0.3);
