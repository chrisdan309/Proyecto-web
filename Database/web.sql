CREATE DATABASE web;
USE web;

CREATE TABLE usuario (
    id_usuario numeric(9,0) NOT NULL,
    nombre varchar(60) NOT NULL,
    apellido varchar(20) NOT NULL,
    email varchar(20) NOT NULL,
    telefono varchar (9,0) NOT NULL,
    dinero numeric(9,2) NOT NULL,
    pass varchar(20) NOT NULL,
    PRIMARY KEY (id_usuario)
);


CREATE TABLE venta (
    id_venta numeric(9,0) NOT NULL,
    id_producto numeric(9,0) NOT NULL,
    id_usuario numeric(9,0) NOT NULL,
    monto numeric(9,2) NOT NULL,
    PRIMARY KEY (id_venta)
);


CREATE TABLE producto (
    id_producto numeric(9,0) NOT NULL,
    titulo varchar(20) NOT NULL,
    categoria varchar(20) NOT NULL,
    precio numeric(5,2) NOT NULL,
    descuento numeric(5,2) NOT NULL,
    descripcion varchar(200) NOT NULL,
    PRIMARY KEY (id_producto)
);


CREATE TABLE categoria (
    cod_categoria varchar(20) NOT NULL,
    descripcion varchar(100) NOT NULL,
    PRIMARY KEY (cod_categoria)
);


CREATE TABLE categoria_producto (
    cod_categoria varchar(20) NOT NULL,
    id_producto numeric(9,0) NOT NULL,
    PRIMARY KEY (cod_categoria, id_producto)
);
