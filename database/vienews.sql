SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `viewnews` ;
CREATE SCHEMA IF NOT EXISTS `viewnews` DEFAULT CHARACTER SET latin1 ;
USE `viewnews` ;

-- -----------------------------------------------------
-- Table `viewnews`.`article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viewnews`.`article` ;

CREATE  TABLE IF NOT EXISTS `viewnews`.`article` (
  `ar_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `ar_us_id` INT(11) NOT NULL ,
  `ar_author` VARCHAR(550) NULL DEFAULT NULL ,
  `ar_title` VARCHAR(450) NOT NULL ,
  `ar_publishedAt` VARCHAR(155) NULL DEFAULT NULL ,
  `ar_content` TEXT NULL DEFAULT NULL ,
  `ar_url` VARCHAR(550) NULL DEFAULT NULL ,
  `ar_urlToImage` VARCHAR(550) NULL DEFAULT NULL ,
  PRIMARY KEY (`ar_id`) ,
  INDEX `as_us_fk` (`ar_us_id` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `viewnews`.`language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viewnews`.`language` ;

CREATE  TABLE IF NOT EXISTS `viewnews`.`language` (
  `la_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `la_name` VARCHAR(200) NOT NULL ,
  PRIMARY KEY (`la_id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `viewnews`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viewnews`.`role` ;

CREATE  TABLE IF NOT EXISTS `viewnews`.`role` (
  `ro_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `ro_name` VARCHAR(95) NOT NULL ,
  PRIMARY KEY (`ro_id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `viewnews`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `viewnews`.`user` ;

CREATE  TABLE IF NOT EXISTS `viewnews`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `us_name` VARCHAR(80) NOT NULL ,
  `us_email` VARCHAR(85) NOT NULL ,
  `us_role` INT(11) NOT NULL ,
  `us_language` INT(11) NOT NULL ,
  `us_password` VARCHAR(85) NOT NULL ,
  `us_blocked` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`us_id`) ,
  UNIQUE INDEX `us_email_UNIQUE` (`us_email` ASC) ,
  INDEX `us_la_id` (`us_language` ASC) ,
  INDEX `us_ro_id` (`us_role` ASC) ,
  CONSTRAINT `us_la_id`
    FOREIGN KEY (`us_language` )
    REFERENCES `viewnews`.`language` (`la_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `us_ro_id`
    FOREIGN KEY (`us_role` )
    REFERENCES `viewnews`.`role` (`ro_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
