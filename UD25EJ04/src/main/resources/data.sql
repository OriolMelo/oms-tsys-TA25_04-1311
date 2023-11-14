DROP TABLE IF EXISTS peliculas;
CREATE TABLE peliculas (
  codigo int NOT NULL,
  nombre varchar(255) NOT NULL,
  calificacionEdad varchar(255) DEFAULT NULL,
  PRIMARY KEY (codigo)
);

DROP TABLE IF EXISTS salas;
CREATE TABLE salas(
  codigo int NOT NULL,
  nombre varchar(255) NOT NULL,
  pelicula int DEFAULT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY (pelicula) REFERENCES peliculas (codigo)
);