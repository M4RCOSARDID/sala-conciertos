-- Datos para Grupos Artísticos (Bandas)
INSERT INTO bandas (nombre, genero, numero_integrantes, anio_fundacion, pais, tipo_grupo_artistico) VALUES ('The Beatles', 'Rock', 4, 1960, 'Reino Unido', 'BANDA_MUSICAL');
INSERT INTO bandas (nombre, genero, numero_integrantes, anio_fundacion, pais, tipo_grupo_artistico) VALUES ('Queen', 'Rock', 4, 1970, 'Reino Unido', 'BANDA_MUSICAL');
INSERT INTO bandas (nombre, genero, numero_integrantes, anio_fundacion, pais, tipo_grupo_artistico) VALUES ('Cirque du Soleil', 'Circo', 50, 1984, 'Canadá', 'GRUPO_TEATRAL');
INSERT INTO bandas (nombre, genero, numero_integrantes, anio_fundacion, pais, tipo_grupo_artistico) VALUES ('Orquesta Sinfónica de Londres', 'Clásica', 100, 1904, 'Reino Unido', 'ORQUESTA');
INSERT INTO bandas (nombre, genero, numero_integrantes, anio_fundacion, pais, tipo_grupo_artistico) VALUES ('Les Misérables Cast', 'Musical', 30, 1980, 'Francia', 'GRUPO_TEATRAL');

-- Datos para Eventos
INSERT INTO eventos (nombre, fecha_hora_evento, tipo_evento, precio_taquilla) VALUES ('Leyendas del Rock', '2024-05-15 20:00:00', 'GRAN_CONCIERTO', 75.00);
INSERT INTO eventos (nombre, fecha_hora_evento, tipo_evento, precio_taquilla) VALUES ('Noche de Magia', '2024-06-01 18:00:00', 'TEATRO', 50.00);
INSERT INTO eventos (nombre, fecha_hora_evento, tipo_evento, precio_taquilla) VALUES ('Sinfonía de Verano', '2024-07-20 19:30:00', 'CONCIERTO', 60.00);
INSERT INTO eventos (nombre, fecha_hora_evento, tipo_evento, precio_taquilla) VALUES ('Los Miserables', '2024-08-10 21:00:00', 'MUSICAL', 90.00);

-- Relación Banda - Evento (Tabla Intermedia)
-- Asumiendo IDs secuenciales: 1:Beatles, 2:Queen, 3:Cirque, 4:Orquesta, 5:LesMis
-- 1:Leyendas, 2:NocheMagia, 3:Sinfonia, 4:Miserables

INSERT INTO banda_evento (banda_id, evento_id) VALUES (1, 1); -- Beatles en Leyendas
INSERT INTO banda_evento (banda_id, evento_id) VALUES (2, 1); -- Queen en Leyendas
INSERT INTO banda_evento (banda_id, evento_id) VALUES (3, 2); -- Cirque en Noche Magia
INSERT INTO banda_evento (banda_id, evento_id) VALUES (4, 3); -- Orquesta en Sinfonia
INSERT INTO banda_evento (banda_id, evento_id) VALUES (5, 4); -- Cast en Miserables

-- Datos para Espectadores
INSERT INTO espectadores (dni, nombre, email) VALUES ('12345678A', 'Juan Pérez', 'juan.perez@example.com');
INSERT INTO espectadores (dni, nombre, email) VALUES ('87654321B', 'María García', 'maria.garcia@example.com');
INSERT INTO espectadores (dni, nombre, email) VALUES ('11223344C', 'Carlos López', 'carlos.lopez@example.com');
INSERT INTO espectadores (dni, nombre, email) VALUES ('55667788D', 'Ana Martínez', 'ana.martinez@example.com');

-- Datos para Entradas
-- IDs Eventos: 1, 2, 3, 4
-- IDs Espectadores: 1, 2, 3, 4

-- Juan compra entrada para Leyendas (Pista)
INSERT INTO entradas (zona, fecha_hora_compra, fila, asiento, tipo_entrada, precio_total, validada, espectador_id, evento_id)
VALUES ('PISTA', '2024-01-10 10:00:00', 0, 0, 'GENERAL', 75.00, true, 1, 1);

-- María compra entrada para Leyendas (VIP)
INSERT INTO entradas (zona, fecha_hora_compra, fila, asiento, tipo_entrada, precio_total, validada, espectador_id, evento_id)
VALUES ('ZONA_VIP', '2024-01-12 11:30:00', 1, 5, 'VIP', 150.00, true, 2, 1);

-- Carlos compra entrada para Los Miserables (Media)
INSERT INTO entradas (zona, fecha_hora_compra, fila, asiento, tipo_entrada, precio_total, validada, espectador_id, evento_id)
VALUES ('ZONA_MEDIA', '2024-02-05 15:45:00', 10, 15, 'BENEFACTOR', 100.00, false, 3, 4);

-- Ana compra entrada para Noche de Magia (Baja)
INSERT INTO entradas (zona, fecha_hora_compra, fila, asiento, tipo_entrada, precio_total, validada, espectador_id, evento_id)
VALUES ('ZONA_BAJA', '2024-03-20 09:15:00', 5, 20, 'GENERAL', 50.00, false, 4, 2);
