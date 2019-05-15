-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`inspector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`inspector` (
  `idInspector` INT(11) NOT NULL AUTO_INCREMENT,
  `cuil` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idInspector`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`datospersonales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`datospersonales` (
  `idDatosPersonales` INT(11) NOT NULL,
  `dni` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDatosPersonales`),
  INDEX `fk_datospersonales_inspector1_idx` (`idDatosPersonales` ASC) VISIBLE,
  CONSTRAINT `fk_datospersonales_inspector1`
    FOREIGN KEY (`idDatosPersonales`)
    REFERENCES `mydb`.`inspector` (`idInspector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`zona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`zona` (
  `idZona` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idZona`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`inspector_has_zona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`inspector_has_zona` (
  `idInspector` INT(11) NOT NULL,
  `idZona` INT(11) NOT NULL,
  PRIMARY KEY (`idInspector`, `idZona`),
  INDEX `fk_Inspector_has_Zonas_Zonas1_idx` (`idZona` ASC) VISIBLE,
  INDEX `fk_Inspector_has_Zonas_Inspector1_idx` (`idInspector` ASC) VISIBLE,
  CONSTRAINT `fk_Inspector_has_Zonas_Inspector1`
    FOREIGN KEY (`idInspector`)
    REFERENCES `mydb`.`inspector` (`idInspector`),
  CONSTRAINT `fk_Inspector_has_Zonas_Zonas1`
    FOREIGN KEY (`idZona`)
    REFERENCES `mydb`.`zona` (`idZona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`tarifa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tarifa` (
  `idTarifa` INT(11) NOT NULL AUTO_INCREMENT,
  `tipoTension` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idTarifa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`medidor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`medidor` (
  `nroSerie` INT(11) NOT NULL AUTO_INCREMENT,
  `Cliente_idCliente` INT(11) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `esBaja` BIT(1) NOT NULL DEFAULT b'0',
  `Zona_idZona` INT(11) NOT NULL,
  `Tarifa_idTarifa` INT(11) NOT NULL,
  PRIMARY KEY (`nroSerie`),
  UNIQUE INDEX `nroSerie_UNIQUE` (`nroSerie` ASC) VISIBLE,
  INDEX `fk_Medidor_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_Medidor_Zonas1_idx` (`Zona_idZona` ASC) VISIBLE,
  INDEX `fk_Medidor_Tarifa1_idx` (`Tarifa_idTarifa` ASC) VISIBLE,
  CONSTRAINT `fk_Medidor_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`cliente` (`idCliente`),
  CONSTRAINT `fk_Medidor_Tarifa1`
    FOREIGN KEY (`Tarifa_idTarifa`)
    REFERENCES `mydb`.`tarifa` (`idTarifa`),
  CONSTRAINT `fk_Medidor_Zonas1`
    FOREIGN KEY (`Zona_idZona`)
    REFERENCES `mydb`.`zona` (`idZona`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`lectura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`lectura` (
  `idLectura` INT(11) NOT NULL AUTO_INCREMENT,
  `hora` DATE NULL DEFAULT NULL,
  `fecha` DATE NULL DEFAULT NULL,
  `Inspector_idInspector` INT(11) NOT NULL,
  `Medidor_nroSerie` INT(11) NOT NULL,
  PRIMARY KEY (`idLectura`),
  INDEX `fk_Lectura_Inspector1_idx` (`Inspector_idInspector` ASC) VISIBLE,
  INDEX `fk_Lectura_Medidor1_idx` (`Medidor_nroSerie` ASC) VISIBLE,
  CONSTRAINT `fk_Lectura_Inspector1`
    FOREIGN KEY (`Inspector_idInspector`)
    REFERENCES `mydb`.`inspector` (`idInspector`),
  CONSTRAINT `fk_Lectura_Medidor1`
    FOREIGN KEY (`Medidor_nroSerie`)
    REFERENCES `mydb`.`medidor` (`nroSerie`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`lecturaaltademanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`lecturaaltademanda` (
  `energiaContratada` DOUBLE NULL DEFAULT NULL,
  `tipoTension` VARCHAR(45) NULL DEFAULT NULL,
  `horaPico` DOUBLE NULL DEFAULT NULL,
  `horaValle` DOUBLE NULL DEFAULT NULL,
  `resto` DOUBLE NULL DEFAULT NULL,
  `Lectura_idLectura` INT(11) NOT NULL,
  INDEX `fk_LecturaAltaDemanda_Lectura1_idx` (`Lectura_idLectura` ASC) VISIBLE,
  CONSTRAINT `fk_LecturaAltaDemanda_Lectura1`
    FOREIGN KEY (`Lectura_idLectura`)
    REFERENCES `mydb`.`lectura` (`idLectura`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`lecturabajademanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`lecturabajademanda` (
  `energiaConsumida` DOUBLE NOT NULL,
  `Lectura_idLectura` INT(11) NOT NULL,
  INDEX `fk_LecturaBajaDemanda_Lectura1_idx` (`Lectura_idLectura` ASC) VISIBLE,
  CONSTRAINT `fk_LecturaBajaDemanda_Lectura1`
    FOREIGN KEY (`Lectura_idLectura`)
    REFERENCES `mydb`.`lectura` (`idLectura`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`personafisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`personafisica` (
  `idPersonaFisica` INT(11) NOT NULL,
  `Cliente_idCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idPersonaFisica`),
  INDEX `fk_PersonaFisica_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_personafisica_datospersonales1_idx` (`idPersonaFisica` ASC) VISIBLE,
  CONSTRAINT `fk_PersonaFisica_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`cliente` (`idCliente`),
  CONSTRAINT `fk_personafisica_datospersonales1`
    FOREIGN KEY (`idPersonaFisica`)
    REFERENCES `mydb`.`datospersonales` (`idDatosPersonales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`personajuridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`personajuridica` (
  `idPersonaJuridica` INT(11) NOT NULL AUTO_INCREMENT,
  `cuit` VARCHAR(45) NOT NULL,
  `razonSocial` VARCHAR(45) NOT NULL,
  `Cliente_idCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idPersonaJuridica`),
  INDEX `fk_PersonaJuridica_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  CONSTRAINT `fk_PersonaJuridica_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`cliente` (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`tarifaaltademanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tarifaaltademanda` (
  `Tarifa_idTarifa` INT(11) NOT NULL,
  `horaPico` DOUBLE NOT NULL,
  `horaValle` DOUBLE NOT NULL,
  `resto` DOUBLE NOT NULL,
  `fijo` DOUBLE NOT NULL,
  INDEX `fk_TarifaAltaDemanda_Tarifa1_idx` (`Tarifa_idTarifa` ASC) VISIBLE,
  CONSTRAINT `fk_TarifaAltaDemanda_Tarifa1`
    FOREIGN KEY (`Tarifa_idTarifa`)
    REFERENCES `mydb`.`tarifa` (`idTarifa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`tarifabajademanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tarifabajademanda` (
  `Tarifa_idTarifa` INT(11) NOT NULL,
  `cargoFijo` DOUBLE NOT NULL,
  `variable` DOUBLE NULL DEFAULT NULL,
  INDEX `fk_TarifaBajaDemanda_Tarifa1_idx` (`Tarifa_idTarifa` ASC) VISIBLE,
  CONSTRAINT `fk_TarifaBajaDemanda_Tarifa1`
    FOREIGN KEY (`Tarifa_idTarifa`)
    REFERENCES `mydb`.`tarifa` (`idTarifa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
