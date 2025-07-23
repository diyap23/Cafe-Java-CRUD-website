CREATE TABLE store (
    id INT AUTO_INCREMENT PRIMARY KEY,
    store_name VARCHAR(100),
    store_address VARCHAR(100),
    store_opening_hours DOUBLE,
    no_employees INT,
    description VARCHAR(300)
);

CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(100),
    shift_date DATE,
    shift_time TIME,
    job_title VARCHAR(100),
    salary DOUBLE,
    working_hours INT,
    store_id INT,
    CONSTRAINT store_fk FOREIGN KEY (store_id) REFERENCES store(id) 
);
