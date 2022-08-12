CREATE SCHEMA `student_management` ;

use student_management;

CREATE TABLE `student_management`.`student` (
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Age` INT NOT NULL,
  `Country` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));
