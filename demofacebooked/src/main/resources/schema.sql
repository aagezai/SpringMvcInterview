DROP TABLE IF EXISTS Product;
-- Create Table
CREATE TABLE Product (
    product_id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity_in_stock INT
);

-- Add Column
ALTER TABLE  Product
ADD COLUMN  manufacture VARCHAR(255);

-- Modify Column
ALTER TABLE  Product
MODIFY COLUMN  quantity_in_stock INT NOT NULL;
-- view creation
-- Drop view if it exists
DROP VIEW IF EXISTS ProductView;

-- Create or replace the view
CREATE OR REPLACE VIEW ProductView AS
SELECT product_id, name, price
FROM Product;


