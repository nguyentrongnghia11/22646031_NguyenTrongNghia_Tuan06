-- Disable foreign key checks
SET FOREIGN_KEY_CHECKS = 0;

-- Clear existing data
DELETE FROM order_items;
DELETE FROM orders;
ALTER TABLE orders AUTO_INCREMENT = 1;
ALTER TABLE order_items AUTO_INCREMENT = 1;

-- Re-enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

-- Sample Order Data

-- Order 1: User 1 ordering Pizza and Pasta
INSERT INTO orders (user_id, total_price, status) VALUES 
(1, 40.97, 'PENDING');

-- Order Items for Order 1
INSERT INTO order_items (order_id, food_id, quantity, unit_price) VALUES 
(1, 1, 2, 10.99),  -- 2x Pizza
(1, 2, 1, 8.99);   -- 1x Pasta

-- Order 2: User 2 ordering Burger and Salad
INSERT INTO orders (user_id, total_price, status) VALUES 
(2, 32.97, 'PAID');

-- Order Items for Order 2
INSERT INTO order_items (order_id, food_id, quantity, unit_price) VALUES 
(2, 4, 2, 12.99),  -- 2x Burger
(2, 3, 1, 6.99);   -- 1x Salad

-- Order 3: User 3 ordering Tiramisu, Pasta and Salad
INSERT INTO orders (user_id, total_price, status) VALUES 
(3, 27.97, 'SHIPPING');

-- Order Items for Order 3
INSERT INTO order_items (order_id, food_id, quantity, unit_price) VALUES 
(3, 5, 3, 5.99),   -- 3x Tiramisu
(3, 2, 1, 8.99),   -- 1x Pasta
(3, 3, 1, 6.99);   -- 1x Salad
