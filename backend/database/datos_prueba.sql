-- Categorías

INSERT INTO categories (name)
VALUES
('Electrónica'),
('Periféricos'),
('Almacenamiento'),
('Componentes');

-- Productos

INSERT INTO products
(name, description, stock, price, category_id)
VALUES
('Notebook Lenovo ThinkPad E14', 'Notebook empresarial', 15, 799990, 1),
('Mouse Logitech G203', 'Mouse gamer RGB', 50, 24990, 2),
('SSD Kingston NV2 1TB', 'Unidad NVMe PCIe 4.0', 30, 89990, 3),
('Memoria RAM Kingston 16GB', 'DDR4 3200MHz', 20, 54990, 4);

-- Movimientos de inventario

INSERT INTO inventory_movements
(type, quantity, movement_date, product_id)
VALUES
('ENTRY', 15, CURRENT_TIMESTAMP, 1),
('ENTRY', 50, CURRENT_TIMESTAMP, 2),
('ENTRY', 30, CURRENT_TIMESTAMP, 3),
('ENTRY', 20, CURRENT_TIMESTAMP, 4),
('EXIT', 2, CURRENT_TIMESTAMP, 1),
('EXIT', 5, CURRENT_TIMESTAMP, 2);

-- Usuarios

INSERT INTO users
(username, password, role)
VALUES
('admin', '$2a$10$ejemploPasswordHash', 'ADMIN'),
('user', '$2a$10$ejemploPasswordHash', 'USER');
