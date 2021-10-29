-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cinema
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cinema` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) DEFAULT NULL,
  `cinema_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinema`
--

LOCK TABLES `cinema` WRITE;
/*!40000 ALTER TABLE `cinema` DISABLE KEYS */;
INSERT INTO `cinema` VALUES (1,_binary '\0','Cinema 1'),(2,_binary '\0','Cinema 2'),(3,_binary '\0','Cinema 3');
/*!40000 ALTER TABLE `cinema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `film` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `minimum_age` int DEFAULT NULL,
  `price` double NOT NULL,
  `producer` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'Autore 1',_binary '\0',100,'Azione',14,10,'Produttore 1','Film 1'),(2,'Autore 2',_binary '\0',150,'Horror',18,10,'Produttore 2','Film 2');
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hall`
--

DROP TABLE IF EXISTS `hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hall` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) DEFAULT NULL,
  `max_spectators` int DEFAULT NULL,
  `cinema_id` bigint NOT NULL,
  `film_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKte75ikgkdmhfutuupvx2lhknr` (`cinema_id`),
  KEY `FK2xks3p9r1oyylavwr4j2oqe3v` (`film_id`),
  CONSTRAINT `FK2xks3p9r1oyylavwr4j2oqe3v` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`),
  CONSTRAINT `FKte75ikgkdmhfutuupvx2lhknr` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall`
--

LOCK TABLES `hall` WRITE;
/*!40000 ALTER TABLE `hall` DISABLE KEYS */;
INSERT INTO `hall` VALUES (1,_binary '\0',10,1,1);
/*!40000 ALTER TABLE `hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spectator`
--

DROP TABLE IF EXISTS `spectator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spectator` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_of_birth` datetime(6) NOT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `id_spectator` varchar(255) DEFAULT NULL,
  `spectator_name` varchar(255) DEFAULT NULL,
  `spectator_surname` varchar(255) DEFAULT NULL,
  `ticket_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd9qufyu28u281pll31srwqaur` (`ticket_id`),
  CONSTRAINT `FKd9qufyu28u281pll31srwqaur` FOREIGN KEY (`ticket_id`) REFERENCES `ticket` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spectator`
--

LOCK TABLES `spectator` WRITE;
/*!40000 ALTER TABLE `spectator` DISABLE KEYS */;
INSERT INTO `spectator` VALUES (1,'2021-01-09 00:00:00.000000',_binary '\0','123456','Davide','Busterna',NULL),(2,'2010-01-09 00:00:00.000000',_binary '\0','123','Luca','Rossi',NULL);
/*!40000 ALTER TABLE `spectator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) DEFAULT NULL,
  `hall_position` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `hall_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeqlnaerr1lryqwtb1euxudflh` (`hall_id`),
  CONSTRAINT `FKeqlnaerr1lryqwtb1euxudflh` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,_binary '\0','4ad33097-944a-4b69-9c64-476e92d28f3d',10,1),(2,_binary '\0','760f73d4-a459-4409-aa39-d60813b32547',10,1),(3,_binary '\0','c2f4ce4c-6bdb-462f-a1f2-660d1d7960d3',5,1),(4,_binary '\0','e63396e3-7c88-48e0-b4d6-704baf85e101',9,1),(5,_binary '\0','0463ad97-2638-449a-9779-f91c37b110aa',10,1),(6,_binary '\0','fa7b326d-ae65-476c-bee4-6fe437c1e94c',10,1);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-29 16:26:20
