-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema forum
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema forum
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `forum` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `forum` ;

-- -----------------------------------------------------
-- Table `forum`.`notes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forum`.`notes` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(255) NULL DEFAULT NULL,
  `created_at` DATETIME NOT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `forum`.`question_reply_map`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forum`.`question_reply_map` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `qust_id` INT(11) NOT NULL,
  `parent_reply_id` INT(11) NULL DEFAULT NULL,
  `reply_id` INT(11) NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `forum`.`question_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forum`.`question_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `question` TEXT NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `modified_at` DATETIME NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `forum`.`reply_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forum`.`reply_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `reply` TEXT NULL DEFAULT NULL,
  `user_id` INT(11) NULL DEFAULT NULL,
  `modified_at` DATETIME NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `forum`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `forum`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `display_name` VARCHAR(45) NOT NULL,
  `email_id` VARCHAR(100) NOT NULL,
  `created_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
