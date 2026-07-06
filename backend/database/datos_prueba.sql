-- ==========================================
-- DATOS DE PRUEBA INVENTORY SYSTEM
-- ==========================================

-- ==========================================
-- CATEGORIES
-- ==========================================

INSERT INTO categories (name, description) VALUES
('Periféricos', 'Mouse, teclados y accesorios'),
('Computadores', 'PCs y notebooks'),
('Redes', 'Equipos de conectividad'),
('Monitores', 'Pantallas y monitores'),
('Almacenamiento', 'Discos y memorias');

-- ==========================================
-- PRODUCTS
-- ==========================================

INSERT INTO products (
name,
description,
stock,
price,
category_id
)
VALUES
('Mouse Logitech G203', 'Mouse gamer RGB', 50, 19990, 1),
('Teclado Redragon K552', 'Teclado mecánico', 30, 45990, 1),
('Notebook ASUS TUF F15', 'Notebook gaming', 15, 899990, 2),
('Switch TP-Link 8 Puertos', 'Switch Gigabit', 25, 34990, 3),
('Monitor LG 24 IPS', 'Monitor IPS Full HD', 20, 149990, 4),
('SSD Kingston 1TB', 'SSD NVMe', 40, 79990, 5),
('Memoria USB Kingston 64GB', 'USB 3.2', 100, 9990, 5),
('Router TP-Link AX1800', 'Router WiFi 6', 18, 69990, 3);

-- ==========================================
-- CLIENTS
-- ==========================================

INSERT INTO clients (
name,
phone,
email,
address
)
VALUES
('Juan Perez', '+56911111111', '[juan@email.cl](mailto:juan@email.cl)', 'Av. Providencia 100'),
('Pedro Soto', '+56922222222', '[pedro@email.cl](mailto:pedro@email.cl)', 'Av. Apoquindo 500'),
('Maria Gonzalez', '+56933333333', '[maria@email.cl](mailto:maria@email.cl)', 'Av. Libertador 250'),
('Ana Rojas', '+56944444444', '[ana@email.cl](mailto:ana@email.cl)', 'Av. O Higgins 1000'),
('Carlos Diaz', '+56955555555', '[carlos@email.cl](mailto:carlos@email.cl)', 'Av. Matta 300');

-- ==========================================
-- ORDERS
-- ==========================================

INSERT INTO orders (
order_date,
status,
observation,
client_id
)
VALUES
(NOW(), 'PENDING', '', 1),
(NOW(), 'PENDING', '', 2),
(NOW(), 'APPROVED', 'Pedido aprobado', 3),
(NOW(), 'DELIVERED', 'Entregado correctamente', 4),
(NOW(), 'CANCELLED', 'Dirección no válida', 5);

-- ==========================================
-- ORDER DETAILS
-- ==========================================

INSERT INTO order_details (
order_id,
product_id,
quantity,
unit_price
)
VALUES
(1, 1, 2, 19990),
(1, 2, 1, 45990),

(2, 3, 1, 899990),

(3, 4, 3, 34990),
(3, 8, 1, 69990),

(4, 5, 2, 149990),

(5, 6, 1, 79990);

-- ==========================================
-- INVENTORY MOVEMENTS
-- ==========================================

INSERT INTO inventory_movements (
type,
quantity,
movement_date,
status,
product_id
)
VALUES
('ENTRY', 50, NOW(), 'APPROVED', 1),
('ENTRY', 30, NOW(), 'APPROVED', 2),
('ENTRY', 15, NOW(), 'APPROVED', 3),
('ENTRY', 25, NOW(), 'APPROVED', 4),
('ENTRY', 20, NOW(), 'APPROVED', 5),

('EXIT', 2, NOW(), 'DELIVERED', 1),
('EXIT', 1, NOW(), 'PENDING', 3),
('EXIT', 1, NOW(), 'CANCELLED', 6);

-- ==========================================
-- DISPATCHES
-- ==========================================

INSERT INTO dispatches (
dispatch_date,
status,
delivery_address,
delivery_user_id,
operator_user_id,
order_id
)
VALUES
(NOW(), 'PENDING', 'Av. Providencia 100', 3, 2, 1),
(NOW(), 'IN_ROUTE', 'Av. Apoquindo 500', 3, 2, 2),
(NOW(), 'DELIVERED', 'Av. Libertador 250', 3, 2, 3),
(NOW(), 'DELIVERED', 'Av. O Higgins 1000', 3, 2, 4);

-- ==========================================
-- DELIVERIES
-- ==========================================

INSERT INTO deliveries (
delivery_date,
final_status,
observation,
dispatch_id
)
VALUES
(NOW(), 'DELIVERED', 'Recepción conforme', 3),
(NOW(), 'DELIVERED', 'Sin observaciones', 4);
