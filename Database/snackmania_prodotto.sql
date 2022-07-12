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
-- Table structure for table `prodotto`
--

DROP TABLE IF EXISTS `prodotto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodotto` (
  `ID_prodotto` int NOT NULL,
  `Quantita` int NOT NULL,
  `Descrizione` varchar(80) DEFAULT NULL,
  `Sconto` int DEFAULT NULL,
  `Nome` varchar(45) NOT NULL,
  `Prezzo` float DEFAULT NULL,
  `Peso` varchar(10) DEFAULT NULL,
  `Marca` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`ID_prodotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodotto`
--

LOCK TABLES `prodotto` WRITE;
/*!40000 ALTER TABLE `prodotto` DISABLE KEYS */;
INSERT INTO `prodotto` VALUES (5,7,'Biscotto al doppio gusto, cioccolato e crema!',NULL,'Oreo',3,'30g','Oreo'),(6,1200,'Hostess Twinkies, Merendine Al Pan\' Di Spagna E Crema',NULL,'Hostess Twinkies',5.5,'385g','Hostess '),(8,40,'Mike and Ike Cherry, caramelle alla ciliegia',0,'Mike and Ike Cherry',0.5,'22g','Cherry'),(10,220,'Una Bevanda Gassata Analcolica Di Tipo Soft Drink.',NULL,'Dr Peppers',3.99,'55ml','Peppers'),(11,220,'Bibita Frizzante gusto Zucchero Filato',NULL,'Candy Can',3.99,'330ml','Candy'),(12,110,'Fries Patatine Barbecue',NULL,'Andy Capp\'s BBQ',1.99,'85g','Andy'),(13,23,'Twix Cookies & Creme con Crema alla vaniglia e pezzetti di biscotto Oreo',NULL,'Twix Cookies',2.99,'50g','Twix'),(14,110,'Twix al Caramello Salato',NULL,'Twix al Caramello',0.99,'35g','Twix'),(15,323,'Fruit Megalong Tape, Chewing Gum Alla Frutta',NULL,'Hubba Bubba',1.99,'33g','Hubba'),(16,890,'Coca Cola al gusto di Vaniglia',NULL,'Coca-Cola',1.99,'355ml','Coca-cola'),(17,220,'Herr\'s Patatine al Formaggio e Peperoncino Carolina Reaper ',NULL,'Herre\'s',1.69,'28g','Herre\'s'),(18,111,'Pizza Cracker, cracker gusto pizza al salame piccante',NULL,'Combos Pepperoni ',1.8,'49g','Combos'),(19,100,'iced tea alla pesca ',NULL,'Dragon Ball Super Gohan',3.99,'500ml','Dragon Ball'),(20,1200,'ICE TEA ULTRA DRAGON BALL',NULL,'Dragon Ball Z Majin Buu',7.99,'330ml','Dragon Ball Z'),(22,1200,'Snickers al burro di arachidi tostate',NULL,'Snickers al burro di arachidi',3.99,'30g','Snickers'),(23,300,'Gustoso gelato all\'oreo!',NULL,'Oreo mickey mouse',2.99,'45g','Oreo');
/*!40000 ALTER TABLE `prodotto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-09 15:11:34
