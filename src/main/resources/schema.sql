CREATE DATABASE IF NOT EXISTS mi_base_datos;

CREATE TABLE IF NOT EXISTS clientes(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20),
    apellidos VARCHAR(40),
    email VARCHAR(30),
    dni VARCHAR(8),
    direccion TEXT
);

CREATE TABLE IF NOT EXISTS ventas(
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE,
    id_cliente INT,
    total DOUBLE,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

CREATE TABLE IF NOT EXISTS productos(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    descripcion text,
    precio DOUBLE,
    stock int
);

CREATE TABLE IF NOT EXISTS detalleVentas(
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_venta INT,
    id_producto INT,
    cantidad INT,
    precio DOUBLE,
    importe DOUBLE,
    FOREIGN KEY (id_venta) REFERENCES ventas(id),
    FOREIGN KEY (id_producto) REFERENCES productos(id)
);