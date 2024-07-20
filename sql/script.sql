CREATE DATABASE Cuentas_clientes;

USE Cuentas_clientes;

CREATE TABLE ejecutivo (
    rutEjecutivo VARCHAR(12) PRIMARY KEY,
    nombre VARCHAR(100),
    departamento VARCHAR(100)
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreUsuario VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE persona (
    rut VARCHAR(12) PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    direccion VARCHAR(255),
    correo VARCHAR(100),
    telefono VARCHAR(20),
    nombreMascota VARCHAR(100)
);

CREATE TABLE ctaCorriente (
    idCuenta INT AUTO_INCREMENT PRIMARY KEY,
    rutCliente VARCHAR(12),
    monto DECIMAL(10, 2),
    ejecutivo VARCHAR(12),
    FOREIGN KEY (rutCliente) REFERENCES persona(rut),
    FOREIGN KEY (ejecutivo) REFERENCES ejecutivo(rutEjecutivo)
);

CREATE TABLE transaccion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rutCliente VARCHAR(12),
    rutDueño VARCHAR(12),
    idCuenta INT,
    montoTransferencia DECIMAL(10, 2),
    cuentaTransferencia VARCHAR(20),
    tipoCuenta VARCHAR(50),
    FOREIGN KEY (rutCliente) REFERENCES persona(rut),
    FOREIGN KEY (rutDueño) REFERENCES persona(rut),
    FOREIGN KEY (idCuenta) REFERENCES ctaCorriente(idCuenta)
);
