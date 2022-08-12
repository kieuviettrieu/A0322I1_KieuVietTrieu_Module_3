CREATE SCHEMA `student_management` ;

use student_management;

CREATE TABLE `student_management`.`student` (
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Age` INT NOT NULL,
  `Country` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));

CREATE TABLE `student_management`.`class` (
  `ID` INT NOT NULL,
  `class_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `class_name_UNIQUE` (`class_name` ASC) VISIBLE);

CREATE TABLE `student_management`.`teacher` (
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Age` INT NOT NULL,
  `Country` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));