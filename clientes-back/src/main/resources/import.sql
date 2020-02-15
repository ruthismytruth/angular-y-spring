INSERT INTO REGIONES (id, nombre) VALUES (1,'América');
INSERT INTO REGIONES (id, nombre) VALUES (2,'Asia');
INSERT INTO REGIONES (id, nombre) VALUES (3,'Africa');
INSERT INTO REGIONES (id, nombre) VALUES (4,'Antartida');
INSERT INTO REGIONES (id, nombre) VALUES (5,'Oceanía');
INSERT INTO REGIONES (id, nombre) VALUES (6,'Europa');

INSERT INTO CLIENTES (nombre, apellido, email, created_at, region_id) VALUES ('Lauren','Jauregui','lj@gmail.com','2019-11-10',1);
INSERT INTO CLIENTES (nombre, apellido, email, created_at, region_id) VALUES ('Camila','Cabello','cc@gmail.com','2019-11-10',2);
INSERT INTO CLIENTES (nombre, apellido, email, created_at, region_id) VALUES ('Taylor','Swift','ts@gmail.com','2019-11-10',3);
INSERT INTO CLIENTES (nombre, apellido, email, created_at, region_id) VALUES ('Dinah','Jane','dj@gmail.com','2019-11-10',4);
INSERT INTO CLIENTES (nombre, apellido, email, created_at, region_id) VALUES ('Shawn','Mendes','sm@gmail.com','2019-11-10',5);
INSERT INTO CLIENTES (nombre, apellido, email, created_at, region_id) VALUES ('Bella','Hadid','bh@gmail.com','2019-11-10',6);
INSERT INTO CLIENTES (nombre, apellido, email, created_at, region_id) VALUES ('Normani','Kodei','nk@gmail.com','2019-11-10',3);
INSERT INTO CLIENTES (nombre, apellido, email, created_at, region_id) VALUES ('Selena','Gomez','sg@gmail.com','2019-11-10',2);
INSERT INTO CLIENTES (nombre, apellido, email, created_at, region_id) VALUES ('Alba','Reche','ar@gmail.com','2019-11-10',1);
INSERT INTO CLIENTES (nombre, apellido, email, created_at, region_id) VALUES ('Natalia','Lacunza','nl@gmail.com','2019-11-10',3);


INSERT INTO LIBROS (titulo, autor) VALUES ('Diarios','A.Pizarnik');
INSERT INTO LIBROS (titulo, autor) VALUES ('Rayuela','J.Cortázar');
INSERT INTO LIBROS (titulo, autor) VALUES ('Niebla','M.A.Unamuno');
INSERT INTO LIBROS (titulo, autor) VALUES ('La casa de los espíritus','I.allende');
INSERT INTO LIBROS (titulo, autor) VALUES ('Diarios 2','A.Pizarnik');
INSERT INTO LIBROS (titulo, autor) VALUES ('Rayuela 2','J.Cortázar');
INSERT INTO LIBROS (titulo, autor) VALUES ('Niebla 2','M.A.Unamuno');
INSERT INTO LIBROS (titulo, autor) VALUES ('La casa de los espíritus 2','I.allende');
INSERT INTO LIBROS (titulo, autor) VALUES ('Diarios 3','A.Pizarnik');
INSERT INTO LIBROS (titulo, autor) VALUES ('Rayuela 3','J.Cortázar');
INSERT INTO LIBROS (titulo, autor) VALUES ('Niebla 3','M.A.Unamuno');
INSERT INTO LIBROS (titulo, autor) VALUES ('La casa de los espíritus 3','I.allende');

INSERT INTO USUARIOS (username, apellido, password, enabled) VALUES ('ruth', 'sanchez','$2a$10$/ZGtglLaNh6rPd96DT4Y5u3u5kJ0369thhaVjhQ4zYfafqK0TkUqS',1);
INSERT INTO USUARIOS (username, apellido, password, enabled) VALUES ('admin', 'root','$2a$10$RIjm4EtotDaI/bztezQey.Hs7MUeojEEt5/WMs9cGCgzlcStUqiJu',1);

INSERT INTO ROLES (nombre) VALUES ('ROLE_USER'); 
INSERT INTO ROLES (nombre) VALUES ('ROLE_ADMIN');


INSERT INTO USUARIOS_ROLES (usuario_id, rol_id) VALUES (1,1);
INSERT INTO USUARIOS_ROLES (usuario_id, rol_id) VALUES (2,2);
INSERT INTO USUARIOS_ROLES (usuario_id, rol_id) VALUES (2,1);
