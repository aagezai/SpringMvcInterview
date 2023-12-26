DELIMITER //
CREATE PROCEDURE GetProductsByPriceRange(IN minPrice DECIMAL(10, 2), IN maxPrice DECIMAL(10, 2))
BEGIN
    SELECT * FROM Product
    WHERE price BETWEEN minPrice AND maxPrice;
END //
DELIMITER ;
