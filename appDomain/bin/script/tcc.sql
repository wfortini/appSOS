create database sos24horas;

use sos24horas;

CREATE  TABLE IF NOT EXISTS `tipo_seguro` (
  `id_seguro` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(200) NULL , 
  PRIMARY KEY (`id_seguro`) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `cliente`(
  `id_cliente` INT NOT NULL AUTO_INCREMENT ,
  `name_cliente` VARCHAR(200) not NULL ,
  `CPFCNPJ` VARCHAR(15) not null,
  `dat_cadastro` date not null,
  `dispositivo` VARCHAR(25),
  PRIMARY KEY (`id_cliente`) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `prestador` (
  `id_prestador` INT NOT NULL AUTO_INCREMENT ,
  `name_prestador` VARCHAR(200) not NULL ,
  `CPFCNPJ` VARCHAR(15) not null,
  `dat_cadastro` date not null,
  `funcao` VARCHAR(100),
  PRIMARY KEY (`id_prestador`) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `atendente` (
  `id_atendente` INT NOT NULL AUTO_INCREMENT ,
  `name_atendente` VARCHAR(200) NULL ,
  `dat_cadastro` date not null,
  PRIMARY KEY (`id_atendente`) )
ENGINE = InnoDB;


CREATE  TABLE IF NOT EXISTS `atendimento` (
  `id_atendimento` INT NOT NULL AUTO_INCREMENT ,
  `id_cliente` INT NOT NULL,
  `id_prestador` INT NOT NULL,
  `id_atendente` INT NOT NULL,
  `id_dispositivo` VARCHAR(200) not null,
  `dat_hora_inicio`timestamp not null,
  `dat_hora_fim`timestamp null,
  `local_disponivel` char(1),
  `latitude` BIGINT,
  `longitude` BIGINT, 
  PRIMARY KEY (`id_atendimento`) )
ENGINE = InnoDB;


ALTER TABLE `atendimento`
ADD FOREIGN KEY(`id_cliente`)
REFERENCES `cliente`(`id_cliente`)
ON DELETE RESTRICT
ON UPDATE RESTRICT;

ALTER TABLE `atendimento`
ADD FOREIGN KEY(`id_prestador`)
REFERENCES `prestador`(`id_prestador`)
ON DELETE RESTRICT
ON UPDATE RESTRICT;

ALTER TABLE `atendimento`
ADD FOREIGN KEY(`id_atendente`)
REFERENCES `atendente`(`id_atendente`)
ON DELETE RESTRICT
ON UPDATE RESTRICT;

ALTER TABLE `cliente`
ADD FOREIGN KEY(`id_seguro`)
REFERENCES `tipo_seguro`(`id_seguro`)
ON DELETE RESTRICT
ON UPDATE RESTRICT;

ALTER TABLE Cliente ADD celular varchar(15) not null;
ALTER TABLE Cliente ADD id_seguro int not null;


