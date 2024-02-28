-- Desactivar verificación de integridad referencial
SET FOREIGN_KEY_CHECKS = 0;

-- Truncar las tablas
TRUNCATE TABLE clientes;
TRUNCATE TABLE productos;
TRUNCATE TABLE ventas;
TRUNCATE TABLE detalleVentas;

-- Activar verificación de integridad referencial
SET FOREIGN_KEY_CHECKS = 1;

-- Insertar datos en la tabla clientes
INSERT INTO clientes (nombre, apellidos, dni, email, direccion)
VALUES
    ('Juan', 'Perez','12345678','juan@gmail.com', 'Calle 123, Ciudad'),
    ('Maria', 'Gonzalez','87654321', 'maria@gmail.com' ,'Avenida Principal, Pueblo'),
    ('Piero', 'Quezada','45678923', 'piero@gmail.com' ,'Pacifico 2d Etapa');

-- Insertar datos en la tabla productos
INSERT INTO productos (nombre,descripcion, precio, stock)
VALUES
    ('Camisa','Camisa descripción', 20.50, 100),
    ('Pantalón','Pantalón descripción', 30.75, 80),
    ('Zapatos','Zapatos descripcion', 50.25, 50),
    ('Laptop','Laptop descripcion', 100, 50);

-- Insertar datos en la tabla ventas
INSERT INTO ventas (fecha, id_cliente, total)
VALUES
    ('2024-02-25', 1, 75.25),
    ('2024-02-26', 2, 101.50);

-- Insertar datos en la tabla detalleVentas
INSERT INTO detalleVentas (id_venta, id_producto, cantidad, precio, importe)
VALUES
    (1, 1, 2, 20.50, 41.00),
    (1, 3, 1, 50.25, 50.25),
    (2, 2, 3, 30.75, 92.25);
