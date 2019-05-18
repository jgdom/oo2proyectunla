-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb`;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Zona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Zona` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Zona` (
  `idZona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idZona`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DatosPersonales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`DatosPersonales` ;

CREATE TABLE IF NOT EXISTS `mydb`.`DatosPersonales` (
  `dni` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Inspector`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Inspector` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Inspector` (
  `idInspector` INT NOT NULL AUTO_INCREMENT,
  `cuil` VARCHAR(45) NOT NULL,
  `DatosPersonales_dni` INT NOT NULL,
  PRIMARY KEY (`idInspector`),
  INDEX `fk_Inspector_DatosPersonales1_idx` (`DatosPersonales_dni` ASC),
  CONSTRAINT `fk_Inspector_DatosPersonales1`
    FOREIGN KEY (`DatosPersonales_dni`)
    REFERENCES `mydb`.`DatosPersonales` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tarifa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Tarifa` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Tarifa` (
  `idTarifa` INT NOT NULL AUTO_INCREMENT,
  `tipoTension` VARCHAR(45) NULL,
  PRIMARY KEY (`idTarifa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medidor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Medidor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Medidor` (
  `nroSerie` DOUBLE NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `esBaja` BIT(1) NOT NULL DEFAULT 0,
  `Zona_idZona` INT NOT NULL,
  `Tarifa_idTarifa` INT NOT NULL,
  INDEX `fk_Medidor_Cliente1_idx` (`Cliente_idCliente` ASC),
  UNIQUE INDEX `nroSerie_UNIQUE` (`nroSerie` ASC),
  PRIMARY KEY (`nroSerie`),
  INDEX `fk_Medidor_Zonas1_idx` (`Zona_idZona` ASC),
  INDEX `fk_Medidor_Tarifa1_idx` (`Tarifa_idTarifa` ASC),
  CONSTRAINT `fk_Medidor_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medidor_Zonas1`
    FOREIGN KEY (`Zona_idZona`)
    REFERENCES `mydb`.`Zona` (`idZona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medidor_Tarifa1`
    FOREIGN KEY (`Tarifa_idTarifa`)
    REFERENCES `mydb`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Lectura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Lectura` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Lectura` (
  `idLectura` INT NOT NULL AUTO_INCREMENT,
  `hora` DATE NULL,
  `fecha` DATE NULL,
  `Inspector_idInspector` INT NOT NULL,
  `Medidor_nroSerie` DOUBLE NOT NULL,
  PRIMARY KEY (`idLectura`),
  INDEX `fk_Lectura_Inspector1_idx` (`Inspector_idInspector` ASC),
  INDEX `fk_Lectura_Medidor1_idx` (`Medidor_nroSerie` ASC),
  CONSTRAINT `fk_Lectura_Inspector1`
    FOREIGN KEY (`Inspector_idInspector`)
    REFERENCES `mydb`.`Inspector` (`idInspector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lectura_Medidor1`
    FOREIGN KEY (`Medidor_nroSerie`)
    REFERENCES `mydb`.`Medidor` (`nroSerie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LecturaBajaDemanda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LecturaBajaDemanda` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LecturaBajaDemanda` (
  `energiaConsumida` DOUBLE NOT NULL,
  `Lectura_idLectura` INT NOT NULL,
  INDEX `fk_LecturaBajaDemanda_Lectura1_idx` (`Lectura_idLectura` ASC),
  CONSTRAINT `fk_LecturaBajaDemanda_Lectura1`
    FOREIGN KEY (`Lectura_idLectura`)
    REFERENCES `mydb`.`Lectura` (`idLectura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LecturaAltaDemanda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LecturaAltaDemanda` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LecturaAltaDemanda` (
  `energiaContratada` DOUBLE NULL,
  `tipoTension` VARCHAR(45) NULL,
  `horaPico` DOUBLE NULL,
  `horaValle` DOUBLE NULL,
  `resto` DOUBLE NULL,
  `Lectura_idLectura` INT NOT NULL,
  INDEX `fk_LecturaAltaDemanda_Lectura1_idx` (`Lectura_idLectura` ASC),
  CONSTRAINT `fk_LecturaAltaDemanda_Lectura1`
    FOREIGN KEY (`Lectura_idLectura`)
    REFERENCES `mydb`.`Lectura` (`idLectura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TarifaAltaDemanda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TarifaAltaDemanda` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TarifaAltaDemanda` (
  `Tarifa_idTarifa` INT NOT NULL,
  `horaPico` DOUBLE NOT NULL,
  `horaValle` DOUBLE NOT NULL,
  `resto` DOUBLE NOT NULL,
  `fijo` DOUBLE NOT NULL,
  INDEX `fk_TarifaAltaDemanda_Tarifa1_idx` (`Tarifa_idTarifa` ASC),
  CONSTRAINT `fk_TarifaAltaDemanda_Tarifa1`
    FOREIGN KEY (`Tarifa_idTarifa`)
    REFERENCES `mydb`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TarifaBajaDemanda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TarifaBajaDemanda` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TarifaBajaDemanda` (
  `Tarifa_idTarifa` INT NOT NULL,
  `cargoFijo` DOUBLE NOT NULL,
  `variable` DOUBLE NULL,
  INDEX `fk_TarifaBajaDemanda_Tarifa1_idx` (`Tarifa_idTarifa` ASC),
  CONSTRAINT `fk_TarifaBajaDemanda_Tarifa1`
    FOREIGN KEY (`Tarifa_idTarifa`)
    REFERENCES `mydb`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PersonaFisica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PersonaFisica` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PersonaFisica` (
  `idPersonaFisica` INT NOT NULL AUTO_INCREMENT,
  `Cliente_idCliente` INT NOT NULL,
  `DatosPersonales_dni` INT NOT NULL,
  PRIMARY KEY (`idPersonaFisica`),
  INDEX `fk_PersonaFisica_Cliente1_idx` (`Cliente_idCliente` ASC),
  INDEX `fk_PersonaFisica_DatosPersonales1_idx` (`DatosPersonales_dni` ASC),
  CONSTRAINT `fk_PersonaFisica_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaFisica_DatosPersonales1`
    FOREIGN KEY (`DatosPersonales_dni`)
    REFERENCES `mydb`.`DatosPersonales` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PersonaJuridica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PersonaJuridica` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PersonaJuridica` (
  `idPersonaJuridica` INT NOT NULL AUTO_INCREMENT,
  `cuit` VARCHAR(45) NOT NULL,
  `razonSocial` VARCHAR(45) NOT NULL,
  `Cliente_idCliente` INT NOT NULL,
  INDEX `fk_PersonaJuridica_Cliente1_idx` (`Cliente_idCliente` ASC),
  PRIMARY KEY (`idPersonaJuridica`),
  CONSTRAINT `fk_PersonaJuridica_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Inspector_has_Zona`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Inspector_has_Zona` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Inspector_has_Zona` (
  `Inspector_idInspector` INT NOT NULL,
  `Zona_idZona` INT NOT NULL,
  PRIMARY KEY (`Inspector_idInspector`, `Zona_idZona`),
  INDEX `fk_Inspector_has_Zonas_Zonas1_idx` (`Zona_idZona` ASC),
  INDEX `fk_Inspector_has_Zonas_Inspector1_idx` (`Inspector_idInspector` ASC),
  CONSTRAINT `fk_Inspector_has_Zonas_Inspector1`
    FOREIGN KEY (`Inspector_idInspector`)
    REFERENCES `mydb`.`Inspector` (`idInspector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inspector_has_Zonas_Zonas1`
    FOREIGN KEY (`Zona_idZona`)
    REFERENCES `mydb`.`Zona` (`idZona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
