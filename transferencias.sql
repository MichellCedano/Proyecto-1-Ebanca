# TRANSFERENCIAS
DELIMITER !
CREATE PROCEDURE realizaTransferencias(
IN cantidadRetiro FLOAT, IN clienteOrigen INT, IN cuentaDestino INT)
BEGIN
	UPDATE CUENTAS
    SET saldo = saldo - cantidadRetiro
    WHERE codigo = codigoCuenta;
    UPDATE CUENTAS
    SET saldo = saldo + cantidadRetiro
    WHERE codigo = codigoCuentaDestino;
    INSERT INTO transferencias (tipo, cantidad, codigoCuenta, codigoCuentaDestino)
    VALUES ("transferencia", cantidadRetiro, clienteOrigen, cuentaDestino);
    ROLLBACK;
END; !

CALL realizaTransferencias(500, 3, 1)
DROP PROCEDURE realizaTransferencias;
DELIMITER //
CREATE FUNCTION generaContrasena() RETURNS INT 
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
	INTO clave;
    RETURN clave;
END // DELIMITER; 

DELIMITER !
CREATE PROCEDURE retiroSinCuenta(
IN folio INT, IN contrasena INT, IN cantidadRetiro FLOAT, IN codigoCuenta INT)
BEGIN
	IF (contrasena = generaContrasena)
    
	UPDATE cuentas
	SET saldo = saldo - cantidadRetiro
	WHERE codigo = codigoCuenta;