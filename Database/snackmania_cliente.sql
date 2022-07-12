CREATE DATABASE  IF NOT EXISTS `snackmania` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `snackmania`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: snackmania
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `ID_cliente` int NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Cognome` varchar(45) DEFAULT NULL,
  `Email` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Data_Nascita` varchar(45) DEFAULT NULL,
  `Sesso` varchar(2) DEFAULT NULL,
  `Newsletter` tinyint DEFAULT NULL,
  `Stato_Account` varchar(20) DEFAULT NULL,
  `Admin` tinyint DEFAULT '0',
  `Telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Davide','Avella','dav.avella@gmail.com','Ciccio','1999-12-12','M',NULL,NULL,1,NULL),(2,'Mirko','Vitale              ','mirkoz@gmail.com','Mirko','2001-04-17','M',NULL,NULL,1,'3926634834'),(3,'Francesco','Garofalo','giroglafo@gmail.com','giro','2001-12-07','M',NULL,NULL,1,NULL),(4,'Vincenzo','Cerciello','vincerc@gmail.com','vince','2002-02-20','M',NULL,NULL,1,NULL),(12,'Federica','Tucci','fedet@gmail.com','fede','1999-09-01','F',1,'Attivo',0,NULL),(23,'Antonio','Rossi','antrossi2001@hotmail.it','12345','2005-04-17','M',0,'Attivo',0,NULL),(30,'Francesca','Di Maio','francy00@gmail.com','prova123','2000-11-29','F',0,'Attivo',0,NULL),(34,'Renato','Mancini','renmancio@gmail.com','ciao12','1980-02-12','M',0,'Attivo',0,NULL),(35,'Giovanni',NULL,'jhonny@gmail.com','111',NULL,NULL,NULL,NULL,0,NULL),(36,'Marco',NULL,'marco@gmail.com','111',NULL,NULL,NULL,NULL,0,NULL),(37,'Elisa',NULL,'pepp@gmail.com','giuseppe',NULL,NULL,NULL,NULL,0,NULL),(38,'Gerardo','Napolitano','francesco@gmail.com','11',NULL,NULL,NULL,NULL,0,NULL),(39,'Papa','PaoloII','pipino@prete.com','888',NULL,NULL,NULL,NULL,0,NULL),(42,'Francesco','OfGianni','digiann@gmail.com','345',NULL,NULL,NULL,NULL,0,NULL),(43,'Maria Cristina','Rollo  ','m.rollo@gmail.com','1234',NULL,NULL,NULL,NULL,0,'3286456789'),(44,'Riccardo','De Morgan','ricmorgan@gmail.com','12345',NULL,NULL,NULL,NULL,0,NULL);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-09 15:11:33
