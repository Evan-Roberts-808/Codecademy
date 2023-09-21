-- Task 1
SELECT * FROM customers ORDER BY customer_id;
SELECT * FROM customers_log;

-- Task 2
CREATE TRIGGER log_customers_change
  BEFORE UPDATE ON customers
  FOR EACH ROW
  EXECUTE PROCEDURE log_customers_change();

-- Task 3
UPDATE customers
SET first_name = 'Franklin'
WHERE last_name = 'Lewis';

SELECT * FROM customers ORDER BY customer_id;

SELECT * FROM customers_log;

-- Task 4
UPDATE customers
SET home_phone = 123-456-7891
WHERE last_name = 'Lewis';

SELECT * FROM customers ORDER BY customer_id;

SELECT * FROM customers_log;

-- Task 5
CREATE TRIGGER customer_insert
  AFTER INSERT ON customers
  FOR EACH STATEMENT
  EXECUTE PROCEDURE log_customers_change();

-- Task 6
INSERT INTO customers (first_name, last_name, email_address, home_phone, city,state_name, years_old)
VALUES
  ('Freddy', 'Two-Time', 'freddytwotime@email.com', 987-789-7894, 'City', 'State', 42),
  ('tony', 'toughmen', 'tonytoughmen@email.com', 987-748-5649, 'City', 'State', 62),
  ('billy', 'bustermen', 'billybustermen@email.com', 342-359-1245, 'City', 'State', 16);

SELECT * FROM customers ORDER BY customer_id;
SELECT * FROM customers_log;

-- Task 7
CREATE TRIGGER customer_min_age
  BEFORE UPDATE ON customers
  FOR EACH ROW
  WHEN (NEW.years_old < 13)
  EXECUTE PROCEDURE override_with_min_age(); 

-- Task 8
UPDATE customers
SET years_old = 10
WHERE last_name = 'Two-Time';

UPDATE customers
SET years_old = 57
WHERE last_name = 'bustermen';

SELECT * FROM customers ORDER BY customer_id;
SELECT * FROM customers_log;

-- Task 9
UPDATE customers
SET years_old = 19,
    first_name = 'Bobby'
WHERE last_name = 'bustermen';

SELECT * FROM customers ORDER BY customer_id;
SELECT * FROM customers_log;

-- Task 10
DROP TRIGGER IF EXISTS customer_min_age ON customers;

-- Task 11
SELECT * FROM information_schema.triggers;