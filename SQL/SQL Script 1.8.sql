-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Zona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Zona` (
  `idZona` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idZona`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DatosPersonales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DatosPersonales` (
  `idDatosPersonales` INT NOT NULL AUTO_INCREMENT,
  `dni` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDatosPersonales`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Inspector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Inspector` (
  `idInspector` INT NOT NULL AUTO_INCREMENT,
  `cuil` VARCHAR(45) NOT NULL,
  `DatosPersonales_idDatosPersonales` INT NOT NULL,
  PRIMARY KEY (`idInspector`),
  INDEX `fk_Inspector_DatosPersonales1_idx` (`DatosPersonales_idDatosPersonales` ASC) ,
  CONSTRAINT `fk_Inspector_DatosPersonales1`
    FOREIGN KEY (`DatosPersonales_idDatosPersonales`)
    REFERENCES `mydb`.`DatosPersonales` (`idDatosPersonales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tarifa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tarifa` (
  `idTarifa` INT NOT NULL AUTO_INCREMENT,
  `servicio` VARCHAR(45) NULL,
  PRIMARY KEY (`idTarifa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medidor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Medidor` (
  `nroSerie` INT(11) NOT NULL AUTO_INCREMENT,
  `Cliente_idCliente` INT NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `esBaja` BIT(1) NOT NULL DEFAULT 0,
  `Zona_idZona` INT NOT NULL,
  `Tarifa_idTarifa` INT NOT NULL,
  PRIMARY KEY (`nroSerie`),
  INDEX `fk_Medidor_Tarifa1_idx` (`Tarifa_idTarifa` ASC) ,
  INDEX `fk_Medidor_Zona1_idx` (`Zona_idZona` ASC) ,
  INDEX `fk_Medidor_Cliente1_idx` (`Cliente_idCliente` ASC) ,
  CONSTRAINT `fk_Medidor_Tarifa1`
    FOREIGN KEY (`Tarifa_idTarifa`)
    REFERENCES `mydb`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medidor_Zona1`
    FOREIGN KEY (`Zona_idZona`)
    REFERENCES `mydb`.`Zona` (`idZona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Medidor_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Lectura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Lectura` (
  `idLectura` INT NOT NULL AUTO_INCREMENT,
  `hora` TIME NULL,
  `fecha` DATE NULL,
  `Inspector_idInspector` INT NOT NULL,
  `Medidor_nroSerie` INT(11) NULL,
  PRIMARY KEY (`idLectura`),
  INDEX `fk_Lectura_Inspector1_idx` (`Inspector_idInspector` ASC) ,
  INDEX `fk_Lectura_Medidor1_idx` (`Medidor_nroSerie` ASC) ,
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
CREATE TABLE IF NOT EXISTS `mydb`.`LecturaBajaDemanda` (
  `idLecturaBajaDemanda` INT NOT NULL,
  `energiaConsumida` DOUBLE NULL,
  INDEX `fk_LecturaBajaDemanda_Lectura1_idx` (`idLecturaBajaDemanda` ASC) ,
  PRIMARY KEY (`idLecturaBajaDemanda`),
  CONSTRAINT `fk_LecturaBajaDemanda_Lectura1`
    FOREIGN KEY (`idLecturaBajaDemanda`)
    REFERENCES `mydb`.`Lectura` (`idLectura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LecturaAltaDemanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`LecturaAltaDemanda` (
  `idLecturaAltaDemanda` INT NOT NULL,
  `energiaContratada` DOUBLE NULL,
  `tipoTension` VARCHAR(45) NULL,
  `horaPico` DOUBLE NULL,
  `horaValle` DOUBLE NULL,
  `resto` DOUBLE NULL,
  INDEX `fk_LecturaAltaDemanda_Lectura1_idx` (`idLecturaAltaDemanda` ASC) ,
  PRIMARY KEY (`idLecturaAltaDemanda`),
  CONSTRAINT `fk_LecturaAltaDemanda_Lectura1`
    FOREIGN KEY (`idLecturaAltaDemanda`)
    REFERENCES `mydb`.`Lectura` (`idLectura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TarifaBaja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TarifaBaja` (
  `idTarifaBaja` INT NOT NULL,
  INDEX `fk_TarifaBaja_Tarifa1_idx` (`idTarifaBaja` ASC) ,
  PRIMARY KEY (`idTarifaBaja`),
  CONSTRAINT `fk_TarifaBaja_Tarifa1`
    FOREIGN KEY (`idTarifaBaja`)
    REFERENCES `mydb`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DetalleBaja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DetalleBaja` (
  `idDetalleBaja` INT NOT NULL AUTO_INCREMENT,
  `detalleConceptos` VARCHAR(45) NOT NULL,
  `unidad` VARCHAR(45) NOT NULL,
  `desde` INT NOT NULL,
  `hasta` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `TarifaBaja_idTarifaBaja` INT NOT NULL,
  INDEX `fk_TarifaAltaDemanda_TarifaBaja1_idx` (`TarifaBaja_idTarifaBaja` ASC) ,
  PRIMARY KEY (`idDetalleBaja`),
  CONSTRAINT `fk_TarifaAltaDemanda_TarifaBaja1`
    FOREIGN KEY (`TarifaBaja_idTarifaBaja`)
    REFERENCES `mydb`.`TarifaBaja` (`idTarifaBaja`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TarifaAlta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TarifaAlta` (
  `idTarifaAlta` INT NOT NULL,
  `tensionContratada` VARCHAR(2) NOT NULL,
  `limite` INT NOT NULL,
  INDEX `fk_TarifaAlta_Tarifa1_idx` (`idTarifaAlta` ASC) ,
  PRIMARY KEY (`idTarifaAlta`),
  CONSTRAINT `fk_TarifaAlta_Tarifa1`
    FOREIGN KEY (`idTarifaAlta`)
    REFERENCES `mydb`.`Tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DetalleAlta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DetalleAlta` (
  `idDetalleAlta` INT NOT NULL AUTO_INCREMENT,
  `detalleConceptos` VARCHAR(45) NOT NULL,
  `unidad` VARCHAR(45) NOT NULL,
  `superaLimite` TINYINT(1) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `TarifaAlta_idTarifaAlta` INT NOT NULL,
  INDEX `fk_TarifaBajaDemanda_TarifaAlta1_idx` (`TarifaAlta_idTarifaAlta` ASC) ,
  PRIMARY KEY (`idDetalleAlta`),
  CONSTRAINT `fk_TarifaBajaDemanda_TarifaAlta1`
    FOREIGN KEY (`TarifaAlta_idTarifaAlta`)
    REFERENCES `mydb`.`TarifaAlta` (`idTarifaAlta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PersonaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PersonaFisica` (
  `idPersonaFisica` INT NOT NULL AUTO_INCREMENT,
  `DatosPersonales_idDatosPersonales` INT NOT NULL,
  INDEX `fk_PersonaFisica_Cliente1_idx` (`idPersonaFisica` ASC) ,
  INDEX `fk_PersonaFisica_DatosPersonales1_idx` (`DatosPersonales_idDatosPersonales` ASC) ,
  PRIMARY KEY (`idPersonaFisica`),
  CONSTRAINT `fk_PersonaFisica_Cliente1`
    FOREIGN KEY (`idPersonaFisica`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaFisica_DatosPersonales1`
    FOREIGN KEY (`DatosPersonales_idDatosPersonales`)
    REFERENCES `mydb`.`DatosPersonales` (`idDatosPersonales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PersonaJuridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PersonaJuridica` (
  `idPersonaJuridica` INT NOT NULL AUTO_INCREMENT,
  `cuit` VARCHAR(45) NOT NULL,
  `razonSocial` VARCHAR(45) NOT NULL,
  INDEX `fk_PersonaJuridica_Cliente1_idx` (`idPersonaJuridica` ASC) ,
  PRIMARY KEY (`idPersonaJuridica`),
  CONSTRAINT `fk_PersonaJuridica_Cliente1`
    FOREIGN KEY (`idPersonaJuridica`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Inspector_has_Zona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Inspector_has_Zona` (
  `Inspector_idInspector` INT NOT NULL,
  `Zona_idZona` INT NOT NULL,
  PRIMARY KEY (`Inspector_idInspector`, `Zona_idZona`),
  INDEX `fk_Inspector_has_Zonas_Zonas1_idx` (`Zona_idZona` ASC) ,
  INDEX `fk_Inspector_has_Zonas_Inspector1_idx` (`Inspector_idInspector` ASC) ,
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


-- -----------------------------------------------------
-- Table `mydb`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `nroSerieMedidor` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `observaciones` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idFactura`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ItemFactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ItemFactura` (
  `idItemFactura` INT NOT NULL AUTO_INCREMENT,
  `detalle` VARCHAR(45) NOT NULL,
  `precioUnitario` DOUBLE NOT NULL,
  `cantidad` INT NOT NULL,
  `unidad` VARCHAR(45) NOT NULL,
  `Factura_idFactura` INT NOT NULL,
  PRIMARY KEY (`idItemFactura`),
  INDEX `fk_ItemFactura_Factura1_idx` (`Factura_idFactura` ASC) ,
  CONSTRAINT `fk_ItemFactura_Factura1`
    FOREIGN KEY (`Factura_idFactura`)
    REFERENCES `mydb`.`Factura` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
