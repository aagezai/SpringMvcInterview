-- run this in mysql
DELIMITER //

CREATE PROCEDURE GetProductsByPriceRange(IN minPrice DOUBLE, IN maxPrice DOUBLE)
BEGIN
    SELECT * FROM Product WHERE price BETWEEN minPrice AND maxPrice;
END //

DELIMITER ;
