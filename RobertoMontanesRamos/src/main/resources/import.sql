-- Clientes
INSERT INTO cliente (id, nombre, email, telefono) VALUES (1, 'Juan Pérez', 'juan@example.com', '123456789');
INSERT INTO cliente (id, nombre, email, telefono) VALUES (2, 'María García', 'maria@example.com', '987654321');
INSERT INTO cliente (id, nombre, email, telefono) VALUES (3, 'Carlos López', 'carlos@example.com', '555123456');

ALTER TABLE cliente ALTER COLUMN id RESTART WITH 4;

-- Entradas
INSERT INTO entrada (id, pelicula, fecha_hora, precio, vendida, cliente_id) VALUES (1, 'Avengers: Endgame', '2023-06-15 20:00:00', 9.50, false, null);
INSERT INTO entrada (id, pelicula, fecha_hora, precio, vendida, cliente_id) VALUES (2, 'The Batman', '2023-06-15 22:30:00', 8.75, false, null);
INSERT INTO entrada (id, pelicula, fecha_hora, precio, vendida, cliente_id) VALUES (3, 'Dune', '2023-06-16 18:00:00', 7.50, true, 1);
INSERT INTO entrada (id, pelicula, fecha_hora, precio, vendida, cliente_id) VALUES (4, 'Spider-Man: No Way Home', '2023-06-16 21:00:00', 9.00, true, 2);
INSERT INTO entrada (id, pelicula, fecha_hora, precio, vendida, cliente_id) VALUES (5, 'Top Gun: Maverick', '2023-06-17 19:30:00', 8.50, false, null);


ALTER TABLE entrada ALTER COLUMN id RESTART WITH 6;
