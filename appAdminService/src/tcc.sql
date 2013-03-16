create database sos24horas;

use sos24horas;

CREATE  TABLE IF NOT EXISTS `seguro` (
  `id_seguro` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(200) NULL , 
  PRIMARY KEY (`id_seguro`) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `segurado`(
  `id_segurado` INT NOT NULL AUTO_INCREMENT ,
  `name_cliente` VARCHAR(200) not NULL ,
  `CPFCNPJ` VARCHAR(15) not null,
  `dat_cadastro` date not null,
  `dispositivo` VARCHAR(25),
  `celular`  VARCHAR(12),
  PRIMARY KEY (`id_segurado`) )
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

CREATE  TABLE IF NOT EXISTS `veiculo` (
  `id_veiculo` INT NOT NULL AUTO_INCREMENT ,
  `id_segurado`INT NOT NULL,
  `modelo` VARCHAR(200) not NULL ,
  `marca` varchar(200) null,
  `placa`varchar (12) not null,
  `chassi` varchar(20) null,  
  `dat_cadastro` date not null,
  PRIMARY KEY (`id_veiculo`) )
ENGINE = InnoDB;

CREATE  TABLE IF NOT EXISTS `seguro_segurado` (
  `id_seguro_segurado` INT NOT NULL AUTO_INCREMENT ,
  `id_seguro` INT NOT NULL,
  `id_segurado`INT not null,
  `dat_inicio_vigencia` date not null,
  `dat_fim_vigencia` date null,  
  PRIMARY KEY (`id_seguro_segurado`) )
ENGINE = InnoDB;


CREATE  TABLE IF NOT EXISTS `atendimento` (
  `id_atendimento` INT NOT NULL AUTO_INCREMENT ,
  `id_segurado` INT NOT NULL,
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

CREATE  TABLE IF NOT EXISTS `solicitacao` (
  `id_solicitacao` INT NOT NULL AUTO_INCREMENT ,
  `id_segurado` INT NOT NULL,
  `id_prestador` INT NULL,
  `id_atendente` INT NULL,
  `id_dispositivo` VARCHAR(200) not null,
  `dat_hora_inicio_solic`timestamp not null, 
  `local_disponivel` char(1),
  `latitude` BIGINT,
  `longitude` BIGINT, 
  `dat_hora_inic_atendimento` timestamp,
  PRIMARY KEY (`id_solicitacao`) )
ENGINE = InnoDB;

-- Seguro_segurado

ALTER TABLE `seguro_segurado`
ADD FOREIGN KEY(`id_segurado`)
REFERENCES `segurado`(`id_segurado`)
ON DELETE RESTRICT
ON UPDATE RESTRICT;

ALTER TABLE `seguro_segurado`
ADD FOREIGN KEY(`id_seguro`)
REFERENCES `seguro`(`id_seguro`)
ON DELETE RESTRICT
ON UPDATE RESTRICT;

-- Atendimento

ALTER TABLE `atendimento`
ADD FOREIGN KEY(`id_segurado`)
REFERENCES `segurado`(`id_segurado`)
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

-- solicitação 

ALTER TABLE `solicitacao`
ADD FOREIGN KEY(`id_segurado`)
REFERENCES `segurado`(`id_segurado`)
ON DELETE RESTRICT
ON UPDATE RESTRICT;

ALTER TABLE `solicitacao`
ADD FOREIGN KEY(`id_prestador`)
REFERENCES `prestador`(`id_prestador`)
ON DELETE RESTRICT
ON UPDATE RESTRICT;

ALTER TABLE `solicitacao`
ADD FOREIGN KEY(`id_atendente`)
REFERENCES `atendente`(`id_atendente`)
ON DELETE RESTRICT
ON UPDATE RESTRICT;

-- Veiculo

ALTER TABLE `veiculo`
ADD FOREIGN KEY(`id_segurado`)
REFERENCES `segurado`(`id_segurado`)
ON DELETE RESTRICT
ON UPDATE RESTRICT;

ALTER TABLE `solicitacao`add column `dat_hora_inic_atendimento` timestamp;



