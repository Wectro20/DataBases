-- MySQL Script generated by MySQL Workbench
-- Wed Sep 29 19:12:02 2021
-- Model: New Model    Version: 1.0
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
-- Table `mydb`.`weather_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`weather_status` ;

CREATE TABLE IF NOT EXISTS `mydb`.`weather_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `weather_st` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`weather_warning`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`weather_warning` ;

CREATE TABLE IF NOT EXISTS `mydb`.`weather_warning` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`city` ;

CREATE TABLE IF NOT EXISTS `mydb`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`country` ;

CREATE TABLE IF NOT EXISTS `mydb`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`weather_daily_forecast`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`weather_daily_forecast` ;

CREATE TABLE IF NOT EXISTS `mydb`.`weather_daily_forecast` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country_daily_id` INT NOT NULL,
  `city_daily_id` INT NOT NULL,
  `weather_daily_status_id` INT NOT NULL,
  `weather_daily_warning_id` INT NOT NULL,
  `start_timestamp` TIMESTAMP(2) NOT NULL,
  `end_timestamp` TIMESTAMP(2) NOT NULL,
  `temperature` FLOAT NOT NULL,
  `feels_like_temperature` FLOAT NOT NULL,
  `humidity_in_percentage` FLOAT NOT NULL,
  `wind_speed_in_mph` FLOAT NOT NULL,
  `wind_direction` CHAR NOT NULL,
  `day` ENUM('MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN') NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `weather_status_ id_idx` (`weather_daily_status_id` ASC) VISIBLE,
  INDEX `weather_warning_id_idx` (`weather_daily_warning_id` ASC) VISIBLE,
  INDEX `city_id_idx` (`city_daily_id` ASC) VISIBLE,
  INDEX `country_daily_id_idx` (`country_daily_id` ASC) VISIBLE,
  CONSTRAINT `weather_daily_status_id`
    FOREIGN KEY (`weather_daily_status_id`)
    REFERENCES `mydb`.`weather_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `weather_daily_warning_id`
    FOREIGN KEY (`weather_daily_warning_id`)
    REFERENCES `mydb`.`weather_warning` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `city_daily_id`
    FOREIGN KEY (`city_daily_id`)
    REFERENCES `mydb`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `country_daily_id`
    FOREIGN KEY (`country_daily_id`)
    REFERENCES `mydb`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`weather_weekly_forecast`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`weather_weekly_forecast` ;

CREATE TABLE IF NOT EXISTS `mydb`.`weather_weekly_forecast` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country_weakly_id` INT NOT NULL,
  `city_weakly_id` INT NOT NULL,
  `weather_weakly_status_id` INT NOT NULL,
  `weather_weakly_warning_id` INT NOT NULL,
  `calendar_date` DATE NOT NULL,
  `min_temperature` FLOAT NOT NULL,
  `max_temperature` FLOAT NOT NULL,
  `avg_humidity_in_parcentage` FLOAT NOT NULL,
  `sunrise_time` TIMESTAMP NOT NULL,
  `sunset_time` TIMESTAMP NOT NULL,
  `last_updated_at` TIMESTAMP NOT NULL,
  `source_system` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `weather_status_id_idx` (`weather_weakly_status_id` ASC) VISIBLE,
  INDEX `country_id_idx` (`country_weakly_id` ASC) VISIBLE,
  INDEX `weather_warning_idx` (`weather_weakly_warning_id` ASC) VISIBLE,
  INDEX `city_id_idx` (`city_weakly_id` ASC) VISIBLE,
  CONSTRAINT `weather_weekly_status_id`
    FOREIGN KEY (`weather_weakly_status_id`)
    REFERENCES `mydb`.`weather_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `country_weakly_id`
    FOREIGN KEY (`country_weakly_id`)
    REFERENCES `mydb`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `weather_weakly_warning_id`
    FOREIGN KEY (`weather_weakly_warning_id`)
    REFERENCES `mydb`.`weather_warning` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `city_weakly_id`
    FOREIGN KEY (`city_weakly_id`)
    REFERENCES `mydb`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
