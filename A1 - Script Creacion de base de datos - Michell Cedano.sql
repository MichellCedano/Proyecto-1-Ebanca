#1 BASE DE DATOS
CREATE DATABASE e_banca;
USE e_banca;

#DIRECCIONES
	CREATE TABLE direcciones(
	codigo int AUTO_INCREMENT PRIMARY KEY,
	calle VARCHAR(50) NOT NULL,
	colonia VARCHAR(50) NOT NULL,
	numeroCasa VARCHAR(50) NOT NULL
	);

#CLIENTES
	CREATE TABLE clientes (
	codigo INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
    apellidoPaterno VARCHAR(30) NOT NULL,
    apellidoMaterno VARCHAR(30) NOT NULL,
    codigoDireccion INT NOT NULL,
    fechaNacimiento DATE NOT NULL,
    edad INT,
	FOREIGN KEY (codigoDireccion) REFERENCES direcciones(codigo)
	);


#CUENTAS
	CREATE TABLE cuentas (
	codigo INT AUTO_INCREMENT PRIMARY KEY,
	estado ENUM('activo','cancelada') NOT NULL,
    fechaApertura DATE NOT NULL DEFAULT(current_date()),
    saldo INT NOT NULL,
	codigoCliente INT NOT NULL,
    FOREIGN KEY (codigoCliente) REFERENCES clientes(codigo)
	);

#TRANSFERENCIAS
	CREATE TABLE tranferencias (
	codigo INT  AUTO_INCREMENT PRIMARY KEY,
    fechaTransferencia DATE NOT NULL DEFAULT(current_date()),
    tipo ENUM('retiro sin cuenta','transferencia') NOT NULL,
    cantidad INT NOT NULL,
    codigoCuenta INT NOT NULL,
    codigoCuentaDestino INT NOT NULL,
	FOREIGN KEY (codigoCuenta) REFERENCES cuentas(codigo),
    FOREIGN KEY (codigoCuentaDestino) REFERENCES cuentas(codigo)
	);

#RETIROS
	CREATE TABLE retiros (
	folio INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL,
    contraseña INT NOT NULL,
    codigoCuentaDestino INT NOT NULL,
    fechaRetiro DATE NOT NULL DEFAULT(current_date()),
    estado ENUM('cancelado','retirado'),
    FOREIGN KEY (codigoCuentaDestino) REFERENCES cuentas(codigo)
	);
