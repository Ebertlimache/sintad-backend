-- Eliminar tablas si existen
DROP TABLE IF EXISTS tb_entidad;
DROP TABLE IF EXISTS tb_tipo_contribuyente;
DROP TABLE IF EXISTS tb_tipo_documento;

-- Crear tabla tb_tipo_contribuyente
CREATE TABLE tb_tipo_contribuyente (
  id_tipo_contribuyente INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  estado BOOLEAN NOT NULL
);

-- Insertar en tb_tipo_contribuyente
INSERT INTO tb_tipo_contribuyente (nombre, estado) VALUES
  ('Natural Sin Negocio', TRUE),
  ('Juridica', TRUE),
  ('Natural Con Negocio', TRUE),
  ('No Domiciliado', TRUE);

-- Crear tabla tb_tipo_documento
CREATE TABLE tb_tipo_documento (
  id_tipo_documento INT AUTO_INCREMENT PRIMARY KEY,
  codigo VARCHAR(20) NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  descripcion VARCHAR(200),
  estado BOOLEAN NOT NULL DEFAULT TRUE
);

-- Insertar en tb_tipo_documento
INSERT INTO tb_tipo_documento (codigo, nombre, descripcion, estado) VALUES
  ('4', 'CARNET DE EXTRANJERIA', 'CARNET DE EXTRANJERIA', TRUE),
  ('7', 'PASAPORTE', 'PASAPORTE', TRUE),
  ('11', 'PARTIDA DE NACIMIENTO - IDENTIDAD', 'PARTIDA DE NACIMIENTO - IDENTIDAD', TRUE),
  ('99', 'OTROS', 'OTROS', TRUE),
  ('6', 'RUC', 'REGISTRO UNICO DEL CONTRIBUYENTE', TRUE),
  ('1', 'DNI', 'DOCUMENTO NACIONAL DE IDENTIDAD', TRUE);

-- Crear tabla tb_entidad
CREATE TABLE tb_entidad (
    id_entidad INT AUTO_INCREMENT PRIMARY KEY,
    id_tipo_documento INT NOT NULL,
    nro_documento VARCHAR(25) NOT NULL UNIQUE,
    razon_social VARCHAR(100) NOT NULL,
    nombre_comercial VARCHAR(100),
    id_tipo_contribuyente INT,
    direccion VARCHAR(250),
    telefono VARCHAR(50),
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_tb_entidad_tb_tipo_documento FOREIGN KEY (id_tipo_documento) 
	REFERENCES tb_tipo_documento(id_tipo_documento) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT fk_tb_entidad_tb_tipo_contribuyente FOREIGN KEY (id_tipo_contribuyente) 
	REFERENCES tb_tipo_contribuyente(id_tipo_contribuyente) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Insertar en tb_entidad
INSERT INTO tb_entidad (id_tipo_documento, nro_documento, razon_social, nombre_comercial, id_tipo_contribuyente, direccion, telefono, estado) VALUES
  (3, '20505327552', 'SYL S.A.C', 'SYL CARGO NOMBRE COMERCIAL', 1, 'Jr. Comandante Jimenez Nro. 166 Int. a (entre Cuadra 7 y 8 Javier Padro Oeste)', '79845612', TRUE),
  (3, '20543844838', 'PUNTUAL EXPRESS S.A.C.', NULL, 1, 'MZA. F LOTE. 29 AS.RSD.MONTECARLO II LIMA - LIMA - SAN MARTIN DE PORRE', NULL, TRUE),
  (3, '10410192999', 'ALVAREZ MACHUCA RENZO GUSTAVO', NULL, 3, 'AV. LOS ALISOS MZA. G LOTE. 05 ASC. LA ALBORADA DE OQUENDO III ETAPA (CRUCE PTE OQUENDO CON AV.NESTOR GAMBETTA) PROV. CONST. DEL CALLAO - PROV. CONST. DEL CALLAO - CALLAO', NULL, TRUE),
  (3, '20600131037', 'CARNICOS MAFER S.A.C.', NULL, 2, 'CAL.EL UNIVERSO NRO. 327 URB. LA CAMPIÑA ZONA CINCO (ALTURA ', NULL, TRUE),
  (3, '20556528218', 'SUMAQUINARIA S.A.C.', NULL, 2, 'AV. M.SUCRE NRO. 455 DPTO. 603 LIMA - LIMA - MAGDALENA DEL MAR', NULL, TRUE),
  (3, '20545412528', 'OASIS FOODS S.A.C.', NULL, 2, 'CAL. FRANCISCO MASIAS NRO. 370 URB. SAN EUGENIO (PISO 7) LIM', NULL, TRUE),
  (3, '20510620195', 'INVERSIONES PRO3 SAC', NULL, 2, 'AV. AUTOPIDTA RAMIRO PRIALE LOTE. 02 A.V. PROP HUERTOS DE HU', NULL, TRUE),
  (3, '20498383361', 'REPUESTOS DAVID DIESEL E.I.R.L.', NULL, 2, 'CAR.VIA EVITAMIENTO MZA. 857 LOTE. 7 SEC. IRRIGACION EL CURAL 1 AREQUIPA - AREQUIPA - CERRO COLORADO', NULL, TRUE),
  (6, 'CNAH00003', 'ANHUI HAYVO PROTECTIVE PRODUCT MANUFACTURING CO.,LTD', NULL, 4, '173 FENGLE AVENUE,ECNOMIC DEVELOPMENT ZONE,QUANJIAO COUNTY', NULL, TRUE);