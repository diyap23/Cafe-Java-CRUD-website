INSERT INTO store (store_name, store_address, store_opening_hours, no_employees, description) VALUES
('Cookfee Downtown', '123 Main Street', 8.50, 5, 'Flagship café in the downtown core.'),
('Cookfee Campus', '456 College Avenue', 7.00, 8, 'Popular student café beside campus.'),
('Cookfee Drive-Thru', '789 Express Lane', 6.00, 4, 'Quick-stop café with drive-thru service.'),
('Cookfee Lounge', '321 Cozy Street', 9.00, 6, 'Chill café with work-friendly atmosphere.');



-- Store 1
INSERT INTO employee (employee_name, shift_date, shift_time, job_title, salary, working_hours, store_id) VALUES
('Alice', '2025-06-01', '08:00:00', 'Barista', 16.50, 6, 1),
('Bob', '2025-06-01', '10:00:00', 'Cashier', 15.00, 5, 1),
('Charlie', '2025-06-02', '12:00:00', 'Server', 14.75, 4, 1),
('Diana', '2025-06-02', '14:00:00', 'Cook', 17.00, 6, 1),
('Eric', '2025-06-03', '16:00:00', 'Supervisor', 19.50, 7, 1),
('Fiona', '2025-06-04', '08:00:00', 'Barista', 16.00, 5, 2),
('George', '2025-06-04', '09:30:00', 'Cashier', 14.50, 4, 2),
('Holly', '2025-06-05', '13:00:00', 'Server', 15.00, 6, 2),
('Ian', '2025-06-05', '15:00:00', 'Manager', 20.00, 8, 2),
('Jenny', '2025-06-06', '17:00:00', 'Cook', 17.25, 6, 2),
('Kyle', '2025-06-01', '06:00:00', 'Barista', 16.25, 5, 3),
('Laura', '2025-06-01', '07:30:00', 'Cashier', 14.75, 4, 3),
('Mark', '2025-06-02', '10:00:00', 'Cook', 17.50, 7, 3),
('Nina', '2025-06-02', '11:30:00', 'Server', 15.00, 4, 3),
('Oscar', '2025-06-03', '13:00:00', 'Manager', 21.00, 8, 3),
('Paula', '2025-06-03', '09:00:00', 'Barista', 15.75, 5, 4),
('Quinn', '2025-06-04', '10:30:00', 'Cook', 16.75, 6, 4),
('Rachel', '2025-06-04', '12:00:00', 'Cashier', 14.25, 5, 4),
('Sam', '2025-06-05', '14:00:00', 'Server', 15.25, 4, 4),
('Tina', '2025-06-06', '16:00:00', 'Manager', 20.50, 7, 4);
