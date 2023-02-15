# FUNCIONES
DELIMITER //
CREATE FUNCTION generaContraseña() RETURNS VARCHAR(8) CHARSET utf8
BEGIN
    declare alfa varchar(10) default '1234567890';
    declare clave varchar(8) default '';
    
    set clave=concat(
                SUBSTRING(alfa,rand()*8,1),
                        SUBSTRING(alfa,rand()*8,1),
                        SUBSTRING(alfa,rand()*8,1),
                        SUBSTRING(alfa,rand()*8,1),
                        SUBSTRING(alfa,rand()*8,1),
                        SUBSTRING(alfa,rand()*8,1),
                        SUBSTRING(alfa,rand()*8,1),
                        SUBSTRING(alfa,rand()*8,1)
                    );
    RETURN clave;
END
// DELIMITER

DELIMITER //
CREATE FUNCTION generaContraseña() RETURNS int(8)
BEGIN

declare clave int;
SELECT CONCAT(
FLOOR(0 + RAND()*(9 - 5 + 1)), 
FLOOR(0 + RAND()*(9 - 5 + 1)),
FLOOR(0 + RAND()*(9 - 5 + 1)),
FLOOR(0 + RAND()*(9 - 5 + 1)), 
FLOOR(0 + RAND()*(9 - 5 + 1)), 
FLOOR(0 + RAND()*(9 - 5 + 1)),
FLOOR(0 + RAND()*(9 - 5 + 1)),
FLOOR(0 + RAND()*(9 - 5 + 1))) 
into clave;
return clave;
end // delimiter;