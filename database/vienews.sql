SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `vienews`.`language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vienews`.`language` ;

CREATE  TABLE IF NOT EXISTS `vienews`.`language` (
  `la_id` INT NOT NULL AUTO_INCREMENT ,
  `la_name` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`la_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vienews`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vienews`.`role` ;

CREATE  TABLE IF NOT EXISTS `vienews`.`role` (
  `ro_id` INT NOT NULL AUTO_INCREMENT ,
  `ro_name` VARCHAR(95) NOT NULL ,
  PRIMARY KEY (`ro_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vienews`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vienews`.`user` ;

CREATE  TABLE IF NOT EXISTS `vienews`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT ,
  `us_name` VARCHAR(80) NOT NULL ,
  `us_email` VARCHAR(85) NOT NULL ,
  `us_language` INT NOT NULL ,
  `us_password` VARCHAR(85) NOT NULL ,
  `us_role` INT NOT NULL ,
  PRIMARY KEY (`us_id`) ,
  INDEX `us_la_id` (`us_language` ASC) ,
  INDEX `us_ro_id` (`us_role` ASC) ,
  CONSTRAINT `us_la_id`
    FOREIGN KEY (`us_language` )
    REFERENCES `vienews`.`language` (`la_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `us_ro_id`
    FOREIGN KEY (`us_role` )
    REFERENCES `vienews`.`role` (`ro_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vienews`.`article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vienews`.`article` ;

CREATE  TABLE IF NOT EXISTS `vienews`.`article` (
  `ar_id` INT NOT NULL AUTO_INCREMENT ,
  `ar_us_id` INT NULL ,
  `ar_language` INT NOT NULL ,
  `ar_author` VARCHAR(250) NOT NULL ,
  `ar_title` VARCHAR(250) NOT NULL ,
  `ar_description` TEXT NOT NULL ,
  `ar_publishedAt` VARCHAR(155) NULL ,
  `ar_content` TEXT NULL ,
  `ar_url` VARCHAR(150) NULL ,
  `ar_urlToImage` VARCHAR(250) NULL ,
  PRIMARY KEY (`ar_id`) ,
  INDEX `as_us_fk` (`ar_us_id` ASC) ,
  CONSTRAINT `as_us_fk`
    FOREIGN KEY (`ar_us_id` )
    REFERENCES `vienews`.`user` (`us_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
