/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.32-MariaDB : Database - kasa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kasa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `kasa`;

/*Table structure for table `kasir` */

DROP TABLE IF EXISTS `kasir`;

CREATE TABLE `kasir` (
  `kasirID` bigint(20) NOT NULL AUTO_INCREMENT,
  `korisnickoIme` varchar(255) NOT NULL,
  `lozinka` varchar(255) NOT NULL,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  PRIMARY KEY (`kasirID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `kasir` */

insert  into `kasir`(`kasirID`,`korisnickoIme`,`lozinka`,`ime`,`prezime`) values 
(1,'pedja','pedja123','Predrag','Paravinja'),
(2,'mare','mare123','Marko','Rakulj'),
(3,'nesa','nesa123','Nenad','Paravinja');

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `racunID` bigint(20) NOT NULL AUTO_INCREMENT,
  `brojRacuna` varchar(255) NOT NULL,
  `datum` date NOT NULL,
  `statusRacuna` varchar(255) NOT NULL,
  `poreskaStopa` double NOT NULL,
  `kasirID` bigint(20) NOT NULL,
  PRIMARY KEY (`racunID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `racun` */

insert  into `racun`(`racunID`,`brojRacuna`,`datum`,`statusRacuna`,`poreskaStopa`,`kasirID`) values 
(2,'2','2024-07-20','IZMENJEN',10,2),
(10,'1','2024-04-08','PLACEN_KARTICOM',22,1),
(11,'3','2024-08-20','PLACEN_KARTICOM',213,1),
(12,'5','2024-08-04','PLACEN_KESOM',10,1),
(13,'6','2024-08-04','PLACEN_KESOM',13,1),
(14,'102','2024-08-05','PLACEN_KARTICOM',20,1),
(15,'103','2024-08-05','KREIRAN',24,1),
(16,'104','2024-08-05','PLACEN_KARTICOM',11,1);

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `redniBroj` bigint(20) NOT NULL AUTO_INCREMENT,
  `artikal` varchar(255) NOT NULL,
  `cena` double NOT NULL,
  `kolicina` int(10) NOT NULL,
  `racunID` bigint(20) NOT NULL,
  PRIMARY KEY (`redniBroj`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkaracuna` */

insert  into `stavkaracuna`(`redniBroj`,`artikal`,`cena`,`kolicina`,`racunID`) values 
(19,'Punjac',240,1,10),
(22,'izmena',200,2,11),
(24,'Cips',100,2,12),
(25,'Hemijska',33,3,12),
(26,'Daljinski upravljac',1500,2,12),
(27,'Maramice',200,4,13),
(28,'Sapun',200,5,13),
(30,'K',200,3,14),
(31,'U',100.33,5,14),
(32,'P',203.33,3,15),
(33,'Majica',550.99,4,16);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
