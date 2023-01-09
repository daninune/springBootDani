CREATE DATABASE  IF NOT EXISTS `demospring` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `demospring`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: demospring
-- ------------------------------------------------------
-- Server version	5.7.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `provinces`
--

DROP TABLE IF EXISTS `provinces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `provinces` (
  `idProvinces` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `id_provinces` int(11) NOT NULL,
  PRIMARY KEY (`idProvinces`)
) ENGINE=MyISAM AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provinces`
--

LOCK TABLES `provinces` WRITE;
/*!40000 ALTER TABLE `provinces` DISABLE KEYS */;
INSERT INTO `provinces` VALUES (2,'Albacete',0),(3,'Alicante/Alacant',0),(4,'Almería',0),(1,'Araba/Álava',0),(33,'Asturias',0),(5,'Ávila',0),(6,'Badajoz',0),(7,'Balears, Illes',0),(8,'Barcelona',0),(48,'Bizkaia',0),(9,'Burgos',0),(10,'Cáceres',0),(11,'Cádiz',0),(39,'Cantabria',0),(12,'Castellón/Castelló',0),(13,'Ciudad Real',0),(14,'Córdoba',0),(15,'Coruña, A',0),(16,'Cuenca',0),(20,'Gipuzkoa',0),(17,'Girona',0),(18,'Granada',0),(19,'Guadalajara',0),(21,'Huelva',0),(22,'Huesca',0),(23,'Jaén',0),(24,'León',0),(25,'Lleida',0),(27,'Lugo',0),(28,'Madrid',0),(29,'Málaga',0),(30,'Murcia',0),(31,'Navarra',0),(32,'Ourense',0),(34,'Palencia',0),(35,'Palmas, Las',0),(36,'Pontevedra',0),(26,'Rioja, La',0),(37,'Salamanca',0),(38,'Santa Cruz de Tenerife',0),(40,'Segovia',0),(41,'Sevilla',0),(42,'Soria',0),(43,'Tarragona',0),(44,'Teruel',0),(45,'Toledo',0),(46,'Valencia/València',0),(47,'Valladolid',0),(49,'Zamora',0),(50,'Zaragoza',0),(51,'Ceuta',0),(52,'Melilla',0),(-2,' EXTRANJERO',0);
/*!40000 ALTER TABLE `provinces` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-09 10:28:33
