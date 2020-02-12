DROP TABLE IF EXISTS rate_details;

CREATE TABLE rate_details (
  id INT AUTO_INCREMENT PRIMARY KEY,
  success VARCHAR(50),
  base varchar(50),
  request_date varchar(50),
  request_timestamp varchar(50),
  updated_on varchar(50)
);
